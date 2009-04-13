package com.bryanjswift.twitterFavorites.model

import org.specs.Specification
import org.specs.runner.JUnit4

class TwitterUserTest extends JUnit4(TwitterUserSpecs)

object TwitterUserSpecs extends Specification {
	"TwitterUser must have a non-null username" in {
		try {
			val user = new TwitterUser(null)
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected result
		}
	}
	"TwitterUser must have a username that isn't empty" in {
		try {
			val user = new TwitterUser("")
			false // exception should be thrown
		} catch {
			case iae:IllegalArgumentException =>
				true // expected result
		}
	}
	"TwitterUser has an empty list of tweets when initialized" in {
		val user = new TwitterUser("bryanjswift")
		user.tweets != null && user.tweets.length == 0
	}
	"TwitterUser.fetchTweets" should {
		val user = new TwitterUser("bryanjswift")
		val tweets = user.fetchTweets
		"not be empty" in {
			!tweets.isEmpty
		}
		"have a size less than or equal to 20" in {
			tweets.length <= 20 && tweets.length >= 1
		}
		"have the same number of tweets in it as in the TwitterUser.tweets property" in {
			user.tweets.length == tweets.length
		}
		"produce an empty result if called again immediately" in {
			val moreTweets = user.fetchTweets
			moreTweets.length == 0
		}
	}
}
