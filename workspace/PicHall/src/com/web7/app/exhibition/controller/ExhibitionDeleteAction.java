package com.web7.app.exhibition.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.like.dao.LikeDAO;
import com.web7.app.music_exhibition.dao.MusicExhibitionDAO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.report.dao.ReportDAO;

public class ExhibitionDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int exhibition_seq=Integer.parseInt(req.getParameter("exhibition_seq"));
		//음악 삭제
		MusicExhibitionDAO me_dao=new MusicExhibitionDAO();
		me_dao.deleteAll(exhibition_seq);
		//사진 삭제
		PhotoExhibitionDAO pe_dao=new PhotoExhibitionDAO();
		pe_dao.deleteAll(exhibition_seq);
		//신고 삭제
		ReportDAO r_dao=new ReportDAO();
		r_dao.deleteAll(exhibition_seq);
		//좋아요 삭제
		LikeDAO l_dao=new LikeDAO();
		l_dao.deleteAll(exhibition_seq);
		//전시회 삭제
		ExhibitionDAO e_dao=new ExhibitionDAO();
		e_dao.deleteExhibition(exhibition_seq);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/member/MemberMyPage.me");
		
		return forward;
	}
	
}
