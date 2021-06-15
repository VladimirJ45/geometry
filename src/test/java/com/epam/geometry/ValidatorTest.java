package com.epam.geometry;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

	@Test
	public void testShouldReturnTrueWithTheValidInput() {

		String input = "1.0 2.0 3.0 6.0 9.0 2.0";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, true);
	}

	@Test
	public void testShouldReturnFalseInputWithCharacters() {

		String input = "1.0 n2.0 3.0 6.0 9.0 2.0";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, false);
	}

	@Test
	public void testShouldReturnFalseInputMissingNumber() {

		String input = "1.0 2.0 3.0 3.0 9.0";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, false);
	}

	@Test
	public void testShouldReturnFalseInputWithoutWhitespace() {

		String input = "1.0 2.0 3.0 3.0 9.04.9";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, false);
	}

	@Test
	public void testShouldReturnFalseEmptyInput() {

		String input = "";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, false);
	}

	@Test
	public void testShouldReturnTrueInputWithNegativeNumbers() {

		String input = "1.0 -2.0 3.0 6.0 -9.0 2.0";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, true);
	}
	
	@Test
	public void testShouldReturnFalseMoreInputThanExpected() {

		String input = "1.0 2.0 3.0 6.0 9.0 2.0 3.0";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, false);
	}
	
	@Test
	public void testShouldReturnFalseExtraWhitespace() {

		String input = "1.0 2.0 3.0  6.0 9.0 2.0";

		Validator validator = new Validator();
		boolean result = validator.validate(input);

		Assert.assertEquals(result, false);
	}
}
