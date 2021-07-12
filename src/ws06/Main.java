/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 6
/*  Date: July 12, 2021
/* ********************************************************************/

package ws06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String str;
        int lineCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {
            while ((str = br.readLine()) != null) {
                lineCount++;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Shape[] shapes = new Shape[lineCount];

        try (BufferedReader br = new BufferedReader(new FileReader("shapes.txt"))) {

            int i = 0;

            while ((str = br.readLine()) != null) {
                String[] tokens = str.split(",");

                if (tokens[0].equals("Circle") && tokens.length == 2) {
                    try {
                        shapes[i] = new Circle(Double.parseDouble(tokens[1]));
                        i++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (tokens[0].equals("Square") && tokens.length == 2) {
                    try {
                        shapes[i] = new Square(Double.parseDouble(tokens[1]));
                        i++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (tokens[0].equals("Rectangle") && tokens.length == 3) {
                    try {
                        shapes[i] = new Rectangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                        i++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (tokens[0].equals("Parallelogram") && tokens.length == 3) {
                    try {
                        shapes[i] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
                        i++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if (tokens[0].equals("Triangle") && tokens.length == 4) {
                    try {
                        shapes[i] = new Triangle(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));
                        i++;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            System.out.println();
            System.out.println(((i) + " shapes were created:"));

            for (Shape shape : shapes) {
                if (shape != null) {
                    System.out.println(shape);
                    System.out.println();
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //TASK 2
        System.out.println("\n------->Task 2 ... <-------");

        // getting max and min value for perimeter of circle and triangle
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                double maxC = shape.getPerimeter();
                if (max < maxC) {
                    max = maxC;
                }

            } else if (shape instanceof Triangle) {
                double minT = shape.getPerimeter();
                if (min > minT) {
                    min = minT;
                }
            }
        }

        // loop the shapes array to check if there is max circle and min triangle, if there is, it makes null
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Circle && shapes[i].getPerimeter() == max) {
                shapes[i] = null;
            }
            if (shapes[i] instanceof Triangle && shapes[i].getPerimeter() == min) {
                shapes[i] = null;
            }
        }

        // print all the shapes except null
        for (Shape shape : shapes) {
            if (shape != null) {
                System.out.println(shape);
                System.out.println();
            }
        }


        // Task 3: Calculate and print the total perimeter of all parallelograms
        // the total perimeter of all triangles.
        // For the sample input file, sample output could be:

        System.out.println("------->Task 3 ... <-------");
        double totalPerimeterParallelograms = 0.0;
        double totalPerimeterTriangles = 0.0;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Parallelogram) {
                totalPerimeterParallelograms += shapes[i].getPerimeter();
            }
            if (shapes[i] instanceof Triangle) {
                totalPerimeterTriangles += shapes[i].getPerimeter();
            }
        }

        System.out.println("Total perimeter of Parallelogram is: " + totalPerimeterParallelograms +
                "\nTotal perimeter of Triangle is: " + totalPerimeterTriangles);

    }

}