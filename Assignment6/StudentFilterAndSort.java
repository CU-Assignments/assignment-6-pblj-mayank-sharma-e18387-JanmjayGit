import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }
}

public class StudentFilterAndSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 82.5),
            new Student("Bob", 67.0),
            new Student("Charlie", 90.0),
            new Student("David", 76.0),
            new Student("Eve", 58.5)
        );

        System.out.println("Students scoring above 75% (sorted by marks):");

        students.stream()
            .filter(s -> s.getMarks() > 75)
            .sorted((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()))
            .map(Student::getName)
            .forEach(System.out::println);
    }
}
