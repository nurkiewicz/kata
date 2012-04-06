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

}
