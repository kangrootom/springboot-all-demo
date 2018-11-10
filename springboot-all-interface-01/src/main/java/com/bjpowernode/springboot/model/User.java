package com.bjpowernode.springboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User implements Serializable {
    private Integer id;

    private String nick;

    private String phone;

    private String address;

    private String email;
}
