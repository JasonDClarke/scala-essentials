package lectures.part1basics

object CBNvsCBV extends App {
  def calledByValue(x: Long): Unit = {
    println("by value: " + x) // uses the value 439207015400
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x) // lazily uses the System.nanoTime(). Uses the expression which is reevaluated every time
    println("by name: " + x) // System.nanoTime()
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinite(), 34)
  printFirst(34, infinite())
}
