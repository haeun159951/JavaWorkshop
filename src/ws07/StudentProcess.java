package ws07;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcess {

    private List<Student> students;

    public StudentProcess(Student[] students) {
        this.students = Arrays.asList(students);
    }

    public Stream<Student> studentStream() {
        return students.stream();
    }


    public void task1() {
        System.out.println("Task 1:");
        System.out.println("Complete Student list:");
        studentStream().forEach(System.out::println);
    }

    public void task2() {
        System.out.println("Task 2:");
        System.out.println("Students who got 50.0-100.0 sorted by grade:");
        studentStream().filter(s -> s.getGrade() >= 50.0 && s.getGrade() <= 100.0)
                .sorted(Student.GRADECOMPARATOR).forEach(System.out::println);
    }

    public void task3() {
        System.out.println("Task 3:");
        System.out.println("First Student who got 50.0-100.0:");
        studentStream()
                .filter(s -> s.getGrade() >= 50.0 && s.getGrade() <= 100.0)
                .findFirst()
                .ifPresent(System.out::println);
    }


    public void task4() {
        System.out.println("Task 4:");
        System.out.println("Students in ascending order by last name then first:");

        studentStream()
                .sorted(Student.NAMECOMPARATOR)
                .forEach(System.out::println);

        System.out.println("Students in descending order by last name then first:");

        studentStream()
                .sorted(Student.NAMECOMPARATOR.reversed())
                .forEach(System.out::println);
    }

    public void task5() {
        System.out.println("Task 5:");
        System.out.println("Unique Student last names:");

        //stream student - sort - stream string - distinct - sout
        studentStream()
                .sorted(Student.NAMECOMPARATOR)
                .map(Student::getLastName)
                .distinct()
                .forEach(System.out::println);
    }

    public void task6() {
        System.out.println("Task 6:\n");
        System.out.println("Student names in order by last name then first name:");

        studentStream()
                .sorted(Student.NAMECOMPARATOR)
                .map(Student::getName)
                .forEach(System.out::println);
    }


    public void task7() {
        System.out.println("Task 7:\n");
        System.out.println("Students by department:");

        Map<String, List<Student>> task7 =
                studentStream()
                        .collect(Collectors.groupingBy(Student::getDepartment)); //department

        task7.forEach((k, v) -> {
            System.out.println(k);
            v.forEach(student -> System.out.println("\t" + student));
        });
    }

    public void task8() {
        System.out.println("Task 8:\n");
        System.out.println("Count of Students by department:");

        Map<String, Long> task8 =
                studentStream()
                        .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));
        Map<String, Long> sortedList = new TreeMap<>(task8);
        sortedList.forEach((k, v) -> System.out.println(k + " has " + v + " Student(s)"));
    }

    public void task9() {
        System.out.println("Task 9:\n");
        double sum = studentStream().mapToDouble(Student::getGrade).sum();
        System.out.println("Sum of Students' grades: " + sum);

    }

    public void task10() {
        System.out.println("Task 10:\n");
        double avg = studentStream().mapToDouble(Student::getGrade).average().getAsDouble();
        System.out.println("Average of Students' grades: " + String.format("%.2f", avg));

    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Jack", "Smith", 50.0, "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media")};

        StudentProcess sp = new StudentProcess(students);

        sp.task6();
        System.out.println();
        sp.task7();
        System.out.println();
        sp.task8();
        System.out.println();
        sp.task9();
        System.out.println();
        sp.task10();

    }
}