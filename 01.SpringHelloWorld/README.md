# Spring - Hello world example
We will learn how to create a simple Spring application using Eclipse IDE and Maven build tool.

### Technologies used for this application are -
Spring 4.3.4.RELEASE
Eclipse Mars.2 (4.5.2)
Maven 3.3.9
JavaSE 1.8

### Step 1 - Create a Java Project
Go to File  menu → New → Other → Java → Java Project

In New Java Project wizard, just add Project Name as SpringHelloWorld and click on Finish.

 

### Step 2 - Convert Java Project to Maven
Right click on SpringHelloWorld project → Configure → Convert to Maven Project.

Please refer the below link to learn more about conversion of Java project to maven project.

http://www.boraji.com/how-to-convert-java-project-to-maven-project-in-eclipse

 

### Step 3 – Add Spring dependency to Maven pom.xml
Open pom.xml file and add required spring dependency to it. Here is the pom.xml file.

pom.xml
```bash
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>SpringHelloWorld</groupId>
	<artifactId>SpringHelloWorld</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>SpringHelloWorld</name>
	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.3.4.RELEASE</version>
		</dependency>
	</dependencies>
	<build>
		<sourceDirectory>src</sourceDirectory>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.5.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```

### Step 4 – Create a Spring bean class
Let's create our first spring bean class under com.boraji.tutorial.spring package and write the following code in it.

HelloWorld.java
```bash
package com.boraji.tutorial.spring;

/**
 * @author imssbora
 */
public class HelloWorld {
	public void sayHello() {
		System.out.println("Hello Spring!!");
	}
}
``` 
### Step 5 – Create a bean configuration file
Create an xml file, named as beans.xml, under resources folder and write the following code in it.

beans.xml
```bash
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean id="helloWorld" class="com.boraji.tutorial.spring.HelloWorld" />
	
</beans>
```
### Step 6 – Create a main class
Now create a main class under com.boraji.tutorial.spring package as shown below.

MainApp.java
```bash
package com.boraji.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author imssbora
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		HelloWorld helloWorldBean = context.getBean("helloWorld", HelloWorld.class);
		helloWorldBean.sayHello();
	}
}
``` 

### Step 7 – Run application
Right click on MainApp.java → Run as → Java Application.

#### Output
Hello Spring!!
