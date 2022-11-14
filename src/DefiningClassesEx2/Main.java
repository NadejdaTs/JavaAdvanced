package DefiningClassesEx2;

        import java.io.IOException;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Department> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] studentsInfo = sc.nextLine().split(" ");
            String name = studentsInfo[0];
            Double salary = Double.parseDouble(studentsInfo[1]);
            String position = studentsInfo[2];
            String department = studentsInfo[3];
            Employee employee = null;

            if(studentsInfo.length == 4){
                employee = new Employee(name, salary, position, department);
            }else if(studentsInfo.length == 5){
                String forthParameter = studentsInfo[4];
                try{
                    int age = Integer.parseInt(forthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }catch(NumberFormatException e){
                    String email = forthParameter;
                    employee = new Employee(name, salary, position, department, email);
                }
            }else if(studentsInfo.length == 6){
                String email = studentsInfo[4];
                int age = Integer.parseInt(studentsInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }

            if(!departments.containsKey(department)){
                departments.put(department, new Department(department));
            }
            departments.get(department).getEmployees().add(employee);
        }

        Department maxAverageSalaryOfDep = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue().getAverageSalary()))
                .get()
                .getValue();

        System.out.println("Highest Average Salary: " + maxAverageSalaryOfDep.getName());
        maxAverageSalaryOfDep.getEmployees()
                .stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(e -> System.out.println(e.toString()));
    }
}
