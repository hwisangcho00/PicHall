package com.web7.app.exhibition.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;

public class ExhibitionMainListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ExhibitionVO e_vo=new ExhibitionVO();
		ExhibitionDAO e_dao = new ExhibitionDAO();
		PhotoExhibitionDAO pe_dao=new PhotoExhibitionDAO();
		PhotoExhibitionVO pe_vo=new PhotoExhibitionVO();
		PhotoDAO p_dao=new PhotoDAO();
		PhotoVO p_vo=new PhotoVO();

		PrintWriter out= resp.getWriter();
		
		JSONArray exhibitions=new JSONArray();
		List<ExhibitionVO> exhibitionList = e_dao.getExhibitionListbyLike(1, 7);
		
		
		for(ExhibitionVO e_list : exhibitionList) {
			JSONObject exhibition = new JSONObject();
			exhibition.put("exhibition_start_date", e_list.getStart_date());
			exhibition.put("exhibition_name", e_list.getExhibition_name());
			exhibition.put("exhibition_text", e_list.getExhibition_text());
			exhibition.put("exhibition_seq", e_list.getExhibition_seq());
			exhibition.put("exhibition_photo",e_list.getMain_photo_data());
			//대표사진 불러오기
		
			exhibitions.add(exhibition);
			
		}
		//해야될 것: 전시회 중 main_photo_data();
		out.println(exhibitions.toJSONString());
		out.close();
		return null;
	}

}
