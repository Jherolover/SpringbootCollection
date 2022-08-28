package com.elite.springboot.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取配置的属性
 *
 * @Value("${属性名}")
 */
@Component
public class PropertyValue {
    @Value("${springbootproperties.author}")
    private String author;
    @Value("${springbootproperties.name}")
    private String name;

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
