package com.example.stringCalculator;

import com.example.stringCalculator.stringCalculator.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculatorApplicationTests {
	List<VerificationStrategy> strategies;
	StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		strategies = List.of(
				new EmptyString(),
				new MultipleErrors(),
				new NegativeNumbers(),
				new MissingNumber(),
				new NewlineSeparatorError(),
				new NewlineSeparatorSuccess()
		);
		stringCalculator = new StringCalculator(strategies);
	}


	@Test
	void testEmptyString() {
		assertEquals(
				"0",
				stringCalculator.add("")
		);
	}

	@Test
	void testNegativeNumbers() {
		assertEquals(
				"Negative not allowed : -1, -4",
				stringCalculator.add("-1, 2, -4")
		);
	}

	@Test
	void testMissingNumber() {
		assertEquals(
				"Number expected but EOF found.",
				stringCalculator.add("1, 4,")
		);
	}

	@Test
	void testMultipleErrors() {
		assertEquals(
				"Negative not allowed : -1, -2\nNumber expected but found ',' at position 3",
				stringCalculator.add("-1,,-2")
		);
	}

	@Test
	void testNewlineSeparatorError() {
		assertEquals(
				"Number expected but ' \n ' found at position 6.",
				stringCalculator.add("175.2,\n35")
		);
	}

	@Test
	void testNewlineSeparatorSuccess() {
		assertEquals(
				"6",
				stringCalculator.add("1\n2,3")
		);
	}
}
