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


    public void task1(){
        System.out.println("Task 1:");
        System.out.println("Complete Student list:");
        studentStream().forEach(System.out::println);
    }

    public void task2(){
        System.out.println("Task 2:");
        System.out.println("Students who got 50.0-100.0 sorted by grade:");
        studentStream().filter(s -> s.getGrade() >= 50.0 && s.getGrade() <= 100.0)
                .sorted(Student.GRADECOMPARATOR).forEach(System.out::println);
    }

    public void task3(){
        System.out.println("Task 3:");
        System.out.println("First Student who got 50.0-100.0:");
        studentStream()
                .filter(s -> s.getGrade() >= 50.0 && s.getGrade() <= 100.0)
                .findFirst()
                .ifPresent(System.out::println);
    }


    public void task4(){
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

    public void task5(){
        System.out.println("Task 5:");
        System.out.println("Unique Student last names:");

        //stream student - sort - stream string - distinct - sout
        studentStream()
                .sorted(Student.NAMECOMPARATOR)
                .map(Student::getLastName)
                .distinct()
                .forEach(System.out::println);
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
        sp.task1();
        System.out.println();
        sp.task2();
        System.out.println();
        sp.task3();
        System.out.println();
        sp.task4();
        System.out.println();
        sp.task5();

    }
}