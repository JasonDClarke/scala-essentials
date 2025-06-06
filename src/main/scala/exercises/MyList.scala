package exercises

abstract class MyList {

  /*
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add(int) => new list with this element added
    toString = a string representation of the list
   */
  def head:Int

  def tail: MyList

  def isEmpty: Boolean

  def add(int: Int): MyList

  // polymorphic call
  def printElements: String // space separated

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h:Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, Cons(h, this))
  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {

  val list = new Cons(1, Empty)
  println(list.head)

  val newList = new Cons(2, list)
  println(Empty)
  println(list)
  println(newList)

  val longList = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(longList)
  println(longList.add(4))
}