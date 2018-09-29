package com.honeypotato.homemanager.common;

import com.honeypotato.homemanager.model.User;
import org.apache.shiro.SecurityUtils;

/**
 * 工具类
 *
 * @author sanyihwang.
 * created on 2018/9/29
 **/
public class SysUtil {

    /**
     * 获取当前线程的用户id
     * @return userId
     */
    public static String currentUserId() {
        String userId = "";
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (null != user) {
            userId = user.getId();
        }
        return userId;
    }
}
