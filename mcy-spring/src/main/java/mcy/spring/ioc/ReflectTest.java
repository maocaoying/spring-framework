package mcy.spring.ioc;

import mcy.spring.ioc.beans.Car;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

	private static Car initByDefaultConst() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//1.通过类加载器获取Car类对象
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class clazz = loader.loadClass("mcy.spring.ioc.beans.Car");

		//2.获取类的默认构造器并通过它实例化Car
		Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
		Car car = (Car) constructor.newInstance();

		//3.通过反射方法设置属性
		Method setBrand = clazz.getMethod("setBrand", String.class);
		setBrand.invoke(car, "Flag");
		Method setColor = clazz.getMethod("setColor", String.class);
		setColor.invoke(car, "red");
		Method setSpeed = clazz.getMethod("setSpeed", int.class);
		setSpeed.invoke(car, 100);

		return car;

	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

		Car car = initByDefaultConst();
		car.info();
	}
}
