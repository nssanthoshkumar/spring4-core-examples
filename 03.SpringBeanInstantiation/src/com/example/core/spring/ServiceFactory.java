package com.example.core.spring;

public class ServiceFactory {

	private static ServiceWithFactoryBean serviceWithFactoryBean;
	
	public ServiceWithFactoryBean getInstance(){
		if(serviceWithFactoryBean == null){
			serviceWithFactoryBean = new ServiceWithFactoryBean();
		}
		return serviceWithFactoryBean;
	}
}
