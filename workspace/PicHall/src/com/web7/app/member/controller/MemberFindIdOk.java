package com.web7.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;

public class MemberFindIdOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		
		String member_name = req.getParameter("name");
		String member_email = req.getParameter("email");
		
		MemberDAO m_dao = new MemberDAO();
		
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html;charset=utf-8");
		
		String member_id = m_dao.findId(member_name, member_email);
		
		if(member_id != null) {
			out.println(member_id);
		}else {
			out.println("no");
		}
		out.close();
		return null;
	}

}












