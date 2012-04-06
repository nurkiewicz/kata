package com.blogspot.nurkiewicz.kata.strcalc

/**
 * @author Tomasz Nurkiewicz
 * @since 06.04.12, 22:50
 */

object StringCalculator {

	def add(numbers: String) = numbers.
			split(""",\s*""").
			filterNot(_.isEmpty).
			map(_.toInt).
			sum

}
