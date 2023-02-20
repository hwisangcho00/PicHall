package com.web7.app.exhibition.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.like.dao.LikeDAO;
import com.web7.app.like.vo.LikeVO;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;

public class ExhibitionViewAction implements Action{
//exhibition_detail_page.jsp와 연결
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ActionForward forward=new ActionForward();
		HttpSession session=req.getSession();
		
		int exhibition_seq = Integer.parseInt(req.getParameter("exhibition_seq"));
		int session_seq=0;
		Object session_id = session.getAttribute("session_seq");
		if(session_id!=null) {
			session_seq = (int) session_id;
		}
		
		ExhibitionDAO e_dao=new ExhibitionDAO();
		MemberDAO m_dao=new MemberDAO();
		LikeDAO l_dao=new LikeDAO();
		MemberVO m_vo=new MemberVO();

		ExhibitionVO e_vo= e_dao.getDetail(exhibition_seq);
		String exhibition_text=e_dao.getExhibitionText(exhibition_seq);
		String exhibition_title=e_dao.getExhibitionTitle(exhibition_seq);
		int member_seq=e_dao.getMemberSeq(exhibition_seq);
		String artist_text= m_dao.getTextbySeq(member_seq);
		m_vo=m_dao.getDetail(member_seq);
		req.setAttribute("memberBean", m_vo);
		
		boolean check=false;
		List<LikeVO> likeList=l_dao.getMemberList(exhibition_seq);

		//이미 like한 경우
		for(LikeVO id:likeList) {
			System.out.println(id.getMember_seq());
			System.out.println(session_seq);
			if(id.getMember_seq()==session_seq) {
				System.out.println("들어옴");
				check=true;
			}
		}
		System.out.println(check);
		if(e_vo != null) {
			req.setAttribute("exhibitionBean", e_vo);
			req.setAttribute("exhibition_text", exhibition_text);
			req.setAttribute("exhibition_title", exhibition_title);
			req.setAttribute("exhibition_seq", exhibition_seq);
			req.setAttribute("artist_text", artist_text);
			req.setAttribute("session_seq", session_seq);
			req.setAttribute("check", check);
			
			forward.setRedirect(false);
			forward.setPath("/exhibition_detail_page.jsp");
			
		}
		return forward;
	}

}
