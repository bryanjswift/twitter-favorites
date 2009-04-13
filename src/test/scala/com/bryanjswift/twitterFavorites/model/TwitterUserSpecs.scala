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
		val user = new TwitterUser("dpp")
		user.tweets != null && user.tweets.length == 0
	}
}
