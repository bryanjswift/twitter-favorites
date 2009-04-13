package com.bryanjswift.twitterFavorites.model

import dispatch.Http
import scala.collection.mutable.ListBuffer

class TwitterUser(val username:String) {
	require(username != null && username.length > 0)
	val tweets = new ListBuffer[Tweet]()
	//val http = new Http("twitter.com")
	def fetchTweets:Unit = {
		
	}
}
