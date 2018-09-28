package com.honeypotato.homemanager.dao;

import com.honeypotato.homemanager.common.Mapper;
import com.honeypotato.homemanager.model.Resource;

import java.util.List;

public interface ResourceMapper extends Mapper<Resource> {

    List<Resource> selectAllOrderBySort();
}