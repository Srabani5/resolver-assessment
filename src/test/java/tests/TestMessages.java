package tests;


/*
 * This enum defines test assertion messages
 */
public enum TestMessages {
	EMAIL_INPUT_PRESENT("Email input text box present"), 
	PASSWORD_INPUT_PRESENT("Password input text box present"),
	SIGNIN_BUTTON_PRESENT("Sing in button present"),
	BUTTON_1_ENABLED("Button 1 enabled"),
	BUTTON_2_DISABLED("Button 2 disabled");

	private final String message;
	
	TestMessages(String message) {
		this.message = message;
	}
	
	public String message() {
		return message;
	}
}