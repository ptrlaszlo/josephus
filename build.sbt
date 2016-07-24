name := "josephus"
 
version := "0.1"

mainClass in Compile := Some("main.Main")

lazy val root = (project in file(".")).
	settings(
		name := "josephus",
		version := "1.0",
		scalaVersion := "2.11.8")

libraryDependencies ++= Seq(
	"org.specs2" %% "specs2-core" % "3.8.4" % "test")
