import SetGame.generateDeck
import org.scalatest.WordSpec

class SetGameSpec extends WordSpec {

  "A triplet" should {
    "be valid for a triplet with only one attribute the same" in {
      val card1 = Card(Red, One, Empty, Square)
      val card2 = Card(Red, Two, Empty, Square)
      val card3 = Card(Red, Three, Empty, Square)
      val triplet = Triplet(card1, card2, card3)
      assert(triplet.validSet)
    }

    "be valid for a triplet with all attributes different" in {
      val card1 = Card(Purple, One, Striped, Square)
      val card2 = Card(Purple, Two, Filled, Wave)
      val card3 = Card(Purple, Three, Empty, Diamond)
      val triplet = Triplet(card1, card2, card3)
      assert(triplet.validSet)
    }

    "be invalid for a triplet where attributes are not all the same or different" in {
      val card1 = Card(Purple, One, Striped, Square)
      val card2 = Card(Green, Two, Filled, Wave)
      val card3 = Card(Green, Two, Empty, Diamond)
      val triplet = Triplet(card1, card2, card3)
      assert(!triplet.validSet)
    }

    "example 4" in {
      val card1 = Card(Red, One, Striped, Diamond)
      val card2 = Card(Green, Two, Empty, Square)
      val card3 = Card(Red, Three, Filled, Wave)
      val triplet = Triplet(card1, card2, card3)
      assert(!triplet.validSet)
    }
  }

  "SetGame" should {
    val deck = generateDeck
    println(deck.head)
    val subsets = deck.subsets(3)
    val triplets: Seq[Triplet] = subsets.map(subset => {
      val list = subset.toList
      Triplet(list(0), list(1), list(2))
    }).toList

    val validTriplets: Seq[Triplet] = triplets.filter(triplet => triplet.validSet)
    val invalidTriplets: Seq[Triplet] = triplets.filterNot(triplet => triplet.validSet)

    "have 85320 total triplets" in assert(triplets.size === 85320)
    "have 1080 valid triplets" in assert(validTriplets.size === 1080)
    "have 84240 invalid triplets" in  assert(invalidTriplets.size === 84240)
  }
}
