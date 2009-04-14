package com.bryanjswift.twitterFavorites.model

import org.specs.Specification
import org.specs.runner.JUnit4
import scala.xml.XML

class TweetTest extends JUnit4(TweetSpecs)

object TweetSpecs extends Specification {
	def have = addToSusVerb("have")
	"tweet" should have {
		val favorites = XML.load(getClass.getResourceAsStream("/favorites.xml"))
		val tweet = new Tweet((favorites \\ "status")(1))
		"an id with all digits" in {
			tweet.id matches """\d+"""
		}
		"a message less than or equal to 140 characters" in {
			tweet.message.length <= 140
		}
	}
	"status with text consisting of only 1 url" should have {
		val status = <status><id>7865234</id><text>http://lift-example.appspot.com/index</text></status>
		val tweet = new Tweet(status)
		val urls = tweet.getUrls
		"getUrls length of 1" in {
			urls.length == 1
		}
		"first element of getUrls equal to status.text" in {
			urls(0) == (status \ "text").text
		}
	}
	"status with text consisting of only 2 urls" should have {
		val status = <status><id>7865234</id><text>http://bryanjswift.com http://lift-example.appspot.com/index</text></status>
		val tweet = new Tweet(status)
		val urls = tweet.getUrls
		"getUrls length of 2" in {
			urls.length == 2
		}
		"getUrls with the same values as status.text.split" in {
			val texts = (status \ "text").text.split(" ")
			texts(0) == urls(0) && texts(1) == urls(1)
		}
	}
	"status with text consisting of words and 2 urls" should have {
		val status = <status><id>7865234</id><text>these are http://bryanjswift.com some stupid http://lift-example.appspot.com/index links</text></status>
		val tweet = new Tweet(status)
		val urls = tweet.getUrls
		"getUrls length of 2" in {
			urls.length == 2
		}
	}
	"status with id less should be ordered lower" in {
		val t1 = new Tweet(<status><id>123</id><text>just a test 1</text></status>)
		val t2 = new Tweet(<status><id>456</id><text>just a test 2</text></status>)
		t1 < t2
	}
}
