package validation;

import java.util.Scanner;

/**
 * This class is intended to be used as validation for console apps
 * Where the user is typing the variable values into the console and responding to output there
 * @author rnech
 *
 */
public class ConsoleValidation implements Validation {

	Scanner keyboard;
	
	/**
	 * 
	 * @param keyboard a {@code Scanner} object (The program assumes the Scanner is reading from the keyboard)
	 */
	public ConsoleValidation(Scanner keyboard) {
		this.keyboard = keyboard;
	}
	

	/**
	 * This function checks if a double is negative
	 * @param number	a double holding the number to be validated
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	@Override
	public boolean validateNonNegative(double number) {
		if (number >= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * This function checks if a double is negative
	 * @param number	a double holding the number to be validated
	 * @param message	a String holding a message to be displayed to the console
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	@Override
	public boolean validateNonNegative(double number, String message) {
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
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	@Override
	public double validateNonNegative(double number, int student) {
		while (number < 0) {
			System.out.print("A negative value was provided for student " + student +". Please enter the correct value using the keyboard: ");
			number = keyboard.nextDouble();
		}
		return number;
	}
	
	/**
	 *  This function checks if an integer is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number   an integer holding the value to be validated
	 * @param variable  the name of the variable
	 * @return   the validated integer
	 */
	@Override
	public int validateNonNegative(int number, String variable) {
		while (number < 0) {
			System.out.println("You have entered a negative value for " + variable + ". Please enter the correct value: ");
			number = keyboard.nextInt();
		}
		return number;
	}

	/**
	 * This function validates a single inputed integer to make sure it is not below a minimum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param min   a double holding the minimum value
	 * @return the validated variable
	 */
	@Override
	public int validateMin(int input, double min) {
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
	 * @return returns an int holding the validated variable
	 */
	@Override
	public int validateMax(int input, double max) {
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
	 * @return returns an int holding the validated variable
	 */
	@Override
	public int validateMinAndMax(int input, double min, double max) {
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
	 * @param message   A String describing what the user is being asked to do
	 * @param yMessage  A String describing what will happen if thet user indicates they wish to do the action
	 * @param nMessage  A String describing what will happen if the user indicates they do not wish to do the action
	 * @return {@code true} if the user wishes to do the action or {@code false} if the user does not
	 */
	@Override
	public boolean askAgain(String message, String yMessage, String nMessage) {
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
	 * This method checks whether a char is one of a few allowed responses
	 * @param message   A String describing the char (This will be printed to the console)
	 * @param allowedResponses  an array of {@code char}s (in uppercase)
	 * @param response  the {@code char} to be checked
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */
	@Override
	public char validateChar(char response, char[] allowedResponses, String message) {
		while(!holds(allowedResponses, response)){
			System.out.println("You have entered an invalid response. " + message);
			response = keyboard.nextLine().toUpperCase().charAt(0);
		}
		return response;
	}
	
	/**
	 * This method checks whether a single charachter is one of a few allowed responses
	 * The character is sent in as a String
	 * @param response A {@code String} of length {@code 1}, holding the charachter to be checked 
	 * @param allowedResponses  a String of all allowed characters (in uppercase)
	 * @param message   A String describing what the user should type in (This will be printed to the console)
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */
	@Override
	public String validateCharacter(String response, String allowedResponses, String message) {
		if (response.length() > 1) {
			throw new IllegalArgumentException("The string sent in must be only a single character");
		}
		while(!allowedResponses.contains(response)){
			System.out.println("You have entered an invalid response. " + message);
			response = keyboard.nextLine().toUpperCase().substring(0,1);
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
}
