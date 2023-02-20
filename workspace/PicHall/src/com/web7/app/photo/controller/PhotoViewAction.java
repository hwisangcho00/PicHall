package com.web7.app.photo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;

public class PhotoViewAction  implements Action {
	//사진다운로드 페이지
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

		PhotoDAO p_dao = new PhotoDAO();

		List<PhotoVO> photoBeanList =p_dao.getPhotoList(member_seq);
		//photoBeanList -> jsp와 연결
		req.setAttribute("photoBeanList", photoBeanList);

		forward.setRedirect(false);
//		forward.setPath("/picture_manage/photo_manage.jsp"); //기존경로
		forward.setPath("/picture_manage/photo_manage_re.jsp");
		
		
		return forward;
	}

}
