package com.web7.app.exhibition.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;

public class All_exhibitionListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		ExhibitionDAO e_dao=new ExhibitionDAO();
		MemberDAO m_dao=new MemberDAO();
		PhotoExhibitionDAO pe_dao=new PhotoExhibitionDAO();
		PhotoExhibitionVO pe_vo=new PhotoExhibitionVO();
		PhotoDAO p_dao=new PhotoDAO();
		PhotoVO p_vo=new PhotoVO();
		
		//페이징 처리
		String temp = req.getParameter("page");
		
		//요청한 페이지가 없다면 default로 1페이지를 응답해주고,
		//요청한 페이지가 있다면 해당 페이지로 응답해준다.
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		//카테고리
		String cat_temp=req.getParameter("exhibition_category_id");
		int exhibition_category_id = cat_temp == null ? 0 : Integer.parseInt(cat_temp);
		
		//한 페이지 당 12개의 게시글이 보이도록 설정
		int pageSize = 12;
		
		//한 페이지에서 가장 마지막 행 번호
		int endRow = page * pageSize;
		
		//한 페이지에서 가장 첫번째 행 번호
		int startRow = endRow - (pageSize - 1);
		
		//전체 또는 카테고리별 전시회 갯수
//		int totalCnt = e_dao.getExhibitionCnt();
		int totalCnt=0;
		
		List<ExhibitionVO> exhibitionList = new ArrayList<>();
		
		if(exhibition_category_id==0) {//전체보기
			exhibitionList = e_dao.getExhibitionList(startRow, endRow);
			totalCnt=e_dao.getExhibitionCnt();
		}else if(exhibition_category_id<10) {//부모 카테고리 선택
			exhibitionList=e_dao.getParentBoardList(startRow, endRow, exhibition_category_id);
			totalCnt=e_dao.getExhibitionCntbyParentCategory(exhibition_category_id);
		}else {//자식  카테고리 선택
			exhibitionList=e_dao.getChildBoardList(startRow, endRow, exhibition_category_id);
			totalCnt=e_dao.getExhibitionCntbyCategory(exhibition_category_id);
		}
		
		//10의 배수로
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		
		int realEndPage = (totalCnt - 1) / pageSize + 1;
		
		//실제 마지막 페이지와 연산으로 구한 마지막 페이지를 비교하여 일치하도록 해준다.
		endPage = endPage > realEndPage ? realEndPage : endPage;

		
		
		req.setAttribute("category_id", exhibition_category_id);
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("exhibitionRecentList", e_dao.getExhibitionList(1,5));
		req.setAttribute("exhibitionList", exhibitionList);
		
		List<String> idList=new ArrayList<>();
		List<PhotoVO> photoBeanList=new ArrayList<>();
		for(ExhibitionVO exhibition : exhibitionList) {
			idList.add(m_dao.getId(exhibition.getMember_seq()));

			List<PhotoExhibitionVO> ExhibitionPhotoBeanList=pe_dao.getPhotobySeq(exhibition.getExhibition_seq());
			pe_vo=ExhibitionPhotoBeanList.get(0);
			int photo_seq=pe_vo.getPhoto_seq();
			p_vo=p_dao.getPhoto(photo_seq);

			photoBeanList.add(p_vo);
		}
		
		req.setAttribute("idList", idList);
		req.setAttribute("photoBeanList", photoBeanList);
		
		forward.setRedirect(false);
		forward.setPath("/all_exhibition.jsp");
		
		return forward;
	}

}
