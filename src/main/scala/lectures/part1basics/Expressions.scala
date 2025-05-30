package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2 // EXPRESSION
  println(x)

  println(2 + 3 * 4) // // + - * /, Bitwise operations & | ^ << >> >>> (right shift with zero extension)

  println(1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable +=3 // also works with -=, *=, /= ... side effects
  println(aVariable)

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionedValue = if (aCondition) 5 else 3 // if expression
  println(aConditionedValue)
  println(if (aCondition) 5 else 3)
  println(1 + 3)

  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // NEVER WRITE THIS AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "Goodbye"
  }

//  val anotherValue = z + 1 z only defined in scope of code block, causes exception

// 1. difference between "hello world" vs println("hello world")
  // value of type string vs side effect returning Unit that has side effect of printing to console

  // 2.

  val someValue = {
    2 < 3
  }
  // returns true

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }
  // returns 42




}
