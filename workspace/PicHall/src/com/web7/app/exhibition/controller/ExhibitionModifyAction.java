package com.web7.app.exhibition.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;

public class ExhibitionModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		ActionForward forward=new ActionForward();
		
		int exhibition_seq=Integer.parseInt(req.getParameter("exhibition_seq"));
		ExhibitionVO e_vo=new ExhibitionVO();
		ExhibitionDAO e_dao=new ExhibitionDAO();
		
		e_vo=e_dao.getDetail(exhibition_seq);
		
		//이 전시회를 만든 회원이 아니라면
		if(member_seq != e_vo.getMember_seq()) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			
			out.println("<script>");

			out.println("alert('전시회 주인만 전시회를 수정할 수 있습니다');");

			out.println("history.go(-1)");

			out.println("</script>");

			out.close();	
		
			return null;
		}
		
		req.setAttribute("exhibitionBean", e_vo);
		
		forward.setRedirect(false);
		forward.setPath("/exhibition_modify.jsp");
		
		return forward;
	}

}
