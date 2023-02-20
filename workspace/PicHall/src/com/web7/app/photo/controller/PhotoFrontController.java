package com.web7.app.photo.controller;

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
import com.web7.app.exhibition.controller.All_exhibitionListAction;
import com.web7.app.exhibition.controller.ExhibitionMultiverseViewAction;
import com.web7.app.exhibition.controller.ExhibitionViewAction;
import com.web7.app.exhibition.controller.Recommend_exhibitionListAction;
import com.web7.app.exhibition.controller.UserPageAction;

public class PhotoFrontController extends HttpServlet{
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
		case "/photo/PhotoView.ph" :
			try {
				forward = new PhotoViewAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		
		case "/photo/PhotoDeleteOk.ph":
			try {
				forward = new PhotoDeleteOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		
		case "/photo/PhotoDownload.ph":
			try {
				forward = new PhotoDownloadAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
			
		case "/photo/PhotoUploadOk.ph":
			try {
				forward = new PhotoUploadOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/photo/PhotoEditOk.ph":
			try {
				forward = new PhotoEditOkAction().execute(req, resp);
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
