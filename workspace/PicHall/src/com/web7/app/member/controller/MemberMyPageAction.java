package com.web7.app.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public class MemberMyPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		HttpSession session = req.getSession();
		int member_seq = (int)session.getAttribute("session_seq");
		
		SubscribeDAO s_dao = new SubscribeDAO();
		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();
		ExhibitionDAO e_dao=new ExhibitionDAO();
		PhotoDAO p_dao = new PhotoDAO();
		PhotoVO p_vo=new PhotoVO();
		PhotoExhibitionDAO pe_dao=new PhotoExhibitionDAO();
		PhotoExhibitionVO pe_vo=new PhotoExhibitionVO();

		List<PhotoVO> photoBeanList =p_dao.getPhotoList(member_seq);
		req.setAttribute("photoBeanList", photoBeanList);

		int totalCntbySeq=e_dao.getExhibitionCntbySeq(member_seq);
		
		List<ExhibitionVO> exhibitionList=e_dao.getExhibitionListbySeq(member_seq);
		//전시회 메인사진 불러오기
		List<PhotoVO> photo_exhibitionBeanList=new ArrayList<>();
		for(ExhibitionVO exhibition : exhibitionList) {
			List<PhotoExhibitionVO> ExhibitionPhotoBeanList=pe_dao.getPhotobySeq(exhibition.getExhibition_seq());
			pe_vo=ExhibitionPhotoBeanList.get(0);
			int photo_seq=pe_vo.getPhoto_seq();
			p_vo=p_dao.getPhoto(photo_seq);

			photo_exhibitionBeanList.add(p_vo);
		}
		req.setAttribute("photoExhibitionBeanList", photo_exhibitionBeanList);
		//팔로우,팔로잉 추가
		List<SubscribeVO> followerList = s_dao.getFollowerList(member_seq);
		List<SubscribeVO> followingList = s_dao.getFollowingList(member_seq);
		
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
		//여기까지
		m_vo = m_dao.getDetail(member_seq);
		
		req.setAttribute("memberBean", m_vo);
		req.setAttribute("totalCntbySeq", totalCntbySeq);
		req.setAttribute("exhibitionList", exhibitionList);
		
		forward.setRedirect(false);
		forward.setPath("/mypage.jsp");
		
		return forward;
	}

}
