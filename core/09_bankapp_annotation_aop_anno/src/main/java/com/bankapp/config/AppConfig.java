package com.bankapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.bankapp"})
@EnableAspectJAutoProxy //<aop:aspectj-autoproxy/>
public class AppConfig {

}
