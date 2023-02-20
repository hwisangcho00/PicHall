package com.web7.app.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.comment.dao.CommentDAO;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.photo.dao.PhotoDAO;

public class MemberQuitOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		//댓글
		CommentDAO c_dao = new CommentDAO();
	
		
        //Photo
		PhotoDAO p_dao = new PhotoDAO();

		//Music
		
		//PhotoExhibition
		
		//MusicExhibition
		
		//Exhibition
		
		//게시글
		//파일
		//subscribe
		//좋아요
		
		
		return null;
	}

}












