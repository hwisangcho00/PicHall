package com.web7.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;

public class MemberEditProfileOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		
		m_vo = m_dao.getDetail(member_seq);
		
		String key = req.getParameter("key");
		
		switch(key) {

		case "pw":
			//비밀번호 확인
			if(m_dao.checkPw(member_seq, req.getParameter("password"))) {
				m_vo.setMember_pw(m_dao.encrypt(req.getParameter("new_member_pw")));
				m_dao.updatePw(m_vo);
			} else {
				//비밀번호 틀렸을 시
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				out.println("<script>");
				out.println("alert('비밀번호가 올바르지 않습니다. 한 번 더 확인해 주세요')");
				out.println("location.replace('MemberEditProfile.me')");
				out.println("</script>");
				out.close();
				return null;
			}
			
			break;
		
		case "nickname":
			m_vo.setMember_nickname(req.getParameter("new_member_nickname"));
			m_dao.updateNickname(m_vo);
			break;
		
		case "text":
			m_vo.setMember_text(req.getParameter("new_member_text"));
			m_dao.updateText(m_vo);
			break;
			
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		out.println("<script>");
		out.println("alert('회원정보가 성공적으로 변경되었습니다')");
		out.println("location.replace('MemberEditProfile.me')");
		out.println("</script>");
		out.close();
		return null;
	}

}
