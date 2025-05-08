package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

//  annotation produces warning
//  @tailrec
  def factorial(n: Int): Int = {
    if (n <=1) 1
    else {
      println("Computing factorial of" + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  }

  println(factorial(10))
//  println(factorial(5000))

  /*
  Exception in thread "main" java.lang.StackOverflowError
	at java.base/sun.nio.cs.UTF_8$Encoder.encodeArrayLoop(UTF_8.java:456)
	at java.base/sun.nio.cs.UTF_8$Encoder.encodeLoop(UTF_8.java:564)
   */

  def anotherFactorial(n: BigInt): BigInt = {
    @tailrec
    def factHelper(x: BigInt, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x-1, x * accumulator) // TAIL RECURSION

    factHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factHelper(10, 1)
    = factHelper(9, 10 * 1)
    = factHelper(8, 9 * 10 * 1)
    = factHelper(7, 8 * 9 * 10 * 1)
    = ...
    = factHelper(2, 3 * 4 * ... * 10 * 1)
    = factHelper(1, 2 * 3 * 4 * ... * 10 * 1)
    = 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10
   */

  println(anotherFactorial(5000))


  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
    1. Concatenate a string n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive
   */

  def concatenateTailrec(string: String, number: Int): String = {
    @tailrec
    def concatStringHelper
    (
      number: Int,
      accumulator: String // intermediate value
    ): String = {
      if (number <= 0) accumulator
      else concatStringHelper(number -1, accumulator + string)
    }

    concatStringHelper(number, "")
  }

  println(concatenateTailrec("dog", 4))

  def isPrime(number: Int): Boolean = {
      if (number == 1) false
      else {
        @tailrec
        def isPrimeUntil(limit: Int, accumulator: Boolean): Boolean = {
          if (limit == 1) accumulator
          else isPrimeUntil(limit - 1, accumulator && (number % limit != 0))
        }

        isPrimeUntil(number / 2, true)
      }
  }

  println(isPrime(7))
  println(isPrime(8))

  def fibonacci(n: Int): Int = {
    @tailrec
    def fibonacciAccumulator(i:Int, fibI: Int, fibIMinusOne: Int): Int = {
      val fibIPlusOne = fibI + fibIMinusOne
      if (i == n) fibI
      else fibonacciAccumulator(i+1, fibIPlusOne, fibI)
    }
    if (n <=2) 1
    else fibonacciAccumulator(2, 1, 1)
  }

  println(fibonacci(8))
}
