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
		ServiceWithFactoryMethod serviceWithFactoryMethod = context.getBean("serviceWithFactoryMethod", ServiceWithFactoryMethod.class);
		ServiceWithFactoryBean serviceWithFactoryBean = context.getBean("serviceWithFactoryBean", ServiceWithFactoryBean.class);
		serviceWithFactoryMethod.serve();
		serviceWithFactoryMethod.serve();
		serviceWithFactoryBean.serve();
		serviceWithFactoryBean.serve();
	}
}