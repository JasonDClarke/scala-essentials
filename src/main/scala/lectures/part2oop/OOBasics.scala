package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Daniel")

  val author = new Writer("Charles", "Dickens", 1812)
  val imposter = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge())
  println(novel.isWrittenBy(author)) // true
  println(novel.isWrittenBy(imposter)) // false

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
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

/*
  Novel and a Writer

  Writer: first name, surname, year
    - method fullname

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) new instance of Novel
*/

class Writer(firstName: String, surname: String, val year: Int) {
  def fullname() = s"$firstName $surname"
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {
  def authorAge(): Int = {
    yearOfRelease - author.year
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYearOfRelease: Int): Novel = {
    new Novel(name, newYearOfRelease, author)
  }
}


/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
*/

class Counter(val int: Int = 0) {
  //  def currentCount = {
  //    int
  //  }

  def increment = {
    println("Incrementing!")
    new Counter(int + 1)
  } // immutability

  def decrement = {
    println("ecrementing!")
    new Counter(int - 1)
  } // immutability!!

  //  def increment(incrementBy: Int) = new Counter(int + incrementBy) // immutability!!!
  def increment(n: Int): Counter = {
    if (n <= 0) this
    else {
      println("Incrementing!")
      increment.increment(n - 1)
    }
  }

  //  def decrement(decrementBy: Int) = new Counter(int - decrementBy) // immutability!!!!
  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else {
      println("Decrementing!")
      decrement.decrement(n - 1)
    }
  }

  def print = println(int)

}


// class parameters are NOT Fields