package com.web7.app.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.attach.dao.AttachDAO;
import com.web7.app.attach.vo.AttachVO;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.board.vo.BoardVO;

public class BoardEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		
		BoardDAO b_dao = new BoardDAO();
		BoardVO b_vo = new BoardVO();
		
		AttachDAO a_dao = new AttachDAO();
		
		List<AttachVO> attachList = a_dao.getDetail(board_seq);
		
		b_vo = b_dao.getBoard(board_seq);
		
		req.setAttribute("boardBean", b_vo);
		req.setAttribute("attachBeanList", attachList);
		ActionForward forward = new ActionForward();
		
		forward.setPath("/community_edit_page.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
