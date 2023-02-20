package com.web7.app.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.ActionForward;

public class MemberFrontController extends HttpServlet {

	/**
	 * JVM의 메모리에서만 머물러 있던 객체를 시스템이 종료되거나 네트워크로 통신을 할 때에도 그대로 사용할 수 있도록 영구화 목적으로 직렬화를
	 * 사용한다. 직렬화된 객체는 byte형태로 변환되어 있으며, 다시 사용하고 싶을 때에는 역직렬화를 통해서 객체로 변환된다. 이 때
	 * SUID(serialVersionUID)라는 값을 고정시켜 구분점으로 사용해서 사용자가 원하는 객체가 맞는 지 판단하게 된다. 자주
	 * 변경되는 클래스 객체에는 사용하지 않는 것이 좋다.
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}

	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String contextPath = req.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;

		if (command.equals("/member/MemberCheckIdOk.me")) {
			// 아이디 중복 확인
			try {
				forward = new MemberCheckIdOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberCheckEmailOk.me")) {
			// 이메일 중복 확인
			try {
				forward = new MemberCheckEmailOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberFindIdOk.me")) {
			// 이메일 중복 확인
			try {
				forward = new MemberFindIdOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberFindPwOk.me")) {
			// 이메일 중복 확인
			try {
				forward = new MemberFindPwOk().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberJoin.me")) {
			// 회원가입 페이지 가기
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/sign_in.jsp");

		} else if (command.equals("/member/MemberJoinOk.me")) {
			// 회원 가입 확인
			try {
				forward = new MemberJoinOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberJoinSuccess.me")) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath() + "/sign_in_ok.jsp?email=" + req.getParameter("email"));

		} else if (command.equals("/member/MemberJoinSuccessOk.me")) {
			try {
				forward = new MemberJoinSuccessOkAction().execute(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberLogin.me")) {
			// 로그인 페이지 가기
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/login.jsp");

		} else if (command.equals("/member/MemberLoginOk.me")) {
			// 로그인 성공 판단
			try {
				forward = new MemberLoginOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberLogOut.me")) {
			// 로그아웃하기
			try {
				forward = new MemberLogOutAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/member/MemberEditProfile.me")) {
			try {
				forward = new MemberEditProfileAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberEditProfileOk.me")) {
			try {
				forward = new MemberEditProfileOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/member/MemberEditProfilePicOk.me")) {
			try {
				forward = new MemberEditProfilePicOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/member/MemberMyPage.me")) {
			try {
				forward = new MemberMyPageAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/member/MemberFindIdPw.me")) {
			// 로그인 페이지 가기
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/find_id_pw.jsp");

		} else if (command.equals("/member/MemberQuitOk.me")) {
			try {
				forward = new MemberQuitOkAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/member/MemberQuit.me")) {
			try {
				forward = new MemberQuitAction().execute(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/app/error/404.jsp");
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher(forward.getPath());
				dispatcher.forward(req, resp);
			}
		}
	}
}
