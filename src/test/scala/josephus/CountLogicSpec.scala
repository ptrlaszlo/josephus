package josephus

import org.specs2.mutable._

import CountLogic._

class CountLogicSpec extends Specification {

	"countOutWithStartingPos" should {
		"return 2 for numOfPeople=3, stepRate=3, startingPos=1" in {
			countOutWithStartingPos(3, 3, 1) mustEqual 2
		}
		"return 3 for numOfPeople=3, stepRate=2, startingPos=1" in {
			countOutWithStartingPos(3, 2, 1) mustEqual 3
		}
		"return 4 for numOfPeople=5, stepRate=3, startingPos=1" in {
			countOutWithStartingPos(5, 3, 1) mustEqual 4
		}
		"return 5 for numOfPeople=5, stepRate=3, startingPos=2" in {
			countOutWithStartingPos(5, 3, 2) mustEqual 5
		}
		"return 1 for numOfPeople=5, stepRate=3, startingPos=3" in {
			countOutWithStartingPos(5, 3, 3) mustEqual 1
		}
		"return 2 for numOfPeople=5, stepRate=3, startingPos=4" in {
			countOutWithStartingPos(5, 3, 4) mustEqual 2
		}
		"return 3 for numOfPeople=5, stepRate=3, startingPos=5" in {
			countOutWithStartingPos(5, 3, 5) mustEqual 3
		}
		"return 68929 for numOfPeople=100000, stepRate=2, startingPos=1" in {
			countOutWithStartingPos(100000, 2, 1) mustEqual 68929
		}
	}

	"countOut" should {
		"return 1 for numOfPeople=3, stepRate=3" in {
			countOut(3, 3) mustEqual 1
		}
		"return 2 for numOfPeople=3, stepRate=2" in {
			countOut(3, 2) mustEqual 2
		}
		"return 3 for numOfPeople=5, stepRate=3" in {
			countOut(5, 3) mustEqual 3
		}
		"return 12 for numOfPeople=14, stepRate=2" in {
			countOut(14, 2) mustEqual 12
		}
		"return 0 for numOfPeople=4, stepRate=2" in {
			countOut(4, 2) mustEqual 0
		}
		"return 30 for numOfPeople=41, stepRate=3" in {
			countOut(41, 3) mustEqual 30
		}
		"return 6 for numOfPeople=7, stepRate=2" in {
			countOut(7, 2) mustEqual 6
		}
	}

	"countOutLarge" should {
		"return 1 for numOfPeople=3, stepRate=3" in {
			countOutLarge(3, 3) mustEqual 1
		}
		"return 2 for numOfPeople=3, stepRate=2" in {
			countOutLarge(3, 2) mustEqual 2
		}
		"return 3 for numOfPeople=5, stepRate=3" in {
			countOutLarge(5, 3) mustEqual 3
		}
		"return 12 for numOfPeople=14, stepRate=2" in {
			countOutLarge(14, 2) mustEqual 12
		}
		"return 0 for numOfPeople=4, stepRate=2" in {
			countOutLarge(4, 2) mustEqual 0
		}
		"return 30 for numOfPeople=41, stepRate=3" in {
			countOutLarge(41, 3) mustEqual 30
		}
		"return 6 for numOfPeople=7, stepRate=2" in {
			countOutLarge(7, 2) mustEqual 6
		}
	}
}
