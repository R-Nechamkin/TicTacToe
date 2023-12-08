package validation;

import java.util.Scanner;

public class Validation {

	/**
	 * This function checks if a double is negative
	 * @param number	a double holding the number to be validated
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	public static boolean validateNonNegative(double number) {
		if (number >= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This function checks if a double is negative
	 * @param number	a double holding the number to be validated
	 * @param message	a String holding a message to be displayed to the keyboard
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	public static boolean validateNonNegative(double number, String message) {
		if (number >= 0) {
			return true;
		}
		System.out.println(message);
		return false;
	}
	/**
	 * This function checks if a potential numeric grade is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number	a double holding the numeric grade to be validated
	 * @param student	an int holding the number student the grade is for
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	public static double validateNonNegative(double number, int student, Scanner keyboard) {
		while (number < 0) {
			System.out.print("A negative value was provided for student " + student +". Please enter the correct value using the keyboard: ");
			number = keyboard.nextDouble();
		}
		keyboard.close();
		return number;
	}
	
	/**
	 *  This function checks if an integer is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number   an integer holding the value to be validated
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return   the validated integer
	 */
	public static int validateNonNegative(int number, Scanner keyboard) {
		while (number < 0) {
			System.out.println("You have entered a negative value. Please enter the correct value: ");
			number = keyboard.nextInt();
		}
		return number;
	}

	/**
	 * This function validates a single inputed integer to make sure it is not below a minimum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param min   an int holding the minimum value
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return the validated variable
	 */
	public static int validateMin(int input, int min, Scanner keyboard) {
		while (input < min) {
			System.out.print("The value you have entered is too low. Please enter a value equal to or greater than "
					+ min + ": ");
			input = keyboard.nextInt();
		}
		return input;
	}

	/**
	 * This function validates a single inputed integer to make sure it is not above
	 * a maximum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param max   a double holding the maximum value
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return returns an int holding the validated variable
	 */
	public static int validateMax(int input, double max, Scanner keyboard) {

		while (input > max) {
			System.out.print(
					"The value you have entered is too high. Please enter a value equal to or less than " + max + ". ");
			input = keyboard.nextInt();
		}
		return input;
	}

	/**
	 * This function validates a single inputed integer to make sure it is between a
	 * minimum and maximum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param min   a double holding the minimum value
	 * @param max   a double holding the maximum value
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return returns an int holding the validated variable
	 */
	public static int validateMinAndMax(Scanner keyboard, int input, double min, double max) {
		while (input < min || input > max) {
			if (input < min) {
				System.out.print("The value you have entered is too low. Please enter a value equal to or greater than "
						+ min + ": ");
				input = keyboard.nextInt();
			} else {
				System.out.print("The value you have entered is too high. Please enter a value equal to or less than "
						+ max + ". ");
				input = keyboard.nextInt();
			}
		}
		return input;
	}
	
	
		/**
	 * This message asks the user if they would like to do something
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @param message   A String describing what the user is being asked to do
	 * @param yMessage  A String describing what will happen if thet user indicates they wish to do the action
	 * @param nMessage  A String describing what will happen if the user indicates they do not wish to do the action
	 * @return {@code true} if the user wishes to do the action or {@code false} if the user does not
	 */
	public static boolean askAgain(Scanner keyboard, String message, String yMessage, String nMessage) {
		System.out.print("Would you like to " + message + "? (Y/N) ");
		char response = keyboard.nextLine().toUpperCase().charAt(0);
		while (response != 'Y' && response != 'N') {
			System.out.print(
					"Error! You have entered an invalid response. Please type Y to " + nMessage + " or N to " + nMessage + ". ");
			response = keyboard.nextLine().toUpperCase().charAt(0);
		}
		if (response == 'Y') {
			return true;
		}
		return false;
	}
	
	/**
	 *  This function checks if an integer is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number   an integer holding the value to be validated
	 * @param variable  the name of the variable
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return   the validated integer
	 */
	public static int validateNonNegative(int number, String variable, Scanner keyboard) {
		while (number < 0) {
			System.out.println("You have entered a negative value for " + variable + ". Please enter the correct value: ");
			number = keyboard.nextInt();
		}
		return number;
	}
	
	/**
	 *  This function checks if a float is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number   a double holding the value to be validated
	 * @param variable  the name of the variable
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @return   the validated double
	 */
	public static double validateNonNegative(double number, String variable, Scanner keyboard) {
		while (number < 0) {
			System.out.println("You have entered a negative value for " + variable + ". Please enter the correct value: ");
			number = keyboard.nextInt();
		}
		return number;
	}
	
	/**
	 * This method checks whether a char is one of a few allowed responses
	 * @param keyboard  a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 * @param message   A String describing the char (This will be printed to the console)
	 * @param allowedResponses  an array of {@code char}s
	 * @param response  the {@code char} to be checked
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */
	public static char validateChar(char response, char[] allowedResponses, Scanner keyboard, String message) {
		while(!holds(allowedResponses, response)){
			System.out.println("You have entered an invalid response. " + message);
			response = keyboard.nextLine().toUpperCase().charAt(0);
		}
		return response;
	}
	
	/**
	 * This method checks whether a char[] array holds a certain character
	 * @param array  an array of {@code char}s
	 * @param c  the {@code char} to be checked
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */

	public static boolean holds(char[] array, char c) {
		for (int i = 0; i < array.length; i++) {
			if (c == array[i])
				return true;
		}
		return false;

	}
	
	/**
	 * This method checks whether a int[] array holds a certain number
	 * @param array  an array of {@code int}s
	 * @param num  the {@code int} to be checked
	 * @return {@code true} if the array contains the integer and {@code false} if it does not
	 */

	public static boolean holds(int[] array, int num) {
		for (int i = 0; i < array.length; i++) {
			if (i == array[i])
				return true;
		}
		return false;
	}
}
