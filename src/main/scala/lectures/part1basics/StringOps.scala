package lectures.part1basics

object StringOps extends App {
  val str: String = "Hello, I am learning Scala"


  // java functions available in scala
  println(str.charAt(2)) // l
  println(str.substring(7, 11)) // I am
  println(str.split(" ").toList) // array
  println(str.startsWith("Hello")) // true
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z') // a45z
  println(str.reverse) // alacS gn...
  println(str.take(2)) // He

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"

  val anotherGreeting = s"Hello my name is $name and i will be turning ${age + 1} years old"
  println(anotherGreeting)

  // f-interpolators (f for format)
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)
  // 2.2 -> 2 characters total, minimum, 2 decimals precision
  // f interpolators can check for type correctness

  // raw-interpolator
  println(raw"This is a \n newline") // special chars like \n will not be escaped

  val escaped = "This is a \n newline"
  println(raw"$escaped") // but the injected variables DO get escaped



}
