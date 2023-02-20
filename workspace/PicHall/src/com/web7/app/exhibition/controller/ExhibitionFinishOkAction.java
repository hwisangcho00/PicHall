package com.web7.app.exhibition.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.music_exhibition.dao.MusicExhibitionDAO;
import com.web7.app.music_exhibition.vo.MusicExhibitionVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;

public class ExhibitionFinishOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		HttpSession session = req.getSession();
		int member_seq = (int) session.getAttribute("session_seq");

		String[] musicList = req.getParameterValues("select");

		String exhibitionJson = req.getParameter("exhibitionJson");
		
		String main_photo_data = (String)req.getParameter("main_photo_data");
		System.out.println("마무리: " +main_photo_data);
		exhibitionJson = exhibitionJson.replace('\'', '\"');
		JSONParser parser = new JSONParser();

		/* exhibition 만들기 */
		ExhibitionVO e_vo = new ExhibitionVO();
		ExhibitionDAO e_dao = new ExhibitionDAO();
		JSONObject eJson = (JSONObject) parser.parse(exhibitionJson);
		int exhibition_seq = e_dao.getNextVal();
		e_vo.setExhibition_seq(exhibition_seq);
		e_vo.setMember_seq(member_seq);
		e_vo.setExhibition_name((String) eJson.get("exhibition_name"));
		e_vo.setExhibition_text((String) eJson.get("exhibition_text"));
		e_vo.setStart_date((String) eJson.get("start_date"));
		e_vo.setEnd_date((String) eJson.get("end_date"));
		e_vo.setParent_category_id(Integer.parseInt(""+eJson.get("parent_category_id")));
		e_vo.setCategory_id(Integer.parseInt(""+eJson.get("category_id")));
		e_vo.setReport_cnt(0);
		e_vo.setExhibition_status(Integer.parseInt(""+eJson.get("exhibition_status")));
		e_vo.setLike_cnt(0);
		e_vo.setMain_photo_data(main_photo_data);
		e_dao.insertExhibition(e_vo);

		/* photo_exhibition에 넣기 */
		PhotoExhibitionDAO pe_dao = new PhotoExhibitionDAO();
		String photoListJson = (String) req.getParameter("photoListJson");
		photoListJson = photoListJson.replace('\'', '\"');

		JSONArray pJson = (JSONArray) parser.parse(photoListJson);

		for (int i = 0; i < pJson.size(); i++) {
			PhotoExhibitionVO pe_vo = new PhotoExhibitionVO();
			pe_vo.setExhibition_seq(exhibition_seq);
			pe_vo.setPhoto_seq(Integer.parseInt((String) pJson.get(i)));
			pe_dao.insertPhotoExhibition(pe_vo);
		}

		/* music_exhibition에 넣기 */
		MusicExhibitionDAO me_dao = new MusicExhibitionDAO();
		for (String music_seq : musicList) {
			MusicExhibitionVO me_vo = new MusicExhibitionVO();
			me_vo.setExhibition_seq(exhibition_seq);
			me_vo.setMusic_seq(Integer.parseInt(music_seq));
			me_dao.insertMusicExhibition(me_vo);
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");

		out.println("<script>");
		out.println("alert('전시회 만들기 성공!')");
		out.println("location.href='/PicHall/member/MemberMyPage.me'");
		out.println("</script>");
		out.close();
		
		
		return null;
	}

}
