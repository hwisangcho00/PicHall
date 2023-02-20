package com.web7.app.music.controller;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;

public class MusicMyPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();

		int member_seq = 0;

		HttpSession session = req.getSession();
		if (session.getAttribute("session_seq") != null) {
			member_seq = (int) session.getAttribute("session_seq");
		}

		MusicDAO mu_dao = new MusicDAO();

		List<MusicVO> musicBeanList = mu_dao.getMusicList(member_seq);

		req.setAttribute("musicBeanList", musicBeanList);

		forward.setRedirect(false);
		forward.setPath("/my_music_page.jsp");

		return forward;
	}

}
