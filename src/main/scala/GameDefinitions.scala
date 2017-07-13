trait attribute

abstract class Number extends attribute { val key: String }
case object One extends Number { val key = "1" }
case object Two extends Number { val key = "2" }
case object Three extends Number { val key = "3" }

abstract class Pattern extends attribute { val key: String }
case object Empty extends Pattern { val key = "E" }
case object Striped extends Pattern { val key = "S" }
case object Filled extends Pattern { val key = "F" }

abstract class Shape extends attribute { val key: String }
case object Square extends Shape { val key = "S" }
case object Wave extends Shape { val key = "W" }
case object Diamond extends Shape { val key = "D" }

abstract class Color extends attribute { val key: String }
case object Red extends Color { val key = "R" }
case object Green extends Color { val key = "G" }
case object Purple extends Color { val key = "P" }

case class Card(color: Color, number: Number, pattern: Pattern, shape: Shape)

case class Triplet(first: Card, second: Card, third: Card) {
  private def allTheSameAttributes(first: attribute, second: attribute, third: attribute): Boolean = {
    first == second &&
      second == third &&
      first == third
  }

  private def allDifferentAttributes(first: attribute, second: attribute, third: attribute): Boolean = {
    first != second &&
      second != third &&
      first != third
  }

  private def validAttribute(first: attribute, second: attribute, third: attribute): Boolean = {
    allTheSameAttributes(first: attribute, second: attribute, third: attribute) ||
      allDifferentAttributes(first: attribute, second: attribute, third: attribute)
  }

  private val validColors = validAttribute(first.color, second.color, third.color)
  private val validShapes = validAttribute(first.shape, second.shape, third.shape)
  private val validPatterns = validAttribute(first.pattern, second.pattern, third.pattern)
  private val validNumbers =   validAttribute(first.number, second.number, third.number)

  val validSet: Boolean = validColors && validShapes && validPatterns && validNumbers
}

object GameDefinitions {
  val COLORS: Set[Color] = Set(Red, Green, Purple)
  val SHAPES: Set[Shape] = Set(Square, Wave, Diamond)
  val PATTERNS: Set[Pattern] = Set(Empty, Striped, Filled)
  val NUMBERS: Set[Number] = Set(One, Two, Three)

  type Deck = Set[Card]
}