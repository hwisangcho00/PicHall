package com.web7.app.board.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.board.dao.BoardDAO;
import com.web7.app.board.vo.BoardVO;
import com.web7.app.member.dao.MemberDAO;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		ActionForward forward = new ActionForward();
		BoardDAO b_dao = new BoardDAO();
		MemberDAO m_dao = new MemberDAO();

		List<BoardVO> boardList = new ArrayList<>();

		// 페이징 처리
		String temp = req.getParameter("page");
		int page = temp == null ? 1 : Integer.parseInt(temp);

		// 카테고리
		String cat_temp = req.getParameter("board_category_id");
		int board_category_id = cat_temp == null ? 0 : Integer.parseInt(cat_temp);

		// 검색
		String query_temp = req.getParameter("query");
		String query = query_temp == null ? "" : query_temp;

		boolean isNotSearch = query.equals("");

		int pageSize = 10;

		int endRow = page * pageSize;

		int startRow = endRow - (pageSize - 1);

		int totalCnt = 0;

		if (board_category_id == 0) {
			if (isNotSearch) {
				totalCnt = b_dao.getBoardCnt();
			} else {
				totalCnt = b_dao.getSearchBoardCnt(query);
			}
		} else {
			totalCnt = b_dao.getSpecificBoardCnt(board_category_id);
		}

		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;

		int realEndPage = (totalCnt - 1) / pageSize + 1;

		endPage = endPage > realEndPage ? realEndPage : endPage;

		// 전체 보기 경우
		if (board_category_id == 0) {
			if (isNotSearch) {
				boardList = b_dao.getBoardList(startRow, endRow);
			} else {
				boardList = b_dao.getSearchBoardList(startRow, endRow, query);
				System.out.println(boardList.size());
			}
		} else {
			// 원하는 카테고리가 있을 경우
			boardList = b_dao.getSpecificBoardList(startRow, endRow, board_category_id);
		}
		
		//날짜 설정
		for(BoardVO board : boardList) {
			String temp_date = board.getBoard_date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date board_date = sdf.parse(temp_date);
			Calendar now = Calendar.getInstance();
			
			long now_millis = now.getTimeInMillis();
			long board_date_millis = board_date.getTime();
			
			long diff = now_millis - board_date_millis;
			long diff_hour = TimeUnit.MILLISECONDS.toHours(diff);
			
			if(diff_hour<1) {
				long diff_minute = TimeUnit.MILLISECONDS.toMinutes(diff);
				board.setBoard_date(diff_minute+"분 전");
			} else if(diff_hour>=1 && diff_hour<24) {
				board.setBoard_date(diff_hour + "시간 전");
			} else {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				board.setBoard_date(temp_date.substring(0, 11));
			}
			
			
			
		}
		
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("boardList", boardList);
		req.setAttribute("board_category_id", board_category_id);

		List<String> idList = new ArrayList<>();

		for (BoardVO board : boardList) {
			idList.add(m_dao.getId(board.getMember_seq()));
		}

		req.setAttribute("idList", idList);

		forward.setRedirect(false);
		forward.setPath("/community_page.jsp");

		return forward;
	}
}
