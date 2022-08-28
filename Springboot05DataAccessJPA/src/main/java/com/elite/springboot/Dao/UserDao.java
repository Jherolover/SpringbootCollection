package com.elite.springboot.Dao;

import com.elite.springboot.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * 编写一个UserDao接口来操作实体类User对应的数据表
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

}
