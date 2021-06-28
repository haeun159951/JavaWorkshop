/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 5
/*  Date: July 06, 2021
/* ********************************************************************/
package ws04;

import java.io.*;
import java.util.ArrayList;

public class Deserialize {

    public static void main(String[] args) {

        ArrayList<Student> student = new ArrayList<>();
        try {
            String fileName = "student.out";

            FileInputStream fos = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fos);

            student = (ArrayList<Student>) in.readObject();


            for (Student s : student) {
                System.out.println(s.toString());
            }

            in.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}