package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract class with abstract members
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }
  // abstract classes cannot be instantiated
//  val animal = new Animal // Class Animal is abstract, cannot be instantiated

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }
  //  override keyword is NOT required for overriding fields from abstract classes

  // traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "croc"
    def eat = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // both traits and abstract classes and have abstract and non-abstract members
  // they are pretty similar BUT
  // 1 - traits do NOT have constructor parameters
  // 2 - multiple traits may be inherited by the same class
  // 3 - traits = behaviour, DOING, abstract class = thing

  // type hierarchy
  // scala.Any -> scala.AnyRef (java.lang.Object)
  // scala.Any -> scala.AnyVal (Int, Unit, Boolean, Float, ...)  - rarely need to extend this because its primitive types
  // scala.Null can replace any scala.AnyRef (ie null extends anything in AnyRef
  // scala.Nothing is a subtype of EVERY instance in scala (AnyRef and AnyVal)
}
