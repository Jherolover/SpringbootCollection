package com.elite.springboot.controller;

import com.elite.springboot.entity.PropertyConfig;
import com.elite.springboot.entity.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/configuration")
@RestController
public class ConfigurationController {

    //注解引入
    @Autowired
    PropertyValue propertyValue;

    @Autowired
    PropertyConfig propertyConfig;

    @GetMapping("/properties1")
    public String GetConfiguration(){
        return propertyValue.toString();
    }
    @GetMapping("/properties2")
    public String GetConfigurationProperty(){
        return propertyConfig.toString();
    }
}
