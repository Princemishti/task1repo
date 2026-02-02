
import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String dept;
    int salary;
    List<String> skills;

    Employee(int id, String name, String dept, int salary, List<String> skills) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return name + " | " + dept + " | " + salary;
    }
}
class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(1, "Aman", "IT", 70000, List.of("Java", "Spring")),
            new Employee(2, "Ravi", "HR", 40000, List.of("Recruitment")),
            new Employee(3, "Neha", "IT", 90000, List.of("Java", "Docker")),
            new Employee(4, "Pooja", "Finance", 60000, List.of("Excel", "Accounts")),
            new Employee(5, "Aman", "IT", 70000, List.of("Java", "Spring"))
        );

        // Task1
        List<Employee> ob1=employees.stream().filter(e->e.salary>60000) .collect(Collectors.toList());
        System.out.println(" salary > 60,000.") ;
        System.out.println(ob1) ;


        // task 2

        List<String> ob2= employees.stream().map(e -> e.name).collect(Collectors.toList());
        System.out.println(" only names") ;
        System.out.println(ob2) ;

        // task3
        List<String> ob3=employees.stream().map(e->e.name).distinct().collect(Collectors.toList());
        System.out.println(" unique employee names.") ;
        System.out.println(ob3) ;

        // task4
        List<Employee> ob4=employees.stream().sorted((e1,e2)->e2.salary-e1.salary).collect(Collectors.toList());
        System.out.println(" salary (descending).") ;
        System.out.println(ob4) ;      

        // task5

List<Employee> ob5 = employees.stream()
    .sorted((e1, e2) -> e2.salary - e1.salary)
    .skip(1)
    .limit(2)
    .collect(Collectors.toList());


            System.out.println("2nd and 3rd highest paid employees:");
            System.out.println(ob5);

        // task6
        
        Set<String> uniqueSkills =employees.stream().flatMap(e -> e.skills.stream()).collect(Collectors.toSet());

            System.out.println("All unique skills:");
            System.out.println(uniqueSkills);


        // task7

        int totalSalary =employees.stream().map(e -> e.salary).reduce(0,Integer::sum);
        System.out.println("Total salary of all employees:");
        System.out.println(totalSalary);


        // task8

        int total = employees.stream().map(e -> e.salary).reduce(0, Integer::sum);
        long count = employees.stream().count();
        double average = (double) total / count;

        System.out.println("Average salary:");
        System.out.println(average);


        // task9

        Map<String, List<Employee>> byDept =employees.stream().collect(Collectors.groupingBy(e -> e.dept));

        System.out.println("Employees by department:");
        System.out.println(byDept);



        // task10

        Map<String, Employee> highestPaidPerDept =employees.stream().collect(Collectors.groupingBy(e -> e.dept,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(emp -> emp.salary)),Optional::get)));

        System.out.println("Highest paid employee per department:");
        System.out.println(highestPaidPerDept);


        // task11
List<String> topSkills = employees.stream()
    .filter(e -> e.dept.equals("IT"))
    .filter(e -> e.salary > 60000)
    .flatMap(e -> e.skills.stream())
    .distinct()
    .sorted()
    .limit(3)
    .collect(Collectors.toList());


        System.out.println("Top 3 IT skills of high earners:");
        System.out.println(topSkills);


        // task12
Map<String, Map<String, Double>> deptReport = employees.stream()
    .collect(Collectors.groupingBy(
        e -> e.dept,
        Collectors.collectingAndThen(
            Collectors.toList(),
            list -> {
                double deptTotal = list.stream()
                        .mapToDouble(emp -> emp.salary)
                        .sum();
                double deptAvg = deptTotal / list.size();
                double deptCount = list.size();

                Map<String, Double> stats = new HashMap<>();
                stats.put("total", deptTotal);
                stats.put("average", deptAvg);
                stats.put("count", deptCount);
                return stats;
            }
        )
    ));


System.out.println("Department Salary Report:");
System.out.println(deptReport);
    }
}


