package main

import org.specs2.mutable._

class MainSpec extends Specification {

	"parseArguments" should {
		"parse 3 parameters correctly" in {
			Main.parseArguments(List("1", "2", "3")) must beRight("1", "2", "3")
		}
		"parse 2 parameters correctly with default 3rd parameter" in {
			Main.parseArguments(List("1", "2")) must beRight("1", "2", "1")
		}
		"parse 1 parameter as error" in {
			Main.parseArguments(List("1")) must beLeft
		}
		"parse 0 parameter as error" in {
			Main.parseArguments(List.empty) must beLeft
		}
		"parse 4 parameters as error" in {
			Main.parseArguments(List("1", "2", "3", "4")) must beLeft
		}
	}

	"convertArgsAndCountOut" should {
		"return error if strNumOfPeople is not correct" in {
			Main.convertArgsAndCountOut("badNumber", "1", "1") must beLeft
		}
		"return error if strStepRate is not correct" in {
			Main.convertArgsAndCountOut("1", "badNumber", "1") must beLeft
		}
		"return error if strStartingPos is not correct" in {
			Main.convertArgsAndCountOut("1", "1", "badNumber") must beLeft
		}
		"return correct result for 3 parameters" in {
			Main.convertArgsAndCountOut("5", "3", "2") must beRight(5)
		}
	}
}
