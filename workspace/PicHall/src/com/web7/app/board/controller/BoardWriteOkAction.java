package com.web7.app.board.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.attach.dao.AttachDAO;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.board.vo.BoardVO;
import com.web7.app.member.dao.MemberDAO;

public class BoardWriteOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardVO b_vo = new BoardVO();
		BoardDAO b_dao = new BoardDAO();

		AttachDAO a_dao = new AttachDAO();

		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\board\\upload";

		int fileSize = 5 * 1024 * 1024;

		MultipartRequest multi = null;

		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();

		HttpSession session = req.getSession();

		int member_seq = (int) session.getAttribute("session_seq");

		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", policy);

		b_vo.setBoard_category_id(Integer.parseInt(multi.getParameter("board_category_id")));
		// SYSDATE로 저장해줌
		b_vo.setBoard_date(null);
		b_vo.setBoard_hits(0);
		b_vo.setBoard_like(0);
		// NEXTVAL로 저장
		b_vo.setBoard_seq(0);
		b_vo.setBoard_text(multi.getParameter("board_text"));
		b_vo.setBoard_title(multi.getParameter("board_title"));
		b_vo.setMember_seq(member_seq);

		if (b_dao.insertBoard(b_vo)) {
			if (a_dao.insertAttach(b_dao.getBoardSeq(), multi)) {
				
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				
				out.println("<script>");

				out.println("alert('게시글 작성 완료');");

				out.println("location.replace('BoardList.bo')");

				out.println("</script>");

				out.close();	
			
				return null;
			}
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");

		out.println("<script>");
		out.println("alert('게시글 작성 실패. 다시 시도해주세요')");
		out.println("</script>");
		out.close();

		return null;
	}

}
