package com.design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy(exposeProxy=true)
public class StartupDemoApplication {
	public static void main(String[] args) {
		//启动服务
		ApplicationContext context =SpringApplication.run(StartupDemoApplication.class, args);
	}
}
