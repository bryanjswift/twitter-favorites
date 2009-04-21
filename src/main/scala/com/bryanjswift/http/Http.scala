package com.bryanjswift.http

import com.google.appengine.api.urlfetch.{FetchOptions,HTTPMethod,HTTPRequest,URLFetchService,URLFetchServiceFactory}
import java.net.URL

class Http(scheme:String, host:String, port:Int) {
	def this(scheme:String, host:String) = this(scheme, host, 80)
	def this(host:String, port:Int) = this("http", host, port)
	def this(host:String) = this("http", host, 80)

	def apply(uri:String) = new Request(uri)

	class Request(req:HTTPRequest) {
		def this(uri:String) = this(new HTTPRequest(
			new URL(scheme, host, port, uri), HTTPMethod.GET, FetchOptions.Builder.disallowTruncate))
		def ?(values:Map[String,Any]) {
			Map[String,Any]()
		}
	}
}

object Http {
	def apply(host:String) = new Http(host)
}
