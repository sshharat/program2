import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your birth year (e.g., 2005): ");
        int year = sc.nextInt();

        System.out.print("Enter your birth month (1-12): ");
        int month = sc.nextInt();

        System.out.print("Enter your birth day (1-31): ");
        
        int day = sc.nextInt();

        LocalDate birthDate = LocalDate.of(year, month, day);
        LocalDate today = LocalDate.now();
        int age = Period.between(birthDate, today).getYears();

        System.out.println("\nName: " + name);
        System.out.println("Age: " + age + " years");

        sc.close();
    }
}
