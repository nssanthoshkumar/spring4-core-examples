package com.example.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kumars91
 *
 */
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		helloWorld.sayHello();
	}
}