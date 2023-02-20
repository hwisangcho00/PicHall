package com.web7.app.board.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.comment.dao.CommentDAO;
import com.web7.app.comment.vo.CommentVO;

public class BoardCommentOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		HttpSession session = req.getSession();
		int member_seq = (int) session.getAttribute("session_seq");
		
		CommentVO comment = new CommentVO();
		CommentDAO c_dao = new CommentDAO(); 
		
		comment.setBoard_seq(Integer.parseInt(req.getParameter("board_seq")));
		comment.setComment_text(req.getParameter("comment_text"));
		comment.setMember_seq(member_seq);
		
		if (c_dao.insertComment(comment)) {
			forward = new ActionForward();
			forward.setPath(req.getContextPath()+"/board/BoardView.bo?board_seq="+req.getParameter("board_seq"));
			forward.setRedirect(true);
			return forward;
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");

		out.println("<script>");
		out.println("alert('댓글 작성 실패. 다시 시도해주세요')");
		out.println("</script>");
		out.close();
		
		return forward;
	}

}
