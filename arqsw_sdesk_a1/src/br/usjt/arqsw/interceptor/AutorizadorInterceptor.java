package br.usjt.arqsw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * @author Otávio Augusto Soares Costa - 816118924
 *
 */
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller)
			throws Exception {
		if (request.getRequestURI().endsWith("login") || request.getRequestURI().endsWith("fazer_login")
				|| request.getRequestURI().contains("css") || request.getRequestURI().contains("js")
				|| request.getRequestURI().contains("img")) {
			return true;
		}
		if (request.getSession().getAttribute("usuarioLogado") != null) {
			return true;
		}
		response.sendRedirect("login");
		return false;
	}

}
