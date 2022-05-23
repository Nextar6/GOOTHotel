package edu.spring.hotel.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class AuthInterceptor extends HandlerInterceptorAdapter{
	private static final Logger logger =
			LoggerFactory.getLogger(AuthInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("===== preHandle 호출");
		
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		
		if(userid != null) {
			logger.info("로그인 상태 -> controller method 실행");
			
			return true; 
		}else {
			logger.info("로그아웃 상태 -> controller method 실행 안됨");

			saveDestination(request);
			response.sendRedirect("/hotel/member/login");
			return false; 
		}
	}
	
	private void saveDestination(HttpServletRequest request) {
		logger.info("saveDestination() 호출");
		
		String uri = request.getRequestURI();
		logger.info("요청 URI : " + uri);
		String contextRoot = request.getContextPath();
		logger.info("contextRoot : " + contextRoot);
		
		uri = uri.replace(contextRoot, "");
		
		String queryString = request.getQueryString();
		logger.info("쿼리 스트링 : " + queryString);
		
		String targetURL = "";
		if(queryString == null) {
			targetURL = uri;
		} else {
			targetURL = uri + "?" + queryString;
		}
		
		logger.info("targetURL : " + targetURL);
		request.getSession().setAttribute("targetURL", targetURL);
	}

}