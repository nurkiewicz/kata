package com.blogspot.nurkiewicz.kata.strcalc

/**
 * @author Tomasz Nurkiewicz
 * @since 06.04.12, 22:50
 */

object StringCalculator {

	val NumbersDelimiter = """(,\s*)|\\n"""

	def add(numbers: String) = numbers.
			split(NumbersDelimiter).
			filterNot(_.isEmpty).
			map(_.toInt).
			sum

}
