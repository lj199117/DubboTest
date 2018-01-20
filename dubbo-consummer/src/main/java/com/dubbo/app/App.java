package com.dubbo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.DemoService;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:/spring/app.xml" });
		context.start();
		
		DemoService svc = (DemoService) context.getBean("demoService");
		String hello = svc.sayHello("lijin");
		System.out.println(hello);
	}
}
