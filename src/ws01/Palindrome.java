/* ********************************************************************/
/*  Name: Ha Eun Kim
/*  Student ID: 158007187
/*  Professor: Reza Khojasteh / JAC444NAA -  Workshop 1
/*  Date: Jun 1, 2021
/* ********************************************************************/

package ws01;

public class Palindrome {

    //method: check if the input is palindrome or not
    public static boolean isPalindrome(String input) {
        boolean isPalindrome = true;

        // check the length if it is more than 0
        if (input.length() > 0) {
            Stack stack = new Stack(input.length()); // initialize stack object with input length

            // Push all the strings to the stack
            for (int i = 0; i < input.length(); i++) {
                stack.push(Character.toLowerCase(input.charAt(i))); //make all the lowercase for case insensitive
            }
            //compare to the element vs the popped value if it is same or not
            for (int j = 0; j < input.length(); j++) {
                if (stack.pop() != Character.toLowerCase(input.charAt(j))) {
                    isPalindrome = false;
                }
            }
        }
        return isPalindrome;
    }

    public static void main(String[] args) {
        String[] str = {"mom", "pizza", "Anna", "Noon", "hamburger", "wow", "haeun"};
        for (int i = 0; i < str.length; i++) {
            if (isPalindrome(str[i])) {
                System.out.println(str[i] + " is a palindrome.");
            } else {
                System.out.println(str[i] + " is not a palindrome.");
            }
            System.out.println("");
        }
    }
}