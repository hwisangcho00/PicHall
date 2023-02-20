package com.web7.app.subscribe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;
import com.web7.app.subscribe.dao.SubscribeDAO;
import com.web7.app.subscribe.vo.SubscribeVO;

public class UserPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		ActionForward forward=new ActionForward();
		
		SubscribeDAO s_dao = new SubscribeDAO();
		SubscribeVO s_vo = new SubscribeVO();
		MemberVO m_vo=new MemberVO();
		MemberDAO m_dao=new MemberDAO();
		
		//유저페이지 주인(멤버)의 id정보
		int member_seq=Integer.parseInt(req.getParameter("member_seq"));
		
		m_vo=m_dao.getDetail(member_seq);
		
		List<SubscribeVO> followerList = s_dao.getFollowerList(member_seq);
		List<SubscribeVO> followingList = s_dao.getFollowingList(member_seq);
		
		if(m_vo!=null) {
			req.setAttribute("memberBean", m_vo);
			req.setAttribute("memberNickname", m_dao.getNicknamebySeq(member_seq));
			req.setAttribute("memberText", m_dao.getTextbySeq(member_seq));
			
			req.setAttribute("subscribeBean", s_vo);
			
			if(followerList!=null) {
				req.setAttribute("followerList", followerList);
			}
			if(followingList!=null) {
				req.setAttribute("followingList", followingList);				
			}
			forward.setRedirect(false);
			forward.setPath("/userpage.jsp");
			return forward;
		}
		
		return null;
	}

}
