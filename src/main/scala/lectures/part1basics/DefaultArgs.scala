package lectures.part1basics

object DefaultArgs extends App {
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <=1) acc
    else trFact(n-1, n*acc)
  }

  val fact10 = trFact(10)

  def savePicture
  (format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit =
    println("saving pictures")

  savePicture(width = 800)

  /*
    1. pass in every leading argument
    2. name the arguments
   */

  savePicture(height = 600, width = 800, format = "bmp")

  // when you call a function frequently with same parameters you can set default value
  // its possible to use later parameters only by naming them
}
