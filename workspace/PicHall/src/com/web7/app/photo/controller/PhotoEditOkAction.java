package com.web7.app.photo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;

public class PhotoEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int photo_seq = Integer.parseInt(req.getParameter("photo_seq"));
		
		PhotoDAO p_dao = new PhotoDAO();
		PhotoVO p_vo = p_dao.getPhoto(photo_seq);
		
		p_vo.setPhoto_name(req.getParameter("photo_name"));
		p_vo.setPhoto_text(req.getParameter("photo_text"));
		
		p_dao.editPhoto(p_vo);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/picture_manage/photo_manage_re.jsp");
		
		
		return forward;
	}

}
