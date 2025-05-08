package lectures.part1basics

object ValuesVariablesTypes extends App {
// val x: Int = 42
  // compiler infers type - hover to see
 val x = 42
 println(x)

 // VALS ARE IMMUTABLE
 // x = 2 not allowed

 val aString: String = "hello";
 // semicolons allowed but not needed in scala

 val aBoolean = false
 val aChar: Char = 'a'
 val anInt: Int = x // 4 byte representation
 val aShort: Short = 4613 // like int but max 2 byte representation
 val aLong: Long = 5273985273895237L // 8 byte representation, needs L
 val aFloat: Float = 2.0f // needs f
 val aDouble: Double = 3.14

 // variables
 var aVariable: Int = 4
 aVariable = 5 // side effects

  // prefer vals over vars



}
