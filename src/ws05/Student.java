/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 4
/*  Date: Jun 22, 2021
/* ********************************************************************/

package ws05;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable {
    private int stdId;
    private String firstName;
    private String lastName;
    private ArrayList<String> courses = new ArrayList<>();


    Student() {

    }

    public Student(int stdId, String firstName, String lastName, ArrayList<String> courses) {
        this.stdId = stdId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<String> getCourses() {
        return courses;
    }


    public void setCourses(String courses) {
        this.courses.add(courses);
    }

    @Override
    public String toString() {
        return "Student Information" + '\n' +
                "Student ID: " + stdId + '\n' +
                "firstName: " + firstName + '\n' +
                "lastName: " + lastName + '\n' +
                "courses: " + courses + '\n';
    }


}

