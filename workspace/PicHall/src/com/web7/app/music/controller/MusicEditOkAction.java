package com.web7.app.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;

public class MusicEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// TODO Auto-generated method stub
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int music_seq = Integer.parseInt(req.getParameter("music_seq"));
		
		MusicDAO mu_dao = new MusicDAO();
		MusicVO mu_vo = mu_dao.getMusic(music_seq);
		
		mu_vo.setMusic_title(req.getParameter("music_title"));
		mu_vo.setMusic_artist(req.getParameter("music_artist"));
		
		mu_dao.modifyMusic(mu_vo);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/music/MusicMyPage.mu");
		
		
		return forward;
	}

}
