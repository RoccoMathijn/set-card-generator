import GameDefinitions.{ COLORS, Deck, NUMBERS, PATTERNS, SHAPES }

object SetGame extends App {
  def generateDeck: Deck = for {
    number <- NUMBERS
    pattern <- PATTERNS
    shape <- SHAPES
    color <- COLORS
  } yield Card(color, number, pattern, shape)

  val deck = generateDeck

  CardGenerator.writeSvgDeck(deck)
}