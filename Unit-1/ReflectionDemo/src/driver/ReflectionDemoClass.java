package driver;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import problemdomain.Employee;

public class ReflectionDemoClass {

	public static void main(String[] args) throws Exception {
		Employee empObj = new Employee("Jake", 100, 10000.50);
		
		System.out.println("NAME SET USING CONSTRUCTOR:");
		System.out.println(empObj.getName());
		System.out.println();
		System.out.println("*************************");
		System.out.println("GETTING ALL VARIABLES:");
		
		Field[] fields = empObj.getClass().getDeclaredFields();		
		for(Field field : fields) {
			System.out.println(field.getName());
			if(field.getName().equals("Name")) {
				field.setAccessible(true);
				field.set(empObj, "James");
			}
		}
		System.out.println();
		System.out.println("*************************");
		System.out.println("NAME UPDATED USING REFLECTION: ");
		System.out.println(empObj.getName());
		System.out.println();
		System.out.println("*************************");
		System.out.println();
		System.out.println("GETTING METHOD NAMES: ");
		Method[] methods = empObj.getClass().getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method.getName());
		}
		
		System.out.println();
		System.out.println("*************************");
		System.out.println("ACCESSING PRIVATE DIFFERENT METHODS");
		System.out.println();
		for(Method method : methods) {
			if(method.getName().equals("privateMethod")) {
				method.setAccessible(true);
				method.invoke(empObj, "Robert", 101);
			}
		}
		
		System.out.println();
		System.out.println("*************************");
		System.out.println("ACCESSING STATIC DIFFERENT METHODS");
		System.out.println();
		for(Method method : methods) {
			if(method.getName().equals("privateStaticMethod")) {
				method.setAccessible(true);
				method.invoke(null);
			}
		}
	}
}
