package com.honeypotato.homemanager.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.honeypotato.homemanager.dao.UserMapper;
import com.honeypotato.homemanager.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据主键查询用户
     * @param id
     * @return
     */
    public User queryById(int id) {
        return userMapper.selectById(id);
    }

    public List<User> queryList() {
        int pageNum = 1;
        int pageSize = 2;
        Page<User> page = PageHelper.startPage(pageNum, pageSize);
        return userMapper.queryUserList();
    }

}
