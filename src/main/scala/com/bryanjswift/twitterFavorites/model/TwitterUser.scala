package com.bryanjswift.twitterFavorites.model

import scala.collection.mutable.ListBuffer

class TwitterUser(val username:String) {
	require(username != null && username.length > 0)
	val tweets = new ListBuffer[Tweet]()
	def fetchTweets:Unit = {
	}
}
