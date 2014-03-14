package sabreacademy.scrum;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class CardNumberValidatorTest {

	private static final String EMPTY_NUMBER = "";
	private static final String NAMBER_WITH_CHARS = "ABC";
	private static final String NAMBER_SHORTER_THAN_17DIGHTS = "1111111111111111";
	private static final String NUMBER_WITH_DIGITS_ONLY = "11111111111111111";
	private CardNumberValidator testObj = new CardNumberValidator();

	@Test(expected=IllegalArgumentException.class)
	public void cardNumberShouldBeNotEmpty() throws Exception {
		// when
		testObj.isValid(EMPTY_NUMBER);
		// then ...	throw an Exception
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cardNumberShouldContainOnlyDigits_NegativeScenarion() throws Exception {
		// when
		testObj.isValid(NAMBER_WITH_CHARS);
		// then ...	throw an Exception		
	}

	@Test
	public void cardNumberShouldContainOnlyDigits_PositiveScenario() throws Exception {
		// when
		boolean isValid = testObj.isValid(NUMBER_WITH_DIGITS_ONLY);
		// then
		assertThat(isValid, is(equalTo(false)));
	}
	
	@Test
	public void cardNumberShouldBeShorterThan17Digts() throws Exception {
		// when
		boolean isValid = testObj.isValid(NAMBER_SHORTER_THAN_17DIGHTS);
		// then
		assertThat(isValid, is(equalTo(true)));
	}
}
