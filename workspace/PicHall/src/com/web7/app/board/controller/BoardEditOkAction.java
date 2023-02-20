package com.web7.app.board.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.attach.dao.AttachDAO;
import com.web7.app.attach.vo.AttachVO;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.board.vo.BoardVO;
import com.web7.app.member.dao.MemberDAO;

public class BoardEditOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		BoardVO b_vo = new BoardVO();
		BoardDAO b_dao = new BoardDAO();
		AttachDAO a_dao = new AttachDAO();
		
		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\board\\upload";

		int fileSize = 5 * 1024 * 1024;

		MultipartRequest multi = null;

		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();

		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", policy);

		int board_seq = Integer.parseInt(multi.getParameter("board_seq"));

		b_vo = b_dao.getBoard(board_seq);
		
		for(AttachVO attach : a_dao.getDetail(board_seq)) {
			File f = new File(saveFolder, attach.getAttach_name());
			
			if(f.exists()) {
				f.delete();
			}
		}

		a_dao.deleteAttach(board_seq);
		
		b_vo.setBoard_category_id(Integer.parseInt(multi.getParameter("board_category_id")));
		b_vo.setBoard_title(multi.getParameter("board_title"));
		b_vo.setBoard_text(multi.getParameter("board_text"));

		if (b_dao.modifyBoard(b_vo)) {
			
			if (a_dao.insertAttach(board_seq, multi)) {
				ActionForward forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath() + "/board/BoardView.bo?board_seq="+board_seq);
				return forward;
			}
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");

		out.println("<script>");
		out.println("alert('게시글 수정 실패. 다시 시도해주세요')");
		out.println("</script>");
		out.close();

		return null;
	}

}
