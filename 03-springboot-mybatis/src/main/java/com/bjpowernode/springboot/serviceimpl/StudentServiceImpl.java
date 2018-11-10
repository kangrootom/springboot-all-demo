package com.bjpowernode.springboot.serviceimpl;

import com.bjpowernode.springboot.mapper.StudentMapper;
import com.bjpowernode.springboot.model.Student;
import com.bjpowernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    /**注入springboot自动配置好的RedisTemplate*/
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StudentMapper studentMapper;

    @Transactional
    @Override
    public int updateByPrimaryKey() {
        Student stu = new Student();
        stu = studentMapper.selectByPrimaryKey(3);
        stu.setName(stu.getName()+"-update");
        stu.setAge(22);
        int update = studentMapper.updateByPrimaryKey(stu);
        //int i = 10/0;
        return  update;
    }

    @Override
    public List<Student> findAll() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
       /* List<Student> students  = (List<Student>) redisTemplate.opsForValue().get("allStudents");

        if(null==students){
            System.out.println("查询了数据库。。。。。");
            students = studentMapper.findAll();
            redisTemplate.opsForValue().set("allStudents",students);
        }else {
            System.out.println("查询了缓存");
        }*/

       //加入同步代码后，只有第一个查询数据库
        List<Student> students  = (List<Student>) redisTemplate.opsForValue().get("allStudents");

        if(null==students){

            synchronized (this){
                students  = (List<Student>) redisTemplate.opsForValue().get("allStudents");
                if(null==students){
                    System.out.println("查询了数据库。。。。。");
                    students = studentMapper.findAll();
                    redisTemplate.opsForValue().set("allStudents",students);
                }else {
                    System.out.println("查询了缓存");
                }
            }
        }else{
            System.out.println("查询了缓存");
        }

        return students;
    }

}
