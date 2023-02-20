package com.web7.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;
import com.web7.util.SHA256;

public class MemberJoinSuccessOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int member_seq = Integer.parseInt(req.getParameter("member_seq"));
		String code = req.getParameter("code");
		
		
		MemberDAO m_dao = new MemberDAO();
		MemberVO m_vo = m_dao.getDetail(member_seq);
		
		String email = m_dao.getEmailbySeq(member_seq);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		if(m_vo.getMember_email_checked() == 1) {
			
			out.println("<script>");

			out.println("alert('이미 인증된 회원입니다');");

			out.println("location.replace('MemberLogin.me')");

			out.println("</script>");

			out.close();	
			
			return null;
		}
		
		if(SHA256.getSHA256(email).equals(code)) {
			m_dao.updateEmailChecked(m_vo);
			
			out.println("<script>");

			out.println("alert('인증 성공!');");

			out.println("location.replace('MemberLogin.me')");

			out.println("</script>");

			out.close();	
			
			return null;
		}
		
		out.println("<script>");

		out.println("alert('유효하지 않은 코드입니다');");

		out.println("location.replace('index.jsp')");

		out.println("</script>");

		out.close();
		
		return null;
	}

}
