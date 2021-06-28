package ws05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializeGUI extends JFrame {

    private static ArrayList<Student> students;
    private final JTextArea textArea;
    private final JButton desBtn;

    DeserializeGUI(){
        students = new ArrayList<Student>();
        textArea = new JTextArea();
        desBtn = new JButton("Deserialize");
        JPanel buttonPanel = new JPanel();
        JScrollPane scrollPane= new JScrollPane(textArea);

        buttonPanel.add(desBtn);
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        ReadBtnHandler desBtnHandler = new ReadBtnHandler();
        desBtn.addActionListener(desBtnHandler);
    }

    private class ReadBtnHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {

                FileInputStream fis = new FileInputStream("file.out");
                ObjectInputStream ois = new ObjectInputStream(fis);
                students = (ArrayList<Student>)ois.readObject();
                fis.close();

                if (!students.isEmpty()) {
                    for (int i = 0; i < students.size(); i++) {
                        textArea.append("Student ID: " + students.get(i).getStdId() + "\n");
                        textArea.append("First name: " + students.get(i).getFirstName() + "\n");
                        textArea.append("Last name: " + students.get(i).getLastName() + "\n");
                        textArea.append("Courses: " + students.get(i).getCourses() + "\n");
                    }
                }
            } catch (IOException | ClassNotFoundException o) {
                System.out.println(o);

            }
        }
    }
}
