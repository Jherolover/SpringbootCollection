package com.elite.springboot.Entity;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.persistence.*;


//使用JPA注解配置映射关系
@Entity //告诉JPA这是一个实体类（和数据表映射的类）
@Table(name = "user") //@Table,指定表明，不指定默认和类名字一样
@Getter
@Setter
@Data
public class User {
    @javax.persistence.Id
    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;
    @Column(name = "user_name", length = 50) //这是和数据表对应的一个列
    private String username;
    @Column(name = "age", length = 3) //这是和数据表对应的一个列
    private Integer age;
    @Column //省略默认列名就是属性名
    private String address;

}

