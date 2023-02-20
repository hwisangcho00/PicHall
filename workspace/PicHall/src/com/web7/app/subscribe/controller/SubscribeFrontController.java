package com.web7.app.subscribe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.app.subscribe.controller.SubscribeOkAction;
import com.web7.action.ActionForward;

public class SubscribeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		ActionForward forward = null;
		
		switch(command) {
		case "/subscribe/UserView.su" :
			try {
				forward = new UserPageAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		case "/subscribe/SubscribeOk.su" :
			try {
				forward = new SubscribeOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		case "/subscribe/ViewFollowing.su" :
			try {
				forward = new UserPageAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		case "/subscribe/ViewFollowed.su" :
			try {
				forward = new UserPageAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}
		
		//일괄처리
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
