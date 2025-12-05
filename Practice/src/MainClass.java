import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Employee {
	String name;
    int salary;
    Employee(String name, int salary) { this.name = name; this.salary = salary; }
    
    public String getName() { return name;}
    public int getSalary() { return salary; }
}


public class MainClass {

	public static void main(String[] args) {
		
		// =============== Calculate My Age ===================
		LocalDate today = LocalDate.now();
		LocalDate birth = LocalDate.of(1997, 9, 28);
		Period age = Period.between(birth, today);
//		System.out.println("My Age : " + age.getYears());
		
		// ================= simple use of stream API ===================
		/*
		 * Sort the given String and print the unique words from the String 
		 * */
		
		String str = "Java is fun and Java is powerful";
		List<String> uniqueWords = Arrays.stream(str.split(" "))		// 1. split the string 
				.map(String::toLowerCase)								// 2. convert to lower case
//				.map(String::toUpperCase)
				.distinct()												// 3. find unique words with distinct() method
				.sorted()												// 4. sort it alphabetically
				.collect(Collectors.toList())							// 5. store it into the list
				;
		
		System.out.println(uniqueWords);

		System.out.println("Sorted Unique Words : ");

		uniqueWords.stream().sorted()
			.forEach(word -> System.out.println(word));
		
		// convert back to string using reduce()
		String convertedStr = uniqueWords.stream()
					.reduce(" ", (a, b) -> a + " " + b);
		System.out.println("Converted back to String : " + convertedStr);
		
		/*
		 * Filter the Array and Print the Even numbers from the array
		 * Using Java 8 (Stream API and Lambda)
		 * 
		 * */
		
		List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> isEven = n -> (n % 2 == 0 && n != 0);
		
		num.stream()
			.filter(isEven )								// creates new filtered stream
			.forEach(n -> System.out.println(n));
		
		/*
		 * Print the Sum numbers in array (Stream API and Lambda)
		 * */
		
		List<Integer> numList = Arrays.asList(1,2,3,4,5);
		
		int sum = numList.stream()
				.reduce(0, (a, b) -> a + b);
		System.out.println("Sum is : " + sum);
		
		/*
		 * Sort the Employee Class by Salary
		 * 
		 * 
		 * */
		List<Employee> empList = Arrays.asList(
					new Employee("Zebra", 200),
					new Employee("Kite", 100),
					new Employee("Amar", 800),
					new Employee("Jems", 400)
				);
		
		System.out.println("Without Using Comparator argument");
		empList.stream()
				.sorted((e1, e2) -> e1.salary - e2.salary)
				// .sorted((e1, e2) -> e1.name.compareTo(e2.name))
				.forEach(e -> System.out.println(e.name + " = " + e.salary));
		
		System.out.println("Using Comparator argument");
		List<Employee> sortedEmpList = empList.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		
		sortedEmpList.forEach(e -> System.out.println(e.getName() + " " + e.getSalary()));
		
		// Using sort from Collection framework
		System.out.println("Using sort from Collection framework");
		empList.sort(Comparator.comparing(Employee::getSalary));
		empList.forEach(e -> System.out.println(e.getName() + " " + e.getSalary()));
	}

}
