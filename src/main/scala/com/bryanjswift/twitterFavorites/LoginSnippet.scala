package com.bryanjswift.twitterFavorites

import javax.servlet.http.{HttpServletRequest => Request}
import com.google.appengine.api.users._

object LoginSnippet {
	def render(request:Request) = {
		val userService = UserServiceFactory.getUserService
		val user = userService.getCurrentUser

		if (user == null) {
			<p>Hello! <a href={userService.createLoginURL(request.getRequestURI)}>Sign in</a> just for kicks.</p>
		} else {
			<p>Hello, {user.getNickname}! Now you can <a href={userService.createLogoutURL(request.getRequestURI)}>sign out</a> again.</p>
		}
	}
}
