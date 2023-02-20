package com.web7.app.exhibition.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.exhibition.dao.ExhibitionDAO;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;
import com.web7.app.photo.dao.PhotoDAO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.photo_exhibition.dao.PhotoExhibitionDAO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;
import com.web7.app.subscribe.dao.SubscribeDAO;
import com.web7.app.subscribe.vo.SubscribeVO;

public class UserPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		ActionForward forward=new ActionForward();
		
		SubscribeDAO s_dao = new SubscribeDAO();
//		SubscribeVO s_vo = new SubscribeVO();
		MemberVO m_vo=new MemberVO();
		MemberDAO m_dao=new MemberDAO();
		ExhibitionDAO e_dao=new ExhibitionDAO();
		PhotoExhibitionDAO pe_dao=new PhotoExhibitionDAO();
		PhotoExhibitionVO pe_vo=new PhotoExhibitionVO();
		PhotoDAO p_dao=new PhotoDAO();
		PhotoVO p_vo=new PhotoVO();
		
		//유저페이지 주인(멤버)의 id정보
		int member_seq=Integer.parseInt(req.getParameter("member_seq"));
		
		m_vo=m_dao.getDetail(member_seq);
		
		if(m_vo == null) {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('존재하지 않는 회원입니다')");
			out.println("history.go(-1)");
			out.println("</script>");
		}
		
		List<SubscribeVO> followerList = s_dao.getFollowerList(member_seq);
		List<SubscribeVO> followingList = s_dao.getFollowingList(member_seq);
		
//		follower.getFollowed_id() : member_seq
		List<String> followerIdList = new ArrayList<>();
		List<String> followerSeqList = new ArrayList<>();		
		for(SubscribeVO follower: followerList) {
			followerIdList.add(m_dao.getNicknamebySeq(follower.getFollowed_id()));
			followerSeqList.add(Integer.toString(follower.getFollowed_id()));
		}
		List<String> followingIdList = new ArrayList<>();
		List<String> followingSeqList=new ArrayList<>();
		for(SubscribeVO following: followingList) {
			followingIdList.add(m_dao.getNicknamebySeq(following.getFollowing_id()));
			followingSeqList.add(Integer.toString(following.getFollowing_id()));
		}
		
		//유저의 전시회 불러오기
		String temp = req.getParameter("page");
		
		//요청한 페이지가 없다면 default로 1페이지를 응답해주고,
		//요청한 페이지가 있다면 해당 페이지로 응답해준다.
		int page = temp == null ? 1 : Integer.parseInt(temp);
		
		//한 페이지 당 12개의 게시글이 보이도록 설정
		int pageSize = 12;
		
		//한 페이지에서 가장 마지막 행 번호
		int endRow = page * pageSize;
		
		//한 페이지에서 가장 첫번째 행 번호
		int startRow = endRow - (pageSize - 1);
		
		//유저의 전체 전시회 개수
		int totalCnt=e_dao.getExhibitionCntbySeq(member_seq);
		
		List<ExhibitionVO> exhibitionList = new ArrayList<>();
		exhibitionList = e_dao.getExhibitionPageListbySeq(startRow, endRow, member_seq);
		
		//10의 배수로
		int startPage = ((page - 1) / pageSize) * pageSize + 1;
		int endPage = startPage + 9;
		
		int realEndPage = (totalCnt - 1) / pageSize + 1;
		
		//실제 마지막 페이지와 연산으로 구한 마지막 페이지를 비교하여 일치하도록 해준다.
		endPage = endPage > realEndPage ? realEndPage : endPage;
		
		req.setAttribute("totalCnt", totalCnt);
		req.setAttribute("realEndPage", realEndPage);
		req.setAttribute("nowPage", page);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("exhibitionList", exhibitionList);
		
/*		List<PhotoVO> photoBeanList=new ArrayList<>();
		for(ExhibitionVO exhibition : exhibitionList) {
			List<PhotoExhibitionVO> ExhibitionPhotoBeanList=pe_dao.getPhotobySeq(exhibition.getExhibition_seq());
			pe_vo=ExhibitionPhotoBeanList.get(0);
			int photo_seq=pe_vo.getPhoto_seq();
			p_vo=p_dao.getPhoto(photo_seq);

			photoBeanList.add(p_vo);
		}
		req.setAttribute("photoBeanList", photoBeanList);*/
		
		if(m_vo!=null) {
			req.setAttribute("memberBean", m_vo);
			req.setAttribute("memberNickname", m_dao.getNicknamebySeq(member_seq));
			req.setAttribute("memberText", m_dao.getTextbySeq(member_seq));
			
//			req.setAttribute("subscribeBean", s_vo);
			
			if(followerList!=null) {
				req.setAttribute("followerBeanList", followerList);
				req.setAttribute("followerIdList", followerIdList);
				req.setAttribute("followerSeqList", followerSeqList);
			}
			if(followingList!=null) {
				req.setAttribute("followingBeanList", followingList);				
				req.setAttribute("followingIdList", followingIdList);				
				req.setAttribute("followingSeqList", followingSeqList);				
			}
			forward.setRedirect(false);
			forward.setPath("/userpage.jsp");
			return forward;
		}
		
		return null;
	}

}
