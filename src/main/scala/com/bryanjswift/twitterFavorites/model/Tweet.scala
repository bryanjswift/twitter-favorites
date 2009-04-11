package com.bryanjswift.twitterFavorites.model

import scala.util.matching.Regex
import scala.xml.Node
import scala.xml.NodeSeq

class Tweet(val status:Node) {
	val id = (status \ "id").text
	val message = (status \ "text").text
	def getUrls() : Iterator[String] = {
		// regex taken from http://snipplr.com/view/2371/regex-regular-expression-to-match-a-url/
		val urlPattern = new Regex("""https?://([-\w\.]+)+(:\d+)?(/([\w/_\.]*(\?\S+)?)?)?""")
		urlPattern findAllIn message
	}
}
