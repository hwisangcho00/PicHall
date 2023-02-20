package com.web7.app.exhibition.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;

public class ExhibitionPhotoMainOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		String exhibitionJson = req.getParameter("exhibitionJson");
		req.setAttribute("exhibitionJson", exhibitionJson);
		
		PhotoDAO p_dao=new PhotoDAO();

		String[] photoList = req.getParameterValues("select");
		int main_photo_seq = 0;
		
		if(photoList.length == 1) {
			main_photo_seq = Integer.parseInt(photoList[0]);
		}
		
		String main_photo_data=p_dao.getPhotoData(main_photo_seq);
		
		System.out.println("PhotoMainOkAction: " +main_photo_data);
		
		req.setAttribute("main_photo_data", main_photo_data);
		
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/exhibition/ExhibitionPhoto.ex");
		
		return forward;
		//여기서 수정....
	}

}
