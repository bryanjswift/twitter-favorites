package com.bryanjswift.twitterFavorites.model

import scala.collection.mutable.ListBuffer

class TwitterUser(val username:String) {
	val tweets = new ListBuffer[Tweet]()
}
