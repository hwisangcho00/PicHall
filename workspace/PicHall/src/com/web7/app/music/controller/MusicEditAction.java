package com.web7.app.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;

public class MusicEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int music_seq = Integer.parseInt(req.getParameter("music_seq"));
		MusicVO mu_vo = new MusicVO();
		MusicDAO mu_dao = new MusicDAO();
		
		mu_vo = mu_dao.getMusic(music_seq);
		
		req.setAttribute("musicBean", mu_vo);
		
		forward.setRedirect(false);
		forward.setPath("/my_music_edit_page.jsp");
		
		return forward;
	}

}
