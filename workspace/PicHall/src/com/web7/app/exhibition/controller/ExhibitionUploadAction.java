package com.web7.app.exhibition.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.music.dao.MusicDAO;
import com.web7.app.photo.dao.PhotoDAO;

public class ExhibitionUploadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		HttpSession session=req.getSession();
		
		int member_seq=(int)session.getAttribute("session_seq");
		
		PhotoDAO p_dao = new PhotoDAO();
		MusicDAO m_dao = new MusicDAO();
		
		if(p_dao.getPhotoCnt(member_seq) == 0 || m_dao.getMusicCnt(member_seq) == 0) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('전시회를 만들기 위해서는 반드시 하나 이상의 음악과 사진이 업로드되어 있어야합니다')");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			return null;
		}
		
		req.setAttribute("member_seq", member_seq);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date=simpleDateFormat.format(new Date());
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/exhibition_make.jsp");
		return forward;			
		
	}
}
