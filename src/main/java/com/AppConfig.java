package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan("com")
@EnableAspectJAutoProxy
@Configuration
@EnableTransactionManagement
public class AppConfig { // AppConfig 代理对象




}
