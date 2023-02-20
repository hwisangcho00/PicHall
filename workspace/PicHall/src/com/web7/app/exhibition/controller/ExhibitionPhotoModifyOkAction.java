package com.web7.app.exhibition.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.web7.action.Action;
import com.web7.action.ActionForward;

public class ExhibitionPhotoModifyOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int exhibition_seq = Integer.parseInt(req.getParameter("exhibition_seq"));
		req.setAttribute("exhibition_seq", exhibition_seq);
		
		String exhibitionJson = (String)req.getParameter("exhibitionJson");
		req.setAttribute("exhibitionJson", exhibitionJson);
		
		String main_photo_data = (String) req.getParameter("main_photo_data");
		req.setAttribute("main_photo_data", main_photo_data);
		
		String[] photoList = req.getParameterValues("select");

		JSONArray photoListJArray = new JSONArray();
		
		for(String photo_seq : photoList) {
			photoListJArray.add(photo_seq);
		}
		
		String photoListJson = photoListJArray.toJSONString();
		
		photoListJson = photoListJson.replace('\"', '\'');
		req.setAttribute("photoListJson", photoListJson);
		
		ActionForward forward=new ActionForward();
		
		
		forward.setRedirect(false);
		forward.setPath("/exhibition/ExhibitionMusicModify.ex");
		
		return forward;
	}

}
