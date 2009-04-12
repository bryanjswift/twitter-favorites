package com.bryanjswift.twitterFavorites.model

import org.specs._
import org.specs.runner._
import scala.xml._

class tweetTest extends JUnit4(tweetTests)

object tweetTests extends Specification {
	val favorites = XML.load(getClass.getResourceAsStream("/favorites.xml"))
	val tweet = new Tweet((favorites \\ "status").apply(1))
	def have = addToSusVerb("have")
	"tweet" should have {
		"an id with all digits" in {
			tweet.id matches """\d+"""
		}
		"a message less than or equal to 140 characters" in {
			tweet.message.length <= 140
		}
	}
}
