package lectures.part1basics

object Functions extends App {
  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction()) // in scala 2 aParameterless function without brackets calls the function

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  // recursive functions need return types, cannot work it out on its own

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n,n-1)
  }

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
    2. Factorial function 1 * 2 * 3 * ... * n
    3. A Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n-1) + f (n-2)
    4. Tests if a number is prime.
   */

  def greetingForKids(name: String, age: Int): String = s"Hi, my name is $name and I am $age years old"

  def factorial(number: Int): Int = {
    if (number <= 0) 1
    else number * factorial(number - 1)
  }

  def fibonacci(number: Int): Int = {
    if (number == 1) 1
    else if (number == 2) 1
    else fibonacci(number - 1) + fibonacci(number - 2)
  }

  def isPrime(number: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else number % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(number /2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37 * 17))


}
