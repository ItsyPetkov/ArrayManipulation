import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* Setting up the front-end of the application */
		System.out.println("Welcome to this Integer Array manipulation application.");
		System.out.println("With this app you could do all sorts of array manipulations like: left rotation, right rotation, substitution, reversion of the array and creating an infinite array from the intial array.");
		System.out.println("Enjoy your stay and have fun while using the app :)");
		System.out.println(" ");
		System.out.println("Please select what you want to do?");
		
		/* Creating an infinite loop so you can spam different commands */
		while(true) {
			try {
				Scanner scan = new Scanner(System.in);
				String option = scan.nextLine();
				new ArrayManipulation(option);
			}catch(InputMismatchException e) {
				System.out.println("Input mismatch, maybe check the type of the values you are entering. :)");
			}
		}
	}
}
