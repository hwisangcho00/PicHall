package com.web7.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.web7.action.Action;
import com.web7.action.ActionForward;

public class MemberLogOutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ActionForward forward = new ActionForward();

		HttpSession session = req.getSession();

		// 세션 삭제
		session.invalidate();

		// BoardList.bo로 이동
		forward.setPath(req.getContextPath() + "/index.jsp");
		forward.setRedirect(true);

		return forward;
	}

}
