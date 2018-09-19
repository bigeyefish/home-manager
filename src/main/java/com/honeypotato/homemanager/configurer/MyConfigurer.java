package com.honeypotato.homemanager.configurer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.honeypotato.homemanager.dao")
public class MyConfigurer {
}
