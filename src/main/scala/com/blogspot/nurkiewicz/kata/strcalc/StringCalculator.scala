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

	def add(numbers: String, delimiter: String): Int = {
		val extracted = numbers.
				split(delimiter).
				filterNot(_.isEmpty).
				map(_.toInt)
		val negatives = extracted.filter(_ < 0)
		if(negatives.isEmpty) {
			extracted.sum
		} else {
			throw new IllegalArgumentException("negatives not allowed: " + negatives.mkString(", "))
		}
	}

}
