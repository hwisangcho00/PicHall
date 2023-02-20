package com.web7.app.exhibition.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.report.dao.ReportDAO;
import com.web7.app.report.vo.ReportVO;

public class SendReportAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ReportDAO r_dao=new ReportDAO();
		ReportVO r_vo=new ReportVO();
		
		int exhibition_seq=Integer.parseInt(req.getParameter("exhibition_seq"));
		//필요한것: 전시회번호, 제목, 내용		
		r_vo.setExhibition_seq(exhibition_seq);
		r_vo.setReport_seq(0);
		r_vo.setReport_text(req.getParameter("title"));
		r_vo.setReport_title(req.getParameter("message"));
		
		if(!r_dao.report(r_vo)) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('잠시 후 다시 시도해주세요.')");
			out.println("</script>");
			out.close();
			
			return null;
		}
		ActionForward forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath(req.getContextPath()+"/exhibition/ExhibitionMultiverseView.ex?exhibition_seq="+exhibition_seq);

		return forward;
	}

}
