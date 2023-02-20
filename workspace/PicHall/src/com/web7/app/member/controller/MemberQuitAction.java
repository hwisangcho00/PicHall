package com.web7.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;

public class MemberQuitAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		String member_id = new MemberDAO().getId(member_seq);
		
		req.setAttribute("member_seq", member_seq);
		req.setAttribute("member_id", member_id);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/user_quit.jsp");
		
		return forward;
	}

}












