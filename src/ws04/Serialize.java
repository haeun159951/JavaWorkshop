/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 4
/*  Date: Jun 22, 2021
/* ********************************************************************/

package ws04;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Serialize {
    public static void main(String[] args) throws IOException {

        ArrayList<Student> studentList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            Student s = new Student();
            // first name
            System.out.print("Enter Student First Name: ");
            String firstName = reader.readLine();
            s.setFirstName(firstName);

            //last name
            System.out.print("Enter Student Last Name: ");
            String lastName = reader.readLine();
            s.setLastName(lastName);

            //sid
            System.out.print("Enter Student Student Id: ");
            int studentId = Integer.parseInt(reader.readLine());
            s.setStdId(studentId);

            //course name
            System.out.print("Enter Student Course names: ");
            String course = reader.readLine();
            String[] temp = course.split(",");
            for (int i = 0; i < temp.length; i++) {
                s.setCourses(temp[i]);
            }

            studentList.add(s);

            try {
                String fileName = "student.out";
                FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(studentList);
                out.flush();
                fos.close();
                System.out.println(s.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Do you want to continue to add student (y/n)");
            Scanner input = new Scanner(System.in);

            String answer = input.nextLine();

            if (answer.equalsIgnoreCase("n")) {
                System.out.println("exit");
                break;
            }

        } while (true);
    }
}