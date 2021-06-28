/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 1
/*  Date: Jun 1, 2021
/* ********************************************************************/

package ws01;

public class Stack {
    private char[] stack;
    private int top;

    //constructor
    public Stack(int size) {
        if (size < 0) {
            System.out.println("size must be bigger than 0");
        } else {
            stack = new char[size];
            top = -1;
        }
    }

    //push character to the stack array
    public void push(char item) {
        stack[++top] = item;
    }

    //pop
    public char pop() {
        return stack[top--];
    }
}