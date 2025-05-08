package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply (): String = s"Hi, my anme is $name and I like $favouriteMovie"
    def apply (n:Int): String = s"$name watched $favouriteMovie $n times"

    def +(nickname: String): Person = new Person(s"$name $nickname", favouriteMovie)

    def learns(thing: String): String = s"$name is learning $thing"
    def learnsScala = this learns "Scala" // equivalent to this.learns ie calling the learns method.
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // infix notation = operator notation(syntactic sugar)

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
//  println(mary + tom)
//  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS.
  // Akka actors have ! ?
  
  // prefix notation
  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-
  // unary_prefix only works with - + ! ~
  
  println(!mary)
  println(mary.unary_!)

  // postfix notation
  println(mary.isAlive)
  //  println(mary isAlive)

  println(mary.apply())
  println(mary())


  /*
    1. Overload the + Operator
      mary + "the rockstar" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
      Add a unary + operator => new person with the age + 1

    3. Add a "learns" method in the Person class => "Mary learns Scala"
       Add a learnsScala method, calls learns method with "Scala".
       Use it in postfix notation

    4. Overload the apply method
       mary.apply(2) => "Mary watched Inception 2 times
   */

  println((mary + "the Rockstar").apply())
  println((+mary).age) // 1
  println(mary learnsScala)
  println(mary(10))

  // scala 3 note: dont use postfix ops.
  // if you must, use scala.language.postfixOps
  // and  Use only on methods with no parameters
}
