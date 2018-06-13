package com.dubbo.test;

import com.dubbo.service.DemoService;

public class DemoServiceImpl implements DemoService {

	public String sayHello(String name, Throwable throwable) throws Throwable{
		Exception e = null;
		/*try {
			int i = 1/0;
		} catch (Throwable t) {
			e = new Exception(t);
		}*/

		if(throwable != null) {
			if(e == null) {
				e = new Exception(throwable);
			} else {
				e.addSuppressed(throwable);
			}
		}

//		if("myex".equals(name)) {
//			throw new MyException("throws my exception");
//		}

		if(e != null) {
			throw e;
		}

		return "Hello," + name;
	}

}
