package practice.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


class Persons {
    private String firstName;
    private String lastName;
    private int age;

    Persons(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

class Persons1{
    private String name;
    private String email;
    public Persons1(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

public class Streams2 {
    
    public static void main(String []args){

        // 1. Task: From a list of Employee(id,name,dept,salary) return top 3 highest-paid employees per department.
        // Tests: groupingBy, downstream collectors, Comparator, collectingAndThen, limiting.
        List<Employee> employees = Arrays.asList(
            new Employee(1, "apple", "IT", 90000),
            new Employee(2, "adam", "IT", 75000),
            new Employee(3, "bob", "HR", 70000),
            new Employee(4, "brenda", "HR", 72000),
            new Employee(5, "charlie", "IT", 80000),
            new Employee(6, "catherine", "Finance", 95000),
            new Employee(7, "david", "Finance", 93000)
        );

        System.out.println("\nTask 1");
        Map<String, List<Employee>> res = employees.stream()
                                                       .collect(
                                                        Collectors.groupingBy(Employee::getDepartment )
                                                        // , Collectors.maxBy(
                                                                // Comparator.comparing(Employee::getSalary)))
                                                                );
        // System.out.println(res);

        res.forEach((dept, list)->{
            System.out.println("Dept: "+dept);
            list.stream()
            .sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).forEach(System.out::println);;
            // list.ifPresent(e -> System.out.println(e.toString()));
        });

        // 2. Task: For each department compute count, average, min, max salary in one pass.
        System.out.println("\nTask 2");
        Map<String, DoubleSummaryStatistics> stats = employees.stream()
                                                                .collect(
                                                                    Collectors.groupingBy(Employee::getDepartment, Collectors.summarizingDouble(Employee::getSalary)));

        stats.forEach((dept, st) -> {
            System.out.println("Dept (Salary) >> count >> average >> min >> max \n " +
                                dept + " >> " + st.getCount() + " >> " + st.getAverage() + " >> " + st.getMin() + " >> " + st.getMax());
        }); 

        // 3. Task: Partition employees into high (>75k) and low salary, map each partition to sorted list of names.
        // Tests: partitioningBy, mapping, sorted, collectors.
        System.out.println("\nTask 3");
        Map<Boolean, List<Employee>> partedEmp = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 75000));
        // System.out.println("\nParted by Salary and Grouped by Names : \n" /*+partedEmp.get(true)*/);

        partedEmp.forEach((isGreater, empList) -> {
            if (isGreater){
                System.out.println("\nParted by Salary(>75k) and Grouped by Names : " /*+partedEmp.get(true)*/);
                empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(e -> System.out.println(e.getName() + "->" + e.getDepartment()));
            } else {
                System.out.println("\nParted by Salary(<75k) and Grouped by Names : " /*+partedEmp.get(true)*/);
                empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(e -> System.out.println(e.getName() + "->" + e.getDepartment()));
            }
        });

        // 4. Task: Sort list of Persons by lastName asc, firstName asc, age desc. Preserve original order for ties.
        // Tests: Comparator.thenComparing, Comparator.comparingInt, stream.sorted, stable sort behavior.
        List<Persons> personList = Arrays.asList(
            new Persons("Bob", " Builder", 46),
            new Persons("Brent", " Curt", 32),
            new Persons("Sachin", " Tendulkar", 51),
            new Persons("Virat", " Kohli", 36),
            new Persons("Irfan", " Pathan", 35),
            new Persons("Yusuf", " Pathan", 38),
            new Persons("Adam", " Gilchrist", 52)
        );
        System.out.println("\nTask 4");
        personList.stream()
                    .sorted(Comparator.comparing(Persons::getLastName).
                            thenComparing(Persons::getFirstName).
                            thenComparing(Comparator.comparingInt(Persons::getAge).reversed()))
                    .forEach(p -> System.out.println(p.getFirstName() + p.getLastName() + " " + p.getAge()));

        // 5. Task: Remove duplicates by email (first occurrence retained). Return list in original encounter order.
        // Tests: distinct property (use LinkedHashMap or custom predicate), stateful filter, side-effects.
        System.out.println("\nTask 5");

        List<Persons1> listOfPeople = Arrays.asList(
            new Persons1("Kishor", "kishor@mail.com"),
            new Persons1("Sachin", "Sachin@mail.com"),
            new Persons1("Virat", "Virat@mail.com"),
            new Persons1("Ricky", "Ricky@mail.com"),
            new Persons1("Rickelton", "Ricky@mail.com")
        );

        // listOfPeople.stream().
        Map<String, List<Persons1>> peopleMap = listOfPeople.stream().collect(Collectors.groupingBy(Persons1::getEmail, LinkedHashMap::new, Collectors.toList()));
                                                                // .values().stream().map(list -> list.get(0)).collect(Collectors.toList());

        // peopleMap.forEach(p -> System.out.println(p.getName() + " " + p.getEmail()));
        List<Persons1> pList = peopleMap.values().stream().map(p -> p.get(0)).collect(Collectors.toList());
        pList.forEach(p -> System.out.println(p.getName() + " " + p.getEmail()));
    }
}
