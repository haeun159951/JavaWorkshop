/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 7
/*  Date: July 19, 2021
/* ********************************************************************/

package ws07;

import java.util.Comparator;
import java.util.Objects;

public class Student {
    public static final Comparator<Student> GRADECOMPARATOR = Comparator.comparing(Student::getGrade);
    public static final Comparator<Student> NAMECOMPARATOR =
            Comparator.comparing(Student::getLastName)
                    .thenComparing(Student::getFirstName);

    private String firstName;
    private String lastName;
    private double grade;
    private String department;

    public Student(String firstName, String lastName, double grade, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return getFirstName() + " " + getLastName();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.grade, grade) == 0 && firstName.equals(student.firstName) && lastName.equals(student.lastName) && department.equals(student.department);
    }

    @Override
    public String toString() {
        return getFirstName() + "\t" + getLastName() + "\t" + String.format("%.2f", getGrade()) + "\t" + getDepartment();
    }

}