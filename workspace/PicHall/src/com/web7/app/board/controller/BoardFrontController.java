package com.web7.app.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.ActionForward;

public class BoardFrontController extends HttpServlet{

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
		case "/board/BoardList.bo" :
			try {
				forward = new BoardListAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		
		case "/board/BoardWrite.bo":
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/community_write_page.jsp");
			break;
			
		case "/board/BoardWriteOk.bo":
			try {
				forward = new BoardWriteOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		
		case "/board/BoardView.bo":
			try {
				forward = new BoardViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "/board/BoardModify.bo":
			try {
				forward = new BoardEditAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		
		case "/board/BoardModifyOk.bo":
			try {
				forward = new BoardEditOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "/board/BoardDelete.bo":
			
			try {
				forward = new BoardDeleteOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		
		/* 댓글 */
		case "/board/BoardCommentOk.bo":
			try {
				forward = new BoardCommentOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
		
		case "/board/BoardCommentDeleteOk.bo":
			try {
				forward = new BoardCommentDeleteOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			break;
			
		case "/board/BoardCommentModifyOk.bo":
			try {
				forward = new BoardCommentModifyOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
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




















