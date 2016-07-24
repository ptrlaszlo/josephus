package josephus

/**
 * TODO
 */
object CountLogic {
	def countOutWithStartingPos(numOfPeople: Long, stepRate: Long, startingPos: Long): Long =
		(countOutLarge(numOfPeople, stepRate) + startingPos - 1) % numOfPeople + 1
		// TODO countOut vs Large
		// (countOut(numOfPeople, stepRate) + startingPos - 1) % numOfPeople + 1

	private[josephus] def countOut(numOfPeople: Long, stepRate: Long): Long =
		if (numOfPeople == 1) {
			0
		} else {
			(countOut(numOfPeople - 1, stepRate) + stepRate) % numOfPeople
		}

	private[josephus] def countOutLarge(numOfPeople: Long, stepRate: Long): Long =
		if (numOfPeople == 1) {
			0
		} else if (stepRate == 1) {
			numOfPeople - 1
		} else if (stepRate > numOfPeople) {
			(countOutLarge(numOfPeople - 1, stepRate) + stepRate) % numOfPeople
		} else {
			val cnt = numOfPeople / stepRate
			val res = countOutLarge(numOfPeople - cnt, stepRate) - numOfPeople % stepRate
			if (res < 0)
				res + numOfPeople
			else
				res + res / (stepRate - 1)
		}
}