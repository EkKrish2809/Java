package practice.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

class Employee {

	int id;
	String name;
	String department;
	double salary;
    
	public Employee(int i, String string, String string2, double j) {
		// TODO Auto-generated constructor stub
    	this.id = i;
    	this.name = string;
    	this.department = string2;
    	this.salary = j;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	double getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		 return "Employee{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", department='" + department + '\'' +
	                ", salary=" + salary +
	                "}\n";
	}
}

public class Streams {

	
	public static void main(String []args) {
		
		List<Employee> employees = Arrays.asList(
			    new Employee(1, "Alice", "HR", 60000),
			    new Employee(2, "Bob", "IT", 80000),
			    new Employee(3, "Charlie", "Finance", 75000),
			    new Employee(4, "David", "IT", 90000),
			    new Employee(5, "Eve", "HR", 65000)
			);

		// =======================Find all employees from the "IT" department.
		employees.stream()
				.filter(e -> e.department.equals("IT"))
				.collect(Collectors.toList())
				.forEach(e -> System.out.println(e.name));
		
		// ======================Find the highest paid employee in each department.
		Map<String, Optional<Employee>> highestPaid = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
												Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println("\nHighest Paid per Department: " + highestPaid);
		
		
		//=========================Calculate the average salary of all employees.
		double salaryAvg = employees.stream()
									.mapToDouble(Employee::getSalary)
									.average()
									.orElse(0.0);
		System.out.println("\nAvg Salary " + salaryAvg);
		
		// =========================Create a Map<String, List<Employee>> — department → list of employees.
		Map<String, List<Employee>> dept = employees.stream()
												.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("\nGroup By Department: " + dept);
		
		// try {
		// 	System.out.println("Waiting for 10 sec");
		// 	// Thread.currentThread();
		// 	Thread.sleep(10000);
		// } catch (InterruptedException e1) {
		// 	// TODO Auto-generated catch block
		// 	e1.printStackTrace();
		// }
		// =========================Get a comma-separated String of all employee names sorted alphabetically.
		String names = employees.stream()
								.map(Employee::getName)
								.sorted()
								.collect(Collectors.joining(", "));
		System.out.println("\nComma seprated names : "+names);

		// ======================================================================
		List<String> namesList = Arrays.asList("Anna", "Bob", "Charlie", "David", "Eve", "Adam"
				, "Brian", "Catherine", "Derek", "Eva", "Anand", "Brent");

		// sort the name list such that they should be in alphabetical order, and if there are multiple
		// names starting with same alphabet, consider the 2nd alphabet to sort those names
		// namesList.stream().sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::println);

		// using collection
		namesList.sort(Comparator.naturalOrder());
		namesList.forEach(System.out::println);

		// find 1st duplicate instance of character from string
		String name = "Capgemini";

		Set<Character> seen = new HashSet<>(); // to avoid duplicates
		Optional<Character> dup = name.chars().mapToObj(c -> (char)c).filter(c -> !seen.add(c)).findFirst();
		System.out.println("First dup char from string : " + dup.get());

		System.out.println("Main thread started on: " + Thread.currentThread().getName());

		// 1st non repeating
		String str = "aaddfghfhj";

		Map<Character, Long> res = str.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));

		AtomicInteger loop = new AtomicInteger(0);

		res.forEach((alpbt, count) -> {
			long cc = count;
			if (loop.get() < 1) {
				switch ((int) cc) {
					case 1:
						System.out.println(alpbt);
						loop.incrementAndGet();
						break;
				}
			}
		});
	}
}
