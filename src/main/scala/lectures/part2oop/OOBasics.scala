package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")


}

// constructor
class Person(name: String, val age: Int) {
  // body
  val x = 2 // this IS a field by default.

  println(1 + 3) // all code block is executed on instantiation

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  // this.name is the name argument of the constructor

  //overloading - supplying methods with same name but different signatures
  // ie different number/type of arguments
  def greet(): Unit = println(s"Hi, Iam $name") // uses name from constructor
  //  def greet(): Int = 42

  // multiple constructors - not much help since you can do this with default parameters
  def this(name: String) = this(name, 0)
  def this() = this("John doe")
}


// class parameters are NOT Fields