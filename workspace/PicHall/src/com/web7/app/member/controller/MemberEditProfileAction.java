package com.web7.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;

public class MemberEditProfileAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		ActionForward forward = new ActionForward();
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		
		m_vo = m_dao.getDetail(member_seq);
		
		req.setAttribute("memberBean", m_vo);
		
		forward.setRedirect(false);
		forward.setPath("/edit_profile.jsp");
		
		return forward;
	}

}
