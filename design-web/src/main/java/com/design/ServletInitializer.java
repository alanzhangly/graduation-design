package com.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 类似web.xml中初始化Spring上下文的监听器功能，这样就不用写xml配置了
 *
 */
public class ServletInitializer extends SpringBootServletInitializer {
	
	private  static  final Logger logger= LoggerFactory.getLogger(ServletInitializer.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		logger.info("开始启动spring boot 配置初始化");
		return application.sources(StartupDemoApplication.class);
	}

}
