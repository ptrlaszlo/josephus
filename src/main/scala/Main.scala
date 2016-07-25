package main

import josephus.CountLogic._

/**
 * Main function of the application.
 * It handles argument parsing, calling the count out logic and printing the results.
 */
object Main {
	
	def main(args: Array[String]): Unit = {
		val result = parseArguments(args.toList) match {
			case Right((numOfPeople, stepRate, startingPos)) => convertArgsAndCountOut(numOfPeople, stepRate, startingPos)
			case Left(error) => Left(error)
		}
		printResult(result)
	}

	def parseArguments(args: List[String]): Either[String, (String, String, String)] = args match {
		case numOfPeople :: stepRate :: startingPos :: Nil => Right(numOfPeople, stepRate, startingPos)
		case numOfPeople :: stepRate :: Nil => Right(numOfPeople, stepRate, "1")
		case _ => Left("""Incorrect number of parameters.
			|There are 2 mandatory parameters [number of people] [step rate]
			|And one optional parameter [starting position]""".stripMargin)
	}

	def convertArgsAndCountOut(strNumOfPeople: String, strStepRate: String, strStartingPos: String): Either[String, Long] =
		try {
			val numOfPeople = strNumOfPeople.toLong
			val stepRate = strStepRate.toLong
			val startingPos = strStartingPos.toLong
			if (numOfPeople > 0 && stepRate > 0 && startingPos > 0)
				Right(countOutWithStartingPos(numOfPeople, stepRate, startingPos))
			else
				Left("All parameters must be greater than 0")
		} catch {
			case e: NumberFormatException => Left("Can't convert string to number: " + e.getMessage)
		}

	def printResult(result: Either[String, Long]): Unit = result match {
		case Left(errorMsg) =>
			println(errorMsg)
		case Right(startingPos) =>
			println("Select position:")
			println(startingPos)
	}
}
