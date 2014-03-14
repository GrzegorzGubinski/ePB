package sabreacademy.scrum;

public class CardNumberValidator {

	public boolean isValid(String cardNumber) throws IllegalArgumentException {
		checkIfNotEmpty(cardNumber);
		checkIfOnlyDigts(cardNumber);
		boolean result = false;
		result = checkLenght(cardNumber, result);
		return result;
	}

	private boolean checkLenght(String cardNumber, boolean result) {
		if(cardNumber.length() < 17) 
			result = true;
		return result;
	}

	private void checkIfNotEmpty(String cardNumber) {
		if(cardNumber.equals("") )
			throw new IllegalArgumentException();
	}

	private void checkIfOnlyDigts(String cardNumber) {
		try {
			Long.parseLong(cardNumber, 10);
		} catch ( NumberFormatException e) {
			throw new IllegalArgumentException();
		}
	}
}
