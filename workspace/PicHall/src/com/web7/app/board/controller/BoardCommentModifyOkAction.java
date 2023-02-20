package com.web7.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.comment.dao.CommentDAO;
import com.web7.app.comment.vo.CommentVO;

public class BoardCommentModifyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		
		CommentDAO c_dao = new CommentDAO();
		CommentVO c_vo = new CommentVO();
		ActionForward forward = new ActionForward();
		
		int comment_seq = Integer.parseInt(req.getParameter("comment_seq"));
		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		String comment_text = req.getParameter("reply_content"+req.getParameter("num"));
		
		c_vo.setComment_seq(comment_seq);
		c_vo.setComment_text(comment_text);
		
		c_dao.modifyComment(c_vo);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/board/BoardView.bo?board_seq="+board_seq);
		
		return forward;
	}

}
