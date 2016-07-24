package main

import josephus.CountLogic._

/**
 * TODO
 */
object Main {
	def main(args: Array[String]): Unit = {
		val result = args.toList match {
			case numOfPeople :: stepRate :: startingPos :: Nil => parseArgsAndCountOut(numOfPeople, stepRate, startingPos)
			case numOfPeople :: stepRate :: Nil => parseArgsAndCountOut(numOfPeople, stepRate)
			case _ => Left("BAD params") //TODO
		}
		printResult(result)
	}

	def parseArgsAndCountOut(strNumOfPeople: String, strStepRate: String, strStartingPos: String = "1"): Either[String, Long] =
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
		case Left(errorMsg) => println(errorMsg)
		case Right(startingPos) => println("OK " + startingPos)
	}
}
