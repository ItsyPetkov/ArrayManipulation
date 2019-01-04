import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulation {
	
	private int[] arr;
	
	/* Creating the constructor which links the front-end and the back-end */
	public ArrayManipulation(String option) {
		switch(option) {
			case "leftRotation":
				arr = createArray();
				leftRotation(arr);
				break;
			case "rightRotation":
				arr = createArray();
				rightRotation(arr);
				break;
			case "substitution":
				arr = createArray();
				substitution(arr);
				break;
			case "reverseArray":
				arr = createArray();
				reverseArray(arr);
				break;
			case "infiniteArray":
				arr = createArray();
				createInfiniteArray(arr);
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Unknown operation, please try again!");
		}
	}
	
	/* Creating the array */
	private int[] createArray() {
		
		/* Prompting the user for the length of the array */
		System.out.println("Please select a size for the array.");
		System.out.println("Note: The size is limited to 10");
		Scanner scan = new Scanner(System.in);
		int length = scan.nextInt();
		if(length <= 2 || length > 10) {
			System.out.println("The size of the Array must be at least 3 and at most 10");
			return null;
		}else {
			/* Declaring the array with size equal to the input the user has given. */
			arr = new int[length];
			
			/* Filling the array */
			for(int i = 0; i < length; i++) {
				arr[i] = i + 1;
			}
		}
		return arr;
	}
	
	/* Performing left rotation on the Array */
	private void leftRotation(int[] arr) {
		
		try {
			/* Prompting the user for the distance of rotation */
			System.out.println("Please select by what distance would you like to rotate the array");
			Scanner scan = new Scanner(System.in);
			int d = scan.nextInt();
			
			System.out.println("Initial Array: " + Arrays.toString(arr));
			
			/* Checking the value of d makes sense */
			if(d > 0 && d <= 10) {
				/* Creating a temporary array which stores elements */
				int[] tempArray = new int[d];
				
				/* Filling the temporary array */
				for(int i = 0; i < d; i++) {
					tempArray[i] = arr[i];
				}
				
				/* Rotating the initial array */
				for(int i = 0; i < arr.length - d; i++) {
					arr[i] = arr[i + d];
				}
				
				/* Placing the values of the temporary array where they belong in the initial array */
				for(int i = arr.length - 1; i > arr.length - (d + 1); i--) {
					arr[i] = tempArray[i - (arr.length - d)];
				}
				
				System.out.println("Current Array: " + Arrays.toString(arr));
			}else {
				System.out.println("The distance of rotation must higher than 0 and less than 10");
			}
			
		}catch(NullPointerException e) {
			System.out.println("The initial array did not exist because the length you have entered was not between 2 and 11");
		}
		
	}
	
	/* Performing right rotation on the Array */
	private void rightRotation(int[] arr) {
		
		try {
			/* Prompting the user for the distance of rotation */
			System.out.println("Please select by what distance would you like to rotate the array");
			Scanner scan = new Scanner(System.in);
			int d = scan.nextInt();
			
			System.out.println("Initial Array: " + Arrays.toString(arr));
			
			/* Checking the value of d makes sense */
			if(d > 0 && d <= 10) {
				/* Creating a temporary array which stores elements */
				int[] tempArray = new int[d];
				
				/* Filling the temporary array */
				for(int i = arr.length - d; i < arr.length; i++) {
					tempArray[i - (arr.length - d)] = arr[i];
				}
				
				/* Rotating the initial array */
				for(int i = arr.length -(d + 1); i >= 0; i--) {
					arr[i + d] = arr[i];
				}
				
				/* Placing the values of the temporary array where they belong in the initial array */
				for(int i = 0; i < d; i++) {
					arr[i] = tempArray[i];
				}
				
				System.out.println("Current Array: " + Arrays.toString(arr));
			}else {
				System.out.println("The distance of rotation must higher than 0 and less than 10");
			}
			
		}catch(NullPointerException e) {
			System.out.println("The initial array did not exist because the length you have entered was not between 2 and 11");
		}
		
		
	}
	
	/* Performing a substitution of position of two numbers in the Array */
	private void substitution(int[] arr) {
		
		/* Prompting user for the first number */
		System.out.println("Please select the first number");
		Scanner scan = new Scanner(System.in);
		int firstNumber = scan.nextInt();
		
		/* Check if the user has given a value which makes sense */
		if(firstNumber >= 1 && firstNumber <= 10) {
			
			/* Prompting user for the second number */
			System.out.println("Please select the second number");
			Scanner scan1 = new Scanner(System.in);
			int secondNumber = scan1.nextInt();
			
			/* Check if the user has given a value which makes sense */
			if(secondNumber >= 1 && secondNumber <= 10) {
				
				/* Check if the two numbers match in which case with give an error */
				if(firstNumber != secondNumber) {
					
					System.out.println("Initial Array: " + Arrays.toString(arr));
					
					/* Swap the positions of the numbers in the Array */
					int temp = 0;
					temp = arr[firstNumber - 1];
					arr[firstNumber - 1] = arr[secondNumber - 1];
					arr[secondNumber - 1] = temp;
					
					System.out.println("Current Array: " + Arrays.toString(arr));
				}else {
					System.out.println("The two nmbers MUST NOT match!");
				}
			}else {
				System.out.println("The second number must be greater or equal to one and less or equal to 10");
			}
		}else {
			System.out.println("The first number must be greater or equal to one and less or equal to 10");
		}
	}
	
	/* Performing a reverse algorithm on the array */
	private void reverseArray(int[] arr) {
		
		System.out.println("Initial Array: " + Arrays.toString(arr));
		
		int temp = 0;
		
		int start = 0;
		int end = arr.length - 1;
		
		/* Looping through all of the elements in the array */
		while(start < end) {
			/* Swapping the positions of the elements */
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start++;
			end--;
		}
		
		System.out.println("Current Array: " + Arrays.toString(arr));
	}
	
	/* Crating an infinite array */
	private void createInfiniteArray(int[] arr) {
		/* Prompting the user for a value to add to the array */
		System.out.println("Please select the value you want to add to the end of the array.");
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		
		System.out.println("Initial Array: " + Arrays.toString(arr));
		
		/* Adding the value to the end of the array */
		arr = Arrays.copyOf(arr, arr.length + 1);
		arr[arr.length - 1] = value;
		System.out.println("Current Array: " + Arrays.toString(arr));
	}
	
}
