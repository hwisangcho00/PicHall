package com.web7.app.subscribe.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.subscribe.dao.SubscribeDAO;
import com.web7.app.subscribe.vo.SubscribeVO;

public class SubscribeOkAction implements Action {
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
		}else {
			PrintWriter out = resp.getWriter();
			resp.setContentType("text/html;charset=utf-8");
			out.println("<script>");
			out.println("alert('로그인해주세요.')");
			out.println("</script>");
			out.close();
			//다시 원래페이지로 돌아가게 수정해주기
		}
		int member_seq = Integer.parseInt(req.getParameter("member_seq"));
		int following_id= member_seq;
		int followed_id= session_seq;
		
		s_vo.setFollowed_id(followed_id);
		s_vo.setFollowing_id(following_id);
		
		//구독에 실패했을때만 경고창을, 성공하면 별다른 효과 없음
		//구독에 실패한 이유-자신을 팔로우할때, 로그인이 안됐을때, 이미 팔로우가 되어있을때
		//여유가 된다면 구독중일 때와 구독중이지 않을 때를 구분해서 아이콘이 다르게 나오던가 하면 좋을듯 
		if(s_dao.subscribe(s_vo)) {//성공
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/subscribe/UserView.su?member_seq="+member_seq);

			return forward;
		}

		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		out.println("<script>");
		out.println("alert('구독 실패. 다시 시도해주세요')");
		out.println("</script>");
		out.close();
		
		return null;
	}

}












