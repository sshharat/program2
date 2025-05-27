import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dobString) {
        this.name = name;
        // Accepts either "DD-MM-YYYY" or "YYYY-MM-DD"
        if (dobString.contains("-") && dobString.length() == 10) {
            if (Character.isDigit(dobString.charAt(2))) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                this.dob = LocalDate.parse(dobString, formatter);
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                this.dob = LocalDate.parse(dobString, formatter);
            }
        } else {
            System.out.println("Invalid DOB format.");
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        int age = Period.between(dob, LocalDate.now()).getYears();
        System.out.println("Age: " + age + " years");
    }
}
public class StudentCourseInformation {
    private String[] courses;
    private int[] marks;

    public StudentCourseInformation(String[] courses, int[] marks) {
        this.courses = courses;
        this.marks = marks;
    }

    public void displayCoursesAndMarks() {
        System.out.println("\nSemester Courses and Marks:");
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i] + ": " + marks[i] + " marks");
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ravi Kumar", "15-08-2004");
        student.displayInfo();

        String[] courses = {"Math", "Physics", "Computer Science"};
        int[] marks = {85, 90, 95};

        StudentCourseInformation sci = new StudentCourseInformation(courses, marks);
        sci.displayCoursesAndMarks();
    }
}
