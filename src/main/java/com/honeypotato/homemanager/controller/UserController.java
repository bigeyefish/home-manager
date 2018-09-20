package com.honeypotato.homemanager.controller;

import com.honeypotato.homemanager.common.RetFactory;
import com.honeypotato.homemanager.common.model.RetResult;
import com.honeypotato.homemanager.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@Api(tags = {"用户接口"}, description = "userController")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "查询用户", notes = "根据用户ID查询用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping("{id}")
    public RetResult queryById(@PathVariable int id) {
        return RetFactory.success(service.queryById(id));
    }

    @ApiOperation(value = "查询用户列表", notes = "根据用户列表数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int", paramType = "path"),
            @ApiImplicitParam(name = "size", value = "每页数量", required = true, dataType = "int", paramType = "path")
    })
    @GetMapping("{page}/{size}")
    public RetResult queryList(@PathVariable int page, @PathVariable int size) {
        return RetFactory.success(service.queryList(page, size));
    }
}
