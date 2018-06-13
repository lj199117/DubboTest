package com.dubbo.app;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dubbo.service.DemoService;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:/spring/app.xml" });
		context.start();
		
//		MsgService svc = (MsgService) context.getBean("msgService");
//		UserMsgFrontParam param = new UserMsgFrontParam();
//    	param.setUserId(100000002);
//    	UserMsgRedPoint msg = svc.queryUserMsgRedPoint(param);
//    	System.err.println(msg);
		
		DemoService svc = context.getBean(DemoService.class);
		System.out.println(svc.sayHello("lijin"));
		
		System.in.read(); // 保障服务一直运行,利用输入流进行阻塞
	}
}
