package com.ljh.mypage.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthInterceptor.class);
	
	// 페이지 요청 정보 저장.
	private void saveDestination(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		if (query == null || query.equals("null")) {
			query = "";
		}else {
			query = "?" + query;
		}
		
		if (request.getMethod().equals("GET")) {
			LOGGER.info("destinatiin : " + (uri + query));
			request.getSession().setAttribute("destination : ", uri + query);
		}
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		if (httpSession.getAttribute("login") == null) {
			LOGGER.info("current user is not logged");
			saveDestination(request);
			response.sendRedirect("/mypage/user/login");
			return false;
		}
		return true;
	}
}
