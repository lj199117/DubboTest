package com.dubbo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService{

	public String sayHello(String name) {
		return "Hello," + name;
	}

}
