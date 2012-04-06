package com.blogspot.nurkiewicz.kata.strcalc

import java.util.regex.Pattern

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
				case delimiterLine :: nums :: _ =>
					val delimiter = delimiterLine.substring(CustomDelimiterPrefix.size)
					if((delimiter startsWith "[") && (delimiter endsWith "]")) {
						val delimiters = delimiter.tail.init.split("\\]\\[").map(Pattern.quote).mkString("(", "|", ")")
						add(nums, delimiters)
					} else {
						add(nums, Pattern.quote(delimiter))
					}
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
			extracted.filter(_ <= 1000).sum
		} else {
			throw new IllegalArgumentException("negatives not allowed: " + negatives.mkString(", "))
		}
	}

}
