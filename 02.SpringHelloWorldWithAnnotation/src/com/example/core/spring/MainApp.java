package com.example.core.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author kumars91
 *
 */
public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		helloWorld.sayHello();
	}
}