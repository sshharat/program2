import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Student {
    private String name;
    private LocalDate dateOfBirth;

    public Student(String name, String dob) {
        this.name = name;
        this.dateOfBirth = parseDate(dob);
    }

    private LocalDate parseDate(String dob) {
        DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("dd-MM-yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd")
        };

        for (DateTimeFormatter formatter : formatters) {
            try {
                return LocalDate.parse(dob, formatter);
            } catch (Exception e) {
                // continue to try other format
            }
        }
        throw new IllegalArgumentException("Invalid date format. Use DD-MM-YYYY or YYYY-MM-DD.");
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        System.out.println("Student Age: " + age);
    }
}

class StudentCourses {
    private Map<String, Map<String, Integer>> semesterCourses = new HashMap<>();

    public void addSemesterCourses(String semester, Map<String, Integer> courseMarks) {
        semesterCourses.put(semester, courseMarks);
    }

    public void displayCourses() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            Map<String, Integer> courses = semesterCourses.get(semester);
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                System.out.println("Course: " + entry.getKey() + ", Marks: " + entry.getValue());
            }
            System.out.println();
        }
    }
}

public class StudentInfoApp {
    public static void main(String[] args) {
        // Student Info
        Student student = new Student("John Doe", "2003-08-15");
        student.displayInfo();

        // Student Course Info
        StudentCourses courses = new StudentCourses();
        Map<String, Integer> semester1 = new HashMap<>();
        semester1.put("Math", 85);
        semester1.put("English", 78);
        semester1.put("Science", 90);

        Map<String, Integer> semester2 = new HashMap<>();
        semester2.put("History", 88);
        semester2.put("Geography", 80);
        semester2.put("Computer", 95);

        courses.addSemesterCourses("Semester 1", semester1);
        courses.addSemesterCourses("Semester 2", semester2);

        System.out.println("\nCourse Details:");
        courses.displayCourses();
    }
}
