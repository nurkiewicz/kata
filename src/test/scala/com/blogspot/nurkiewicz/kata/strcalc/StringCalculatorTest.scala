package com.blogspot.nurkiewicz.kata.strcalc

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import StringCalculator.add

/**
 * @author Tomasz Nurkiewicz
 * @since 06.04.12, 22:51
 */

class StringCalculatorTest extends org.scalatest.FunSuite with ShouldMatchers {

	test("should return 0 for empty string") {
		add("") should equal (0)
	}

	test("should return 0 when only 0 as input") {
		add("0") should equal (0)
	}

	test("should return single provided value") {
		add("42") should equal (42)
	}

	test("should return single negative value") {
		add("-42") should equal (-42)
	}

	test("should return sum of two values") {
		add("2, 3") should equal (5)
	}

	test("should return sum of two values where second is negative") {
		add("2, -3") should equal (-1)
	}

	test("should return 0 when positive and negative values provided with same absolute value") {
		add("-4, 4") should equal (0)
	}
	
	test("should handle 5 numbers") {
		add("1, -2, 3, -4, 5") should equal (3)
	}
	
	test("should handle very long sequence of numbers") {
		val numbers = 1 to 100 mkString ","
		
		add(numbers) should equal (5050)
	}

	test("should handle newline instead of comma as a separator") {
		add("""1\n2,3""") should equal (6)
	}

	test("should handle newline as the only separator of multiple values") {
		add("""1\n2\n-4""") should equal (-1)
	}

	test("should support semicolon as custom delimiter") {
		add("""//;\n1;2""") should equal (3)
	}

}
