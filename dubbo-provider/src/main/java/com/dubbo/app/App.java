package com.dubbo.app;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:/spring/app.xml" });
		context.start();
		System.in.read(); // 保障服务一直运行,利用输入流进行阻塞
	}
}
