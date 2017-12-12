package com.example.core.spring;

public class ServiceWithFactoryMethod {

	private static ServiceWithFactoryMethod myService;
	
	private ServiceWithFactoryMethod() {
		System.out.println("ServiceWithFactoryMethod is created");
	}
	
	public static ServiceWithFactoryMethod getInstance(){
		if(myService == null){
			myService = new ServiceWithFactoryMethod();
		}
		return myService;
	}
	
	public void serve(){
		System.out.println("Here is your service using ServiceWithFactoryMethod!!!");
	}

}
