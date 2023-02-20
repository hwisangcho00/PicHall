package com.web7.app.music.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.ActionForward;
import com.web7.app.board.controller.BoardCommentDeleteOkAction;
import com.web7.app.board.controller.BoardCommentModifyOkAction;
import com.web7.app.board.controller.BoardCommentOkAction;
import com.web7.app.board.controller.BoardDeleteOkAction;
import com.web7.app.board.controller.BoardEditAction;
import com.web7.app.board.controller.BoardEditOkAction;
import com.web7.app.board.controller.BoardListAction;
import com.web7.app.board.controller.BoardViewAction;
import com.web7.app.board.controller.BoardWriteOkAction;

public class MusicFrontController extends HttpServlet {

	/**
	 * 
	 */
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

		switch (command) {
		case "/music/MusicMyPage.mu":
			try {
				forward = new MusicMyPageAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "/music/MusicAdd.mu":
			forward = new ActionForward();
			forward.setPath("/my_music_add_page.jsp");
			forward.setRedirect(false);
			break;

		case "/music/MusicAddOk.mu":
			try {
				forward = new MusicAddOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
			
		case "/music/MusicDeleteOk.mu":
			try {
				forward = new MusicDeleteOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;

		case "/music/MusicEdit.mu":
			try {
				forward = new MusicEditAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "/music/MusicEditOk.mu":
			try {
				forward = new MusicEditOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			

		default:
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}

		// 일괄처리
		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}

}
