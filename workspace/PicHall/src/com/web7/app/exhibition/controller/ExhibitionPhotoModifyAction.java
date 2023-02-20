package com.web7.app.exhibition.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;

public class ExhibitionPhotoModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int exhibition_seq = Integer.parseInt(req.getParameter("exhibition_seq"));
		
		req.setAttribute("exhibition_seq", exhibition_seq);
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		String exhibitionJson = (String) req.getAttribute("exhibitionJson");
		PhotoDAO p_dao = new PhotoDAO();
		PhotoExhibitionDAO pe_dao = new PhotoExhibitionDAO();
		String main_photo_data = (String) req.getAttribute("main_photo_data");
		
		List<PhotoVO> photoBeanList = p_dao.getPhotoList(member_seq);
		List<PhotoExhibitionVO> photoExhibitionList = pe_dao.getPhotobySeq(exhibition_seq);
		
		List<Integer> photoSeqList = new ArrayList<Integer>();
		
		for(PhotoExhibitionVO pe : photoExhibitionList) {
			photoSeqList.add(pe.getPhoto_seq());
		}
		
		req.setAttribute("photoSeqList", photoSeqList);
		req.setAttribute("photoBeanList", photoBeanList);
		
		req.setAttribute("exhibitionJson", exhibitionJson);
		req.setAttribute("main_photo_data", main_photo_data);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/exhibition_modify_photo.jsp");
		
		return forward;
	}

}
