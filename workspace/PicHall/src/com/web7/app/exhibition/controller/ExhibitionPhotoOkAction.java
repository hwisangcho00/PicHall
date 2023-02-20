package com.web7.app.exhibition.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;

public class ExhibitionPhotoOkAction implements Action {

		@Override
		public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			
			String exhibitionJson = (String)req.getParameter("exhibitionJson");
			req.setAttribute("exhibitionJson", exhibitionJson);
			
			
			String main_photo_data = (String)req.getParameter("main_photo_data");
			System.out.println("PhotoOkAction: " +main_photo_data);
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
			forward.setPath("/exhibition/ExhibitionMusic.ex");
			
			return forward;
		}

}
