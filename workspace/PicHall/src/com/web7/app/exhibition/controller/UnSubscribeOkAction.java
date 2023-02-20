package com.web7.app.exhibition.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.subscribe.dao.SubscribeDAO;
import com.web7.app.subscribe.vo.SubscribeVO;

public class UnSubscribeOkAction implements Action {
	//구독하기
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		ActionForward forward = null;		
		
		SubscribeDAO s_dao=new SubscribeDAO();
		SubscribeVO s_vo=new SubscribeVO();
		
		HttpSession session = req.getSession();
		
		int session_seq=0;
		
		if(session.getAttribute("session_seq")!=null) {
			session_seq = (int)session.getAttribute("session_seq");
		}else {//로그인이 안된 경우 로그인페이지로
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/login.jsp");

			return forward;
		}
		int member_seq = Integer.parseInt(req.getParameter("member_seq"));
		int following_id= member_seq;
		int followed_id= session_seq;
		
		s_vo.setFollowed_id(followed_id);
		s_vo.setFollowing_id(following_id);
		
		//일치하는 아이디가 있는지 찾기
		List<SubscribeVO> followerList= s_dao.getFollowerList(member_seq);
		boolean check=true;
		
		for(SubscribeVO follower:followerList) {
			if(follower.getFollowed_id() == session_seq) {//팔로워와 member_seq가 일치하는것이 있음(이미 팔로우중임)
				check=false;
			}
		}
		if(check==false&&s_dao.unsubscribe(s_vo)) {//일치하는것이 있음(구독해제 가능)
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/exhibition/UserView.ex?member_seq="+req.getParameter("member_seq"));

			return forward;
		}else if(check==true) {//일치하는것이 없음(구독해제 불가능)
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('구독중이 아닙니다.')");
			out.println("</script>");
			out.close();
			
			return null;
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		out.println("<script>");
		out.println("alert('구독해제 실패. 다시 시도해주세요')");
		out.println("</script>");
		out.close();
		
		return null;
	}

}












