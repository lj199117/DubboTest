package com.dubbo.app;

import com.dubbo.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	static ClassPathXmlApplicationContext context = null;
	static {
		context = new ClassPathXmlApplicationContext(new String[] { "classpath:/spring/app.xml" });
		context.start();
	}
	public static void main(String[] args) throws Exception {

		
//		MsgService svc = (MsgService) context.getBean("msgService");
//		UserMsgFrontParam param = new UserMsgFrontParam();
//    	param.setUserId(100000002);
//    	UserMsgRedPoint msg = svc.queryUserMsgRedPoint(param);
//    	System.err.println(msg);

//		getResult("lijin", new RuntimeException("RuntimeException")); // Throwable 都是实现了serielizable接口的
		getResult("myex", new RuntimeException("RuntimeException"));

//		System.in.read(); // 保障服务一直运行,利用输入流进行阻塞
	}

	public static String getResult(String name, Throwable t) {
		DemoService svc = context.getBean(DemoService.class);
		String result = null;
		try {
			result = svc.sayHello(name, t);
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return result;
	}
}
