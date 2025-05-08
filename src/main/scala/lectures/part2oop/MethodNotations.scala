package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favouriteMovie: String) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply (): String = s"Hi, my anme is $name and I like $favouriteMovie"
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

}
