
package ws05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeGUI extends JFrame {

    private static JLabel fname, lname, sid, cname;
    private static JButton addBtn, submitBtn;
    private static JTextField fnameText, lnameText, sidText, courseText;

    private static ArrayList<Student> students = new ArrayList<Student>();
    private static ArrayList<String> courseList;

    public SerializeGUI() {

        super("Testing Serialize");
        setLayout(new GridLayout(6, 5));

        //first name
        fname = new JLabel("Enter First name: ");
        add(fname);
        fnameText = new JTextField(10);
        add(fnameText);

        //last name
        lname = new JLabel("Enter last name: ");
        add(lname);
        lnameText = new JTextField(10);
        add(lnameText);

        //student id
        sid = new JLabel("Enter student id: ");
        add(sid);
        sidText = new JTextField(10);
        add(sidText);

        // course name
        cname = new JLabel("Enter course name: ");
        add(cname);
        courseText = new JTextField(20);
        add(courseText);

        // add button
        addBtn = new JButton("Add Student");
        add(addBtn);
        setVisible(true);

        //event - add
        AddHandler addHandler = new AddHandler();
        addBtn.addActionListener(addHandler);

        // submit button
        submitBtn = new JButton("Submit");
        add(submitBtn);
        setVisible(true);

        //event - submit
        SubmitHandler submitHandler = new SubmitHandler();
        submitBtn.addActionListener(submitHandler);
    }

    private void addStudent() {
        Student student = new Student();
        student.setStdId(Integer.parseInt(sidText.getText()));

        student.setFirstName(fnameText.getText());
        student.setLastName(lnameText.getText());
        String coursesInput = courseText.getText();
        String[] temp = coursesInput.split(",");
        for (String s : temp) {
            student.setCourses(s);
        }
        students.add(student);
    }

    private void clear() {
        sidText.setText("");
        fnameText.setText("");
        lnameText.setText("");
        courseText.setText("");
    }

    private class AddHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                addStudent();
                clear();
                JOptionPane.showMessageDialog(SerializeGUI.this, String.format("Student data is added!"));
            } catch (Throwable io) {
                System.err.println(io);
            }
        }
    }

    private class SubmitHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                FileOutputStream fos = new FileOutputStream("file.out");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(students);
                oos.flush();
                fos.close();

            } catch (Throwable io) {
                System.err.println(io);
            }
            JOptionPane.showMessageDialog(SerializeGUI.this, String.format("Student data is saved!"));// button
        }
    }
}






