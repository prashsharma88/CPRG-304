package problemdomain;

public class Employee {

	private String Name;
	private int Id;
	private double Salary;
	
	public Employee(String name, int id, double salary) {
		this.Name = name;
		this.Id = id;
		this.Salary = salary;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}

	public String getName() {
		return Name;
	}

	public int getId() {
		return Id;
	}
	
	private void privateMethod(String param1, int param2) {
		System.out.println("This is a pivate method of employee class");
		System.out.println("values passes are : " + param1 + ", " + param2);
	}
	
	private static void privateStaticMethod() {
		System.out.println("This is a private static method of employee class");
	}
	
	public void publicMethod() {
		System.out.println("This is a public method of employee class");
	}
	
}
