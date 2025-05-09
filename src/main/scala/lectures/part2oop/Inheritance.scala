package lectures.part2oop

object Inheritance extends App {
  sealed class Animal {
    val creatureType ="Wild"
    def eat = println("nomnom")
  }

  // single class inheritance
  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat

  // Cat is subclass, Animal is Superclass

  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch, crunch")
    } // overrides an inherited eat metho from Animal
  }

  // equivalent to
  // class Dog(dogtype: String) extends Animal {
  //  override val creatureType = "domestic"
  //  override def eat = println("crunch, crunch")
  // }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // overriding (different implementation in subclass with same signature) vs overloading (multiple signatures an same class)

  // super

  // preventing overrides
  // 1 - use final . eg final def eat // ie final on member
  // 2 - use final on the entire class
  // 3 - seal the class = extend classes in THIS FILE, prevent extension in other clesses
}
