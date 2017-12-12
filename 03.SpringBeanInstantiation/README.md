### Spring - Instantiating beans example


Spring beans are objects that are managed by a Spring IoC container.  Spring IoC container manage one or more beans and these bean are supplied to container in the form of XML configuration metadata.

In spring framework, IoC container can instantiate a bean by using-

- A constructor
- A static factory method
- An instance factory method
- Instantiating bean using a constructor


The Spring IoC container creates a new bean by calling the default (no-argument) constructor of a class specified by the class attribute of <bean/> element in XML configuration metadata. 

### The following is a bean class with default constructor.

MyBean.java
```bash
package com.tutorial.spring;

/**
 * @author nssanthoshkumar
 */
public class MyBean {

   public MyBean() {
      System.out.println("MyBean is initialized!!");
   }

   public void saySomething() {
      System.out.println("I'm inside saySomething() method.");
   }
}
```
Here is an XML configuration metadata where we can specify our bean as follows.

beans.xml
```bash
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="myBean" class="com.tutorial.spring.MyBean" />

</beans>
```
MainApp.java
```bash
package com.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nssanthoshkumar
 */
public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		MyBean bean=context.getBean("myBean", MyBean.class);
		bean.saySomething();
	}

}
```
Output
```bash
MyBean is initialized!!
I'm inside saySomething() method.
```

### Instantiating bean using a static factory method
In this mechanism, the Spring IoC container creates a new bean by calling the static factory method of a class specified by the class attribute of <bean/> element in XML configuration metadata.

The attribute factory-method of </bean> element specify the name of static method. 

The following is a class with static factory method.

MyService.java

package com.tutorial.spring;

/**
 * @author nssanthoshkumar
 */
public class MyService {

   private static MyService myService;

   private MyService() {
      System.out.println("Inside MyService private constructor. ");
   }

   // Static factory method
   public static MyService getInstance() {
      if (myService == null) {
         myService = new MyService();
      }
      return myService;
   }

   public void doSomething() {
      System.out.println("Inside doSomething method");
   }
}
XML configuration metadata where we can specify our static factory method as follows.

beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean id="myService" class="com.tutorial.spring.MyService" factory-method="getInstance"/>
</beans>
MainApp.java

package com.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nssanthoshkumar
 */
public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
      MyService myService = context.getBean("myService", MyService.class);
      myService.doSomething();
   }

}
Output

Inside MyService private constructor. 
Inside doSomething method
 
Instantiating bean using an instance factory method
Similar to instantiating through static factory method, the Spring IoC container invokes a non-static method of an existing bean from the container to create a new bean.

Here is a class with an instance factory method.

MyService.java

package com.tutorial.spring;

/**
 * @author nssanthoshkumar
 */
public class MyService {

   private MyService() {
      System.out.println("Inside MyService private constructor.");
   }

   // Instance factory method
   public MyService createService() {
      return new MyService();
   }

   public void doSomething() {
      System.out.println("Inside doSomething method");
   }
}
XML configuration metadata where we have specified our instance factory method with factory-bean and factory-method attributes of </bean> element.

beans.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<bean id="myServiceLocator" class="com.tutorial.spring.MyService"/>
	<bean id="myService" factory-bean="myServiceLocator" factory-method="createService"/>
	
</beans>
MainApp.java
```bash
package com.tutorial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nssanthoshkumar
 */
public class MainApp {
   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
      MyService myService = context.getBean("myService", MyService.class);
      myService.doSomething();
   }

}
```

Output
```bash
Inside MyService private constructor.
Inside MyService private constructor.
Inside doSomething method
```