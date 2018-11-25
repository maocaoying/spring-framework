package mcy.spring.ioc;

import mcy.spring.ioc.beans.CarPrivate;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectPrivateTest {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		Class clazz = loader.loadClass("mcy.spring.ioc.beans.CarPrivate");
		Constructor constructor = clazz.getDeclaredConstructor((Class[]) null);
		CarPrivate carPrivate = (CarPrivate) constructor.newInstance();
		Field nameField = clazz.getDeclaredField("name");

		//取消private进行访问
		nameField.setAccessible(true);
		nameField.set(carPrivate, "Flag");

		Method method = clazz.getMethod("drive", null);
		//取消protect进行动态访问
		method.setAccessible(true);
		method.invoke(carPrivate);

	}
}
