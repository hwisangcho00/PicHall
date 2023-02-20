package com.web7.app.photo.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;

public class PhotoUploadOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;
		
		PhotoVO p_vo = new PhotoVO();
		PhotoDAO p_dao = new PhotoDAO();
		
		HttpSession session = req.getSession();
		int member_seq = (int) session.getAttribute("session_seq");
		//세션에서 member_seq받아옴
		
		MultipartRequest multi = null;
		//String saveFolder = "C:\\Users\\lg\\Documents\\코딩★\\코리아 it 아카데미\\jsp\\workspace\\PicHall\\WebContent\\app\\photo\\upload";
		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\photo\\upload";
		//이쪽 경로..
		int fileSize = 10* 1024*1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();

		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", policy);
		//photo_seq는?
		
		//p_vo.setPhoto_seq(0);
		p_vo.setMember_seq(member_seq);
		p_vo.setPhoto_name(multi.getParameter("photo_name"));
		p_vo.setPhoto_text(multi.getParameter("photo_text"));
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		
		if(p_dao.insertPhoto(p_vo, multi)) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/photo/PhotoView.ph?member_seq="+member_seq);
		}
		
		return forward;
	}

}
