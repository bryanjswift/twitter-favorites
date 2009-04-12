package com.bryanjswift.twitterFavorites.model

class TwitterUser(val username:String) {
	val tweets = new ListBuffer[Tweet]()
}
