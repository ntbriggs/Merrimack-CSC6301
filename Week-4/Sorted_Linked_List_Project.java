import java.util.LinkedList;
import java.util.Scanner;

/**
 * Contains a brute force method to sort a linked list.
 *
 * @author Noah Briggs
 * @version 1.0.0
 * @since Week 4 of Merrimack College course CSC6301
 **/
public class Sorted_Linked_List_Project {
    /**
     * Requests user input to generate a linked list of integers and then sorts
     * the generated linked list and prints the result.
     * 
     * @param args Arguments passed through the main procedure (none available)
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

        // The linked list containing the integer inputs of the user
        LinkedList<Integer> userList = new LinkedList<Integer>();

        // Loop until the user enters ""
        while (loop == true) {

            // Prompt the user for input
            System.out.println("Enter an integer to be added to the linked list, or just press enter to sort the linked list");
            userInput = RequestString();
            System.out.println();

            // If the user inputs "" then exit the loop and try to sort
            if (userInput.equals("")) {
                System.out.println("Sorting...");
                loop = false;

                /*
                 * If the user inputs anything but "", see if it can be transformed
                 * into an integer. If it can, add it to the linked list. If it can't
                 * be transformed into an integer, this will inform the user that
                 * their input is not an integer and will continue to loop.
                 */
            } else {
                // Attempt to convert input string to integer
                try {
                    integerUserInput = Integer.parseInt(userInput);
                    userList.push(integerUserInput);
                    System.out.println("Current List:");
                    System.out.println(userList.toString());
                    System.out.println();

                    // If the string cannot be converted inform the user
                } catch (NumberFormatException e) {
                    System.out.println("\"" + userInput + "\" is not an Integer!");
                    System.out.println();
                }
            }
        }
        // Check if the linked list is empty and notify the user that there is
        // nothing to be sorted, otherwise print the sorted list.
        if (userList.isEmpty()) {
            System.out.println("Nothing to Sort!");

        } else {
            System.out.println("Sorted List:");
            System.out.println(SortLinkedList(userList).toString());
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
     * Sorts a given linked list of integers from smallest to largest
     * 
     * @param list The linked list of integers to be sorted
     * @return The sorted linked list of integers
     */
    public static LinkedList<Integer> SortLinkedList(LinkedList<Integer> list) {
        //The index of a linked list
        int i;

        //The index of the largest value in ta linked list
        int largeIndex;

        //The value of the largest element in a linked list
        int largestElement;

        //Another linked list which procedurally collects the elements of the 
        //given linked list, in order
        LinkedList<Integer> sortedList = new LinkedList<Integer>();
        
        //If the given linked list has not been emptied into the sorted linked 
        //list
        while (list.isEmpty() != true) {

            //Reseting the largest index and element in the unsorted linked list
            largeIndex = 0;
            largestElement = list.get(0);

            //Step through the linked list to find the maximum value and its 
            //index
            for (i = 0; i < list.size(); i++) {
                if (largestElement < list.get(i)) {
                    largeIndex = i;
                    largestElement = list.get(i);
                }
            }
            
            //Push the largest element found to the top of the sorted linked 
            //list
            sortedList.push(largestElement);
            
            //Remove that element from the unsorted linked list
            list.remove(largeIndex);

        }
        //Return the sorted linked list
        return sortedList;
    }
}
