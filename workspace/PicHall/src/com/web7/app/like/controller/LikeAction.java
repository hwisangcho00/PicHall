package com.web7.app.like.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.like.dao.LikeDAO;
import com.web7.app.like.vo.LikeVO;

public class LikeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		
		int member_seq=0;
		LikeDAO l_dao=new LikeDAO();
		LikeVO l_vo=new LikeVO();
		ExhibitionDAO e_dao=new ExhibitionDAO();
		ExhibitionVO e_vo=new ExhibitionVO();
		
		HttpSession session = req.getSession();
		System.out.println("들어옴1");
		Object member= session.getAttribute("session_seq");
		if(member == null) {
			//로그인 페이지로 보내기
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");

			out.println("<script>");
			out.println("alert('로그인해주세요')");
			out.println("location.href='/PicHall/login.jsp'");
			out.println("</script>");
			out.close();

			return null;
		}else {
			member_seq=(int) member;
		}
		System.out.println("들어옴2");
		int exhibition_seq=Integer.parseInt(req.getParameter("exhibition_seq"));
		
		l_vo.setExhibition_seq(exhibition_seq);
		l_vo.setMember_seq(member_seq);
		e_vo=e_dao.getDetail(exhibition_seq);
		
		if(l_dao.like(l_vo)) {
			int like_cnt = l_dao.getlikeCnt(exhibition_seq);
			e_vo.setLike_cnt(like_cnt);
			if(e_dao.updateLikeCnt(e_vo)) {//좋아요와 likeCnt가 전부 증가해야 통과
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath()+"/exhibition/ExhibitionView.ex?exhibition_seq="+exhibition_seq);
				
				return forward;
			}
		}
		return null;
	}

}
