package Untility;

import java.lang.reflect.Field;

public class ReflectionUtil {
	
	
	static public Field getField(String TargetClassName, String TargetField) {
		Field field = null;
		try {
			Class<?> targetClass = Class.forName(TargetClassName);
			
			field = targetClass.getDeclaredField(TargetField);
			field.setAccessible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return field;
	}
}
