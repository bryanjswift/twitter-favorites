package com.bryanjswift.twitterFavorites.model

import dispatch.Http
import scala.collection.mutable.ListBuffer
import scala.xml.NodeSeq

class TwitterUser(val username:String) {
	require(username != null && username.length > 0)
	val tweets = new ListBuffer[Tweet]()
	val request = (new Http("twitter.com"))("/favorites/" + username + ".xml")
	def fetchTweets:Seq[Tweet] = {
		def processTweets(nodes:NodeSeq):Unit = {
			(nodes \\ "status").elements.foreach((status) => {
				tweets += new Tweet(status)
			})
		}
		val lastId = if (!tweets.isEmpty) tweets.last.id else null
		if (lastId == null) request <> processTweets else request ?< Map("since_id" -> lastId) <> processTweets
		tweets.filter((tweet) => lastId == null || tweet.id > lastId)
	}
}
