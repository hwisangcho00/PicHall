package com.web7.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;

public class MemberLoginOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		ActionForward forward = new ActionForward();
		
		MemberDAO m_dao = new MemberDAO();
		
		String id = req.getParameter("member_id");
		String pw = req.getParameter("member_pw");
		
		if(m_dao.login(id, pw)) {
			//성공시 메인 페이지로 이동
			session.setAttribute("session_seq", m_dao.getSeq(id));
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/index.jsp");
		}else {
			//로그인 실패 시 /app/member/loginForm.jsp?login=false로 이동
			forward.setRedirect(false);
			forward.setPath("/login.jsp?login=false");
		}
		return forward;
	}
}


















