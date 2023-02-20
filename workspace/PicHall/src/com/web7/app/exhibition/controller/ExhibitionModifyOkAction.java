package com.web7.app.exhibition.controller;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.exhibition_category.dao.CategoryDAO;

public class ExhibitionModifyOkAction {

	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		int exhibition_seq = Integer.parseInt(req.getParameter("exhibition_seq"));
		req.setAttribute("exhibition_seq", exhibition_seq);
		
		ExhibitionVO e_vo = new ExhibitionVO();
		ExhibitionDAO e_dao = new ExhibitionDAO();
		CategoryDAO c_dao = new CategoryDAO();

		JSONObject json = new JSONObject();

		int member_seq = (int) session.getAttribute("session_seq");
		json.put("member_seq", member_seq);

		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//      SimpleDateFormat ndf = new SimpleDateFormat("yyyymmdd");
		// 연,월,일 받는다

//      Date start_date= new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("start_date"));   
//      Date end_date= new SimpleDateFormat("yyyy-mm-dd").parse(req.getParameter("end_date"));   
		Date today = new Date();

		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");

		Date start = sdf.parse(start_date);
		start.setMonth(Integer.parseInt(start_date.split("-")[1]) - 1);

		Date end = sdf.parse(end_date);
		end.setMonth(Integer.parseInt(end_date.split("-")[1]) - 1);

		json.put("exhibition_name", req.getParameter("exhibition_name"));
		json.put("exhibition_text", req.getParameter("exhibition_text"));
		json.put("start_date", start_date);
		json.put("end_date", end_date);
		json.put("report_cnt", 0);

		int category_id = c_dao.getIdbyType(req.getParameter("exhibition_category_small"));
		int parent_category_id = c_dao.getIdbyType(req.getParameter("exhibition_category_big"));

		// 카테고리

		json.put("parent_category_id", parent_category_id);
		json.put("category_id", category_id);

		int exhibition_status = 0;

		if (start.after(today)) {// 전시예정
			exhibition_status = 1;
		} else if (end.before(today)) {// 전시종료
			exhibition_status = -1;
		} else {// 전시중
			exhibition_status = 0;
		}

		json.put("exhibition_status", exhibition_status);

		String exhibitionJson = json.toJSONString();

		ActionForward forward = new ActionForward();

		req.setAttribute("exhibitionJson", exhibitionJson);
		
		forward.setRedirect(false);
		forward.setPath("/exhibition/ExhibitionPhotoMainModifyView.ex");

		return forward;
	}

}
