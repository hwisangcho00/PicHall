package com.web7.app.photo.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.attach.dao.AttachDAO;
import com.web7.app.attach.vo.AttachVO;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.comment.dao.CommentDAO;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.music.vo.MusicVO;
import com.web7.app.music_exhibition.dao.MusicExhibitionDAO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;

public class PhotoDeleteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		int photo_seq = Integer.parseInt(req.getParameter("photo_seq"));
		
		PhotoDAO p_dao = new PhotoDAO();
		PhotoVO p_vo = new PhotoVO();
		PhotoExhibitionDAO pe_dao = new PhotoExhibitionDAO(); //아직 안만든 DAO
		
		p_vo = p_dao.getPhoto(photo_seq);
		
		if(p_vo == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('삭제되었거나 존재하지 않는 사진입니다')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\photo\\upload";//왜 경고가 뜨지?
		//String saveFolder = "C:\\web_ajh\\jsp\\workspace\\PicHall\\WebContent\\app\\photo\\upload";
		
			File f = new File(saveFolder, p_vo.getPhoto_data());
			
			if(f.exists()) {
				f.delete();
			}
		
		//전시회에 사용되었던 것 먼저 삭제
		pe_dao.delete(photo_seq);
				//그냥 tbl_music에서 삭제
		p_dao.deletePhoto(photo_seq);
		
		
		
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/photo/PhotoView.ph");
		
		return forward;
}
	
}