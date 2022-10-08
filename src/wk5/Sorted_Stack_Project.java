/*
 * Replace linked list with stack
 * - Rewrite the SortLinkedList method to apply to stacks
 *      - Current method will return the stack sorted in reverse order
 *          - Use smallest elements rather than largest elements when pushing
 *          values into the sorted stack
 *      - Rename SortLinkedList method to SortStack and modify the names to
 *      match in the main method
 * - RequestString does not need to be revised     
 * - Update comments
 * 
 * (Could just use the reverse method but I wanted to do 
 * something more rigourous)
 */
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Contains a brute force method to sort a stack.
 *
 * @author Noah Briggs
 * @version 1.0.0
 * @since Week 5 of Merrimack College course CSC6301
 **/
public class Sorted_Stack_Project {
    /**
     * Requests user input to generate a stack of integers and then sorts
     * the generated stack and prints the result.
     * 
     * @param args Arguments passed through the main method (none available)
     */
    public static void main(String[] args) {
        // A loop flag, allowing the while loop to continue running until the
        // user inputs an empty string
        boolean loop = true;

        // The variable assigned to the input given by the user
        String userInput;

        // The varible assigned to the integer value of the input given by the
        // user (if the input string can be converted to an integer)
        int integerUserInput;

        // The stack containing the integer inputs of the user
        Stack<Integer> userStack = new Stack<Integer>();

        // Loop until the user enters ""
        while (loop == true) {

            // Prompt the user for input
            System.out.println("Enter an integer to be added to the stack, or just press enter to sort the stack");
            userInput = RequestString();
            System.out.println();

            // If the user inputs "" then exit the loop and try to sort
            if (userInput.equals("")) {
                System.out.println("Sorting...");
                loop = false;

                /*
                 * If the user inputs anything but "", see if it can be 
                 * transformed into an integer. If it can, add it to the stack. 
                 * If it can't be transformed into an integer, this will inform 
                 * the user that heir input is not an integer and will continue 
                 * to loop.
                 */
            } else {
                // Attempt to convert input string to integer
                try {
                    integerUserInput = Integer.parseInt(userInput);
                    userStack.push(integerUserInput);
                    System.out.println("Current List:");
                    System.out.println(userStack.toString());
                    System.out.println();

                    // If the string cannot be converted inform the user
                } catch (NumberFormatException e) {
                    System.out.println("\"" + userInput + "\" is not an Integer!");
                    System.out.println();
                }
            }
        }
        // Check if the stack is empty and notify the user that there is
        // nothing to be sorted, otherwise print the sorted list.
        if (userStack.isEmpty()) {
            System.out.println("Nothing to Sort!");

        } else {
            System.out.println("Sorted List:");
            System.out.println(SortStack(userStack).toString());
        }
    }

    /**
     * Prompts the user for their input using the scanner class in the java.util
     * package.
     * 
     * @return The user's input as a string
     * @see java.util.Scanner
     */
    public static String RequestString() {
        // The varible to which the user input is assigned to
        String userInput;

        // The Scanner class variable used to request input
        Scanner askForInput = new Scanner(System.in);

        // Prompt the user for their input
        userInput = askForInput.nextLine();

        // Return the user's input
        return userInput;
    }

    /**
     * Sorts a given stack of integers from smallest to largest
     * 
     * @param stack The stack of integers to be sorted
     * @return The sorted stack of integers
     */
    public static Stack<Integer> SortStack(Stack<Integer> stack) {
        //The index of a stack
        int i;

        //The index of the smallest value in the stack
        int smallIndex;

        //The value of the smallest element in a stack
        int smallestElement;

        //Another stack which procedurally collects the elements of the given 
        //stack, in order
        Stack<Integer> sortedStack = new Stack<Integer>();
        
        //If the given stack has not been emptied into the sorted stack 
        while (stack.isEmpty() != true) {

            //Reseting the smallest index and element in the unsorted stack
            smallIndex = 0;
            smallestElement = stack.get(0);

            //Step through the stack to find the minimum value and its index
            for (i = 0; i < stack.size(); i++) {
                if (smallestElement > stack.get(i)) {   
                    smallIndex = i;
                    smallestElement = stack.get(i);
                }
            }
            
            //Push the smallest element found to the bottom of the sorted stack 
            sortedStack.push(smallestElement);
            
            //Remove that element from the unsorted stack
            stack.remove(smallIndex);

        }
        //Return the sorted stack
        return sortedStack;
    }
}
