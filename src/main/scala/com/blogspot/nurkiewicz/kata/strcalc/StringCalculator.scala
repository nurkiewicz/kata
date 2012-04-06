package com.blogspot.nurkiewicz.kata.strcalc

/**
 * @author Tomasz Nurkiewicz
 * @since 06.04.12, 22:50
 */

object StringCalculator {

	val NumbersDelimiter = """(,\s*)|\\n"""

	val CustomDelimiterPrefix = "//"

	def add(numbers: String): Int =
		if(numbers startsWith CustomDelimiterPrefix) {
			numbers.lines.toList match {
				case delimiter :: nums :: _ => add(nums, delimiter.substring(CustomDelimiterPrefix.size))
				case _ => 0
			}
		} else {
			add(numbers, NumbersDelimiter)
		}

	def add(numbers: String, delimiter: String): Int =
		numbers.
				split(delimiter).
				filterNot(_.isEmpty).
				map(_.toInt).
				sum

}
