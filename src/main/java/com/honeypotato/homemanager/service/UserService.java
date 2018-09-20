package com.honeypotato.homemanager.service;

import com.github.pagehelper.PageInfo;
import com.honeypotato.homemanager.common.Mapper;
import com.honeypotato.homemanager.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Log4j2(topic = "user")
public class UserService {

    @Resource
    private Mapper<User> userMapper;
//    private UserMapper userMapper;

    /**
     * 根据主键查询用户
     * @param id
     * @return
     */
    public User queryById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public PageInfo<User> queryList(int page, int size) {
        // PageHelper.startPage(page, size);
        List<User> users = userMapper.selectAll(page, size);
        return new PageInfo<>(users);
    }

}
