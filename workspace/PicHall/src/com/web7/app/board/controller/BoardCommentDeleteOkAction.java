package com.web7.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.comment.dao.CommentDAO;

public class BoardCommentDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int comment_seq = Integer.parseInt(req.getParameter("comment_seq"));
		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		
		CommentDAO c_dao = new CommentDAO();
		
		c_dao.deleteComment(comment_seq);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/board/BoardView.bo?board_seq="+board_seq);
		
		return forward;
	}

}
