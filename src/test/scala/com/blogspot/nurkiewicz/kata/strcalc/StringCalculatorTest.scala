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

	test("should throw when single negative value") {
		val e = intercept[IllegalArgumentException] {
			add("-42")
		}

		e.getMessage should equal ("negatives not allowed: -42")
	}

	test("should return sum of two values") {
		add("2, 3") should equal (5)
	}

	test("should return sum of two values where second is negative") {
		val e = intercept[IllegalArgumentException] {
			add("2, -3")
		}

		e.getMessage should equal ("negatives not allowed: -3")
	}

	test("should return 0 when positive and negative values provided with same absolute value") {
		val e = intercept[IllegalArgumentException] {
			add("-4, 4")
		}

		e.getMessage should equal ("negatives not allowed: -4")
	}
	
	test("should handle 5 numbers") {
		val e = intercept[IllegalArgumentException] {
			add("1, -2, 3, -4, 5")
		}

		e.getMessage should equal ("negatives not allowed: -2, -4")
	}
	
	test("should handle very long sequence of numbers") {
		val numbers = 1 to 100 mkString ","
		
		add(numbers) should equal (5050)
	}

	test("should handle newline instead of comma as a separator") {
		add("""1\n2,3""") should equal (6)
	}

	test("should handle newline as the only separator of multiple values") {
		val e = intercept[IllegalArgumentException] {
			add("""1\n2\n-4""")
		}

		e.getMessage should equal ("negatives not allowed: -4")
	}

	test("should support semicolon as custom delimiter") {
		add("//;\n1;2") should equal (3)
	}
	
	test("should support empty input with only delimiter set") {
		add("//;\n") should equal (0)
	}

	test("should throw when negative value and custom delimiter") {
		val e = intercept[IllegalArgumentException] {
			add("//;\n-1;2")
		}

		e.getMessage should equal ("negatives not allowed: -1")
	}

	test("should ignore numbers greater than 1000") {
		add("""2, 1001""") should equal (2)
	}

	test("should support delimiters of arbitrary length") {
		add("//[***]\n1***2***3") should equal (6)
	}

	test("should support delimiter of arbitrary length containing underscores") {
		add("//[__]\n1__2__3") should equal (6)
	}
	
	test("should support multiple custom delimiters") {
		add("//[*][%]\n1*2%3") should equal (6)
	}
	
	test("should support multiple multi-character custom delimiters") {
		add("//[ab][cde]\n1cde2ab3") should equal (6)
	}

}
