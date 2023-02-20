package com.web7.app.board.controller;


import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.attach.dao.AttachDAO;
import com.web7.app.attach.vo.AttachVO;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.comment.dao.CommentDAO;

public class BoardDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		
		BoardDAO b_dao = new BoardDAO();
		AttachDAO a_dao = new AttachDAO();
		CommentDAO c_dao = new CommentDAO();
		
		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\board\\upload";
		
		for(AttachVO attach : a_dao.getDetail(board_seq)) {
			File f = new File(saveFolder, attach.getAttach_name());
			
			if(f.exists()) {
				f.delete();
			}
		}
		
		a_dao.deleteAttach(board_seq);
		
		c_dao.deleteAllComment(board_seq);
		
		b_dao.deleteBoard(board_seq);
		
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/board/BoardList.bo");
		
		return forward;
	}

}












