package com.honeypotato.homemanager.configurer;

import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

@Configuration
@MapperScan("com.honeypotato.homemanager.dao")
public class MyConfigurer {
}
