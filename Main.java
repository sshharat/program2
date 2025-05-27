import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void displayName() {
        System.out.println("Name: " + name);
    }

    public void displayAge(String dob) {
        LocalDate birthDate;
        if (dob.contains("-")) {
            if (dob.charAt(2) == '-') {
                // Format: DD-MM-YYYY
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                birthDate = LocalDate.parse(dob, formatter);
            } else {
                // Format: YYYY-MM-DD
                birthDate = LocalDate.parse(dob);
            }

            LocalDate currentDate = LocalDate.now();
            Period age = Period.between(birthDate, currentDate);
            System.out.println("Age: " + age.getYears() + " years");
        } else {
            System.out.println("Invalid date format. Use DD-MM-YYYY or YYYY-MM-DD.");
        }
    }
}

class Employee extends Person {
    private String empId;
    private double salary;

    public Employee(String name, String empId, double salary) {
        super(name);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayName();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: $" + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input person details
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter date of birth (DD-MM-YYYY or YYYY-MM-DD): ");
        String dob = scanner.nextLine();

        System.out.print("Enter employee ID: ");
        String empId = scanner.nextLine();

        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();

        // Create employee object
        Employee emp = new Employee(name, empId, salary);

        // Display details
        emp.displayEmployeeDetails();
        emp.displayAge(dob);

        scanner.close();
    }
}
