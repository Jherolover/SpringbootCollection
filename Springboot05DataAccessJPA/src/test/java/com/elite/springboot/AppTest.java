package com.elite.springboot;



import com.elite.springboot.Dao.UserDao;
import com.elite.springboot.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试User CRUD
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

    @Resource
    private UserDao userDao;

    /**
     * 测试新增User
     * @throws Exception
     */
    @Test
    public void insertUser(){
        //select * from user
        //插入的sql日志：insert into user (address, age, user_name) values (?, ?, ?)
        User user = new User();
        user.setUsername("牛奶糖");
        user.setAge(22);
        user.setAddress("xx省市");
        User save = userDao.save(user);
    }

    /**
     * 更新User
     * @throws Exception
     */
    @Test
    public void updateUser() {
        //更新也是调用save方法
        //update user set address=?, age=?, user_name=? where id=?
        User user = new User();
        user.setUsername("牛奶糖");
        user.setId(1);
        user.setAge(24);
        user.setAddress("xx省市");
        userDao.save(user);
    }

    /**
     * 查询用户
     * @throws Exception
     */
    @Test
    public void getUser() {
        User user = userDao.getOne(1);
        System.out.println(user);

    }

    /**
     * 查询用户列表
     */
    @Test
    public void getUserList()  {
        //select user0_.id as id1_0_, user0_.address as address2_0_, user0_.age as age3_0_, user0_.user_name as user_nam4_0_ from user user0_
        List<User> userList = userDao.findAll();
        for (User user:userList){
            System.out.println(user);
        }
        //User(id=1, username=牛奶糖, age=24, address=xx省市)
        //User(id=2, username=tom, age=22, address=guangzhou)
    }
    /**
     * 删除用户
     */
    @Test
    public void DelUser()  {
        //delete from user where id=?
       userDao.deleteById(2);
    }
}
