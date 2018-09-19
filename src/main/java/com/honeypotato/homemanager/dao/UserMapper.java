package com.honeypotato.homemanager.dao;

import com.honeypotato.homemanager.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User selectById(Integer id);

    @Select("SELECT * FROM USER")
    List<User> queryUserList();
}