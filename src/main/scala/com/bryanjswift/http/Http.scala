package com.bryanjswift.http

import com.google.appengine.api.urlfetch.{HTTPRequest,URLFetchService,URLFetchServiceFactory}

class Http(val host:String) {
	def apply(uri:String) = new Request(uri)

	class Request(req:HTTPRequest)
}

object Http {
	def apply(host:String) = new Http(domain)
}
