package com.blogspot.nurkiewicz.kata.strcalc

/**
 * @author Tomasz Nurkiewicz
 * @since 06.04.12, 22:50
 */

object StringCalculator {

	val NumbersDelimiter = """(,\s*)|\\n"""

	def add(numbers: String) = 
		if(numbers startsWith "//") {
			val (delimiter :: input) = numbers.lines.toList
			input match {
				case nums :: _ => nums.
					split(delimiter.substring(2)).
							filterNot(_.isEmpty).
							map(_.toInt).
							sum
				case Nil => 0
			}
		} else {
			numbers.
				split(NumbersDelimiter).
				filterNot(_.isEmpty).
				map(_.toInt).
				sum
		}

}
