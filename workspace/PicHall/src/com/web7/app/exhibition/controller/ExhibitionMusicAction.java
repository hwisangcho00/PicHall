package com.web7.app.exhibition.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;

public class ExhibitionMusicAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		String exhibitionJson = (String) req.getAttribute("exhibitionJson");
		req.setAttribute("exhibitionJson", exhibitionJson);
		
		String main_photo_data = (String)req.getParameter("main_photo_data");
		req.setAttribute("main_photo_data", main_photo_data);
		
		String photoListJson = (String)req.getAttribute("photoListJson");
		req.setAttribute("photoListJson", photoListJson);
		
		MusicDAO mu_dao = new MusicDAO();
		
		List<MusicVO> musicBeanList = mu_dao.getMusicList(member_seq);
		
		req.setAttribute("musicBeanList", musicBeanList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/exhibition_make_music.jsp");
		
		return forward;
	}

}
