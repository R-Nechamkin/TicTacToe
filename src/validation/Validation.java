package validation;

public interface Validation {

	/**
	 * This function checks if a double is negative
	 * @param number	a double holding the number to be validated
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	boolean validateNonNegative(double number);

	/**
	 * This function checks if a double is negative
	 * @param number	a double holding the number to be validated
	 * @param message	a String holding a message to be displayed to the console
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	boolean validateNonNegative(double number, String message);

	/**
	 * This function checks if a potential numeric grade is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number	a double holding the numeric grade to be validated
	 * @param student	an int holding the number student the grade is for
	 * @return			{@code true} if the number is not negative and {@code false} if the number is negative
	 */
	double validateNonNegative(double number, int student);

	/**
	 *  This function checks if an integer is negative
	 * 	If the number is negative, it will prompt the user to enter a corrected value on the keyboard
	 * 	It will continue prompting the user to enter a correct value as long as the value remains negative
	 * @param number   an integer holding the value to be validated
	 * @param variable  the name of the variable
	 * @return   the validated integer
	 */
	int validateNonNegative(int number, String variable);

	/**
	 * This function validates a single inputed integer to make sure it is not below a minimum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param min   a double holding the minimum value
	 * @return the validated variable
	 */
	int validateMin(int input, double min);

	/**
	 * This function validates a single inputed integer to make sure it is not above
	 * a maximum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param max   a double holding the maximum value
	 * @return returns an int holding the validated variable
	 */
	int validateMax(int input, double max);

	/**
	 * This function validates a single inputed integer to make sure it is between a
	 * minimum and maximum value
	 * 
	 * @param input an int holding the inputed variable
	 * @param min   a double holding the minimum value
	 * @param max   a double holding the maximum value
	 * @return returns an int holding the validated variable
	 */
	int validateMinAndMax(int input, double min, double max);

	/**
	 * This message asks the user if they would like to do something
	 * yMessage and nMessage will be printed in the following format: Please type Y to " + yMessage + " or N to " + nMessage + ". "
	 * @param message   A String describing what the user is being asked to do
	 * @param yMessage  A String describing what will happen if thet user indicates they wish to do the action
	 * @param nMessage  A String describing what will happen if the user indicates they do not wish to do the action
	 * @return {@code true} if the user wishes to do the action or {@code false} if the user does not
	 */
	boolean askAgain(String message, String yMessage, String nMessage);

	/**
	 * This method checks whether a char is one of a few allowed responses
	 * @param message   A String describing the char (This will be printed to the console)
	 * @param allowedResponses  an array of {@code char}s
	 * @param response  the {@code char} to be checked
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */
	char validateChar(char response, char[] allowedResponses, String message);

	/**
	 * This method checks whether a single charachter is one of a few allowed responses
	 * The character is sent in as a String
	 * @param response A {@code String} of length {@code 1}, holding the charachter to be checked 
	 * @param allowedResponses  a String of all allowed characters (in uppercase)
	 * @param message   A String describing what the user should type in (This will be printed to the console)
	 * @return {@code true} if the array contains the char and {@code false} if it does not
	 */
	public String validateCharacter(String response, String allowedResponses, String message);

}