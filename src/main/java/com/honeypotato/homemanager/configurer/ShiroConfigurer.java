package com.honeypotato.homemanager.configurer;

import com.honeypotato.homemanager.auth.CustomRealm;
import com.honeypotato.homemanager.model.Resource;
import com.honeypotato.homemanager.service.ResourceService;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * shiro启动配置类
 *
 * @author sanyihwang.
 * created on 2018/9/27
 **/
@Configuration
public class ShiroConfigurer {

    /**
     * 注入自定义的realm，告诉shiro如何获取用户信息来做登录或权限控制
     * @return
     */
    @Bean
    public Realm realm() {
       return new CustomRealm();
    }

    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        /**
         * setUsePrefix(false)用于解决一个奇怪的bug。在引入spring aop的情况下。
         * 在@Controller注解的类的方法中加入@RequiresRole注解，会导致该方法无法映射请求，导致返回404。
         * 加入这项配置能解决这个bug
         */
        creator.setUsePrefix(true);
        return creator;
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(ResourceService resourceService) {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        for (Resource resource : resourceService.selectAllOrderBySort()) {
            chainDefinition.addPathDefinition(resource.getUrl(), resource.getAuthorize());
        }
        // chainDefinition.addPathDefinition("/api/user/**", "authc, roles[admin]");
        // chainDefinition.addPathDefinition("/login", "anon");
        // chainDefinition.addPathDefinition("/logout", "anon");
        // chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }
}
