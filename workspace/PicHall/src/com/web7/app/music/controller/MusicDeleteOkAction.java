package com.web7.app.music.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;
import com.web7.app.music_exhibition.dao.MusicExhibitionDAO;

public class MusicDeleteOkAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		int music_seq = Integer.parseInt(req.getParameter("music_seq"));
		MusicVO mu_vo = new MusicVO();
		MusicDAO mu_dao = new MusicDAO();
		MusicExhibitionDAO me_dao = new MusicExhibitionDAO();
		
		mu_vo = mu_dao.getMusic(music_seq);
		
		String saveFolder= "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\music";
		File f = new File(saveFolder, mu_vo.getMusic_data());
		
		if(f.exists()) {
			f.delete();
		}
		
		//전시회에 사용되었던 것 먼저 삭제
		me_dao.delete(music_seq);
		//그냥 tbl_music에서 삭제
		mu_dao.deleteMusic(music_seq);
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/music/MusicMyPage.mu");
		
		return forward;
	}

}
