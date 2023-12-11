import java.util.Arrays;
import java.util.Scanner; 
public class PhoneBookSearch {

    // Binary search implementation
    public static int binarySearch(String[] contacts, String name) {
        int left = 0;
        int right = contacts.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the name is at the middle index
            if (contacts[mid].equals(name)) {
                return mid;
            }

            // If the name should be on the left side
            else if (contacts[mid].compareTo(name) > 0) {
                right = mid - 1;
            }

            // If the name should be on the right side
            else {
                left = mid + 1;
            }
        }

        // If the name is not found in the contacts array
        return -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        String[] contacts = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Hannah", "Isaac","Sulthan"};
        Scanner scanner = new Scanner(System.in); //Create a Scanner object
        System.out.println("Enter name to search "); // Prompt the user for input
        String searchName = scanner.nextLine(); // Read user input as a string
        scanner.close();

        // Sorting the contacts array (binary search requires a sorted array)
        Arrays.sort(contacts);

        int result = binarySearch(contacts, searchName); 

        if (result != -1) {
            System.out.println("Contact '" + searchName + "' found at index: " + result);
        } else {
            System.out.println("Contact '" + searchName + "' not found in the phone book.");
        }
    }
}
