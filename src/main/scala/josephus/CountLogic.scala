package josephus

/**
 * Logic of the count out problem
 */
object CountLogic {

	// Function to call the base algorithm and shift with starting position
	def countOutWithStartingPos(numOfPeople: Long, stepRate: Long, startingPos: Long): Long =
		(countOutLarge(numOfPeople, stepRate) + startingPos - 1) % numOfPeople + 1

	// Algorithm counting from 0th position
	private[josephus] def countOutLarge(numOfPeople: Long, stepRate: Long): Long =
		if (numOfPeople == 1) {
			0
		} else if (stepRate == 1) {
			numOfPeople - 1
		} else if (stepRate > numOfPeople) {
			(countOutLarge(numOfPeople - 1, stepRate) + stepRate) % numOfPeople
		} else {
			val count = numOfPeople / stepRate
			val innerResult = countOutLarge(numOfPeople - count, stepRate) - numOfPeople % stepRate
			if (innerResult < 0)
				innerResult + numOfPeople
			else
				innerResult + innerResult / (stepRate - 1)
		}

	// A slower more trivial solution
	private[josephus] def countOut(numOfPeople: Long, stepRate: Long): Long =
		if (numOfPeople == 1) {
			0
		} else {
			(countOut(numOfPeople - 1, stepRate) + stepRate) % numOfPeople
		}
}
