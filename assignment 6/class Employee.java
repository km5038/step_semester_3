class Employee {
    String empName;
    double salary;

    static String companyName =
            "Bright Horizon Technologies";

    static int employeeCount = 0;

    // Constructor
    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: "
                + employeeCount);
    }
}

public class Main {
    public static void main(String[] args) {

        Employee e1 =
                new Employee("Arun", 40000);

        Employee e2 =
                new Employee("Priya", 50000);

        Employee e3 =
                new Employee("Rahul", 45000);

        Employee.printCompanyInfo();
    }
}