package com.web7.app.exhibition.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;

public class ExhibitionPhotoMainViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		String exhibitionJson = (String) req.getAttribute("exhibitionJson");
		PhotoDAO p_dao = new PhotoDAO();
		
		
		List<PhotoVO> photoBeanList = p_dao.getPhotoList(member_seq);
		req.setAttribute("photoBeanList", photoBeanList);
		
		exhibitionJson = exhibitionJson.replace('\"', '\'');
		req.setAttribute("exhibitionJson", exhibitionJson);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/exhibition_make_main_photo.jsp");
		
		return forward;
	}

}
