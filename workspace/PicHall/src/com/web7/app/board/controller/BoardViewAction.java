package com.web7.app.board.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.attach.dao.AttachDAO;
import com.web7.app.attach.vo.AttachVO;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.board.vo.BoardVO;
import com.web7.app.comment.dao.CommentDAO;
import com.web7.app.comment.vo.CommentVO;
import com.web7.app.member.dao.MemberDAO;

public class BoardViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();

		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		BoardDAO b_dao = new BoardDAO();
		MemberDAO m_dao = new MemberDAO();
		AttachDAO a_dao = new AttachDAO();
		CommentDAO c_dao = new CommentDAO();

		int member_seq = 0;
		
		HttpSession session = req.getSession();
		if(session.getAttribute("session_seq")!=null) {
			member_seq = (int)session.getAttribute("session_seq");
		}
		
		/* 조회수 관련 */
		boolean isNew = true;

		Cookie[] cookies = req.getCookies();
		Cookie boardCookie = null;

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(member_seq+"boardCookie")) {
				boardCookie = cookie;
			}
		}

		if (boardCookie == null) {
			// 쿠키가 없으면 새로 만들어 준다
			Cookie cookie = new Cookie(member_seq+"boardCookie", req.getParameter("board_seq"));
			resp.addCookie(cookie);
			// 그리고 조회수 1 올려주기
			b_dao.updateBoardHits(board_seq);
		} else {
			// 쿠키가 있으면 게시글을 처음 조회한것인지 확인해준다

			StringTokenizer history = new StringTokenizer(boardCookie.getValue(), ":", false);
			while (history.hasMoreTokens()) {
				// 이미 기록에 이 게시물 번호가 있다면 isNew가 false가 된다
				if (history.nextToken().equals("" + board_seq)) {
					isNew = false;
					break;
				}
			}
			// 새거라면
			if (isNew) {
				// board_seq를 추가해준다
				boardCookie.setValue(boardCookie.getValue() + ":" + board_seq);
				// 그리고 조회수 증가
				b_dao.updateBoardHits(board_seq);
			}
			// 변화된 쿠키 추가
			resp.addCookie(boardCookie);
		}

		BoardVO b_vo = b_dao.getBoard(board_seq);
		
		if (b_vo == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			
			out.println("<script>");
			out.println("alert('삭제된 게시글입니다');");
			out.println("history.go(-1)");
			out.println("</script>");
			out.close();
			return null;
		}

		List<AttachVO> attachList = a_dao.getDetail(board_seq);
		List<CommentVO> commentList = c_dao.getCommentList(board_seq);
		int comment_cnt = c_dao.getCnt(board_seq);

		String author_id = m_dao.getId(b_vo.getMember_seq());

		List<String> idList = new ArrayList<>();

		for (CommentVO comment : commentList) {
			idList.add(m_dao.getId(comment.getMember_seq()));
		}

		if (b_vo != null) {
			req.setAttribute("boardBean", b_vo);
			req.setAttribute("author_id", author_id);

			if (attachList != null) {
				req.setAttribute("attachBeanList", attachList);
			}

			req.setAttribute("comment_cnt", comment_cnt);
			if (comment_cnt != 0) {
				req.setAttribute("commentBeanList", commentList);
				req.setAttribute("idList", idList);
			}

			forward.setRedirect(false);
			forward.setPath("/community_read_page.jsp");
			return forward;
		}

		return null;
	}

}
