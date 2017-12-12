package com.example.core.spring;

public class ServiceWithFactoryBean {

	public ServiceWithFactoryBean() {
		System.out.println("ServiceWithFactoryBean is created");
	}
	
	public void serve(){
		System.out.println("Here is your service using ServiceFactory!!!");
	}

}
