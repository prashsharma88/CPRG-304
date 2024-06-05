package test.java.utilities;

import java.lang.reflect.Method;

public class Utils {

	public static Method getMethod(String TargetClassName, String MethodName, Class[] argClasses) {
		Method method = null;
		try {
			Class<?> TargetClass = Class.forName(TargetClassName);
			method = TargetClass.getDeclaredMethod(MethodName, argClasses);
			method.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return method;
	}
}
