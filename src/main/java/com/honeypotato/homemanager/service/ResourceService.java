package com.honeypotato.homemanager.service;

import com.honeypotato.homemanager.dao.ResourceMapper;
import com.honeypotato.homemanager.model.Resource;
import com.honeypotato.homemanager.service.base.AbstractServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限资源服务类
 *
 * @author sanyihwang.
 * created on 2018/9/28
 **/
@Service
public class ResourceService extends AbstractServiceImpl<Resource> {

    @javax.annotation.Resource
    private ResourceMapper resourceMapper;

    public List<Resource> selectAllOrderBySort() {
        return resourceMapper.selectAllOrderBySort();
    }

}
