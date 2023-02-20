package com.web7.app.music.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;

public class MusicAddOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		MusicVO mu_vo = new MusicVO();
		MusicDAO mu_dao = new MusicDAO();
		
		HttpSession session = req.getSession();
		int member_seq = (int) session.getAttribute("session_seq");
		
		MultipartRequest multi = null;
		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\music";
		int fileSize = 10* 1024*1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", policy);
		
		mu_vo.setMusic_title(multi.getParameter("music_title"));
		mu_vo.setMusic_artist(multi.getParameter("music_artist"));
		mu_vo.setMember_seq(member_seq);
		
		if(mu_dao.insertMusic(mu_vo, multi)) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/music/MusicMyPage.mu");
		}
		
		return forward;
	}

}
