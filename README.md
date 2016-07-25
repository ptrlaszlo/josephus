### Josephus Problem (https://en.wikipedia.org/wiki/Josephus_problem)

A program to calculate the position of the last person for the Josephus problem.

The application accepts 3 parameters, which are:
1. the number of people in the circle
2. the step rate
3. the starting position (this paremeter is optional, the default value is 1)

You can run the application with:
1. starting sbt and running `run [Param1] [Param2] [Param3]`
or
2. building a jar with `sbt assembly` and running the jar with `java -jar josephus-assembly-0.1.jar 5 3`

There are two algorithms for calculating the best starting position for counting out:
A [simpler one](https://github.com/ptrlaszlo/josephus/blob/master/src/main/scala/josephus/CountLogic.scala#L30) and one [initially planned to use for large numbers of people](https://github.com/ptrlaszlo/josephus/blob/master/src/main/scala/josephus/CountLogic.scala#L13). However a quick test (with step rate 3, runned 100 times over 1000 iterations) showed that the algorithm planned for larger sets outperforms the simpler one even on small numbers of people (10).
