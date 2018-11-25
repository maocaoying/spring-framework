package mcy.spring.ioc.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String path = "mcy/spring/bean/beans.xml";
		ApplicationContext alc = new ClassPathXmlApplicationContext(path);

		Car car = (Car) alc.getBean("car");
		System.out.println(car);

		Car2 car2 = (Car2) alc.getBean("car2");
		car2.info();
	}
}
