package com.blogspot.nurkiewicz.kata.strcalc

/**
 * @author Tomasz Nurkiewicz
 * @since 06.04.12, 22:50
 */

object StringCalculator {

	val NumbersDelimiter = """(,\s*)|\\n"""

	def add(numbers: String): Int =
		if(numbers startsWith "//") {
			numbers.lines.toList match {
				case delimiter :: nums :: _ => add(nums, delimiter.substring(2))
				case _ :: Nil => 0
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
