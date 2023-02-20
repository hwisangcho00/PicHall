package com.web7.app.like.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.like.dao.LikeDAO;
import com.web7.app.like.vo.LikeVO;

public class LikeCancelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		ActionForward forward = null;
		
		LikeDAO l_dao=new LikeDAO();
		LikeVO l_vo=new LikeVO();
		ExhibitionDAO e_dao=new ExhibitionDAO();
		ExhibitionVO e_vo=new ExhibitionVO();
		
		HttpSession session = req.getSession();
		
		int member_seq= (int)session.getAttribute("session_seq");
		int exhibition_seq=Integer.parseInt(req.getParameter("exhibition_seq"));
		
		l_vo.setExhibition_seq(exhibition_seq);
		l_vo.setMember_seq(member_seq);
		e_vo=e_dao.getDetail(exhibition_seq);
		
		if(l_dao.cancel(l_vo)) {
			int like_cnt=l_dao.getlikeCnt(exhibition_seq);
			e_vo.setLike_cnt(like_cnt);
			if(e_dao.updateLikeCnt(e_vo)) {//좋아요 취소와 좋아요 개수변경이 모두 완료되야 들어옴
				forward=new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath()+"/exhibition/ExhibitionView.ex?exhibition_seq="+exhibition_seq);
				
				return forward;
			}
		}
		return null;
	}

}
