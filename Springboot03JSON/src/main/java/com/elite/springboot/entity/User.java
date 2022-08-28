package com.elite.springboot.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//用户
@Data
@Getter
@Setter
public class User {

    private String userName;
    private Integer age;
    private String address;



}
