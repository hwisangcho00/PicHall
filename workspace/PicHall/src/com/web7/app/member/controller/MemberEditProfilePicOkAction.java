package com.web7.app.member.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;

public class MemberEditProfilePicOkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = null;

		MemberVO m_vo = new MemberVO();
		MemberDAO m_dao = new MemberDAO();

		String saveFolder = "C:\\pichall\\workspace\\PicHall\\WebContent\\app\\member\\profile_pic";
		int fileSize = 5 * 1024 * 1024;
		MultipartRequest multi = null;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		multi = new MultipartRequest(req, saveFolder, fileSize, "UTF-8", policy);

		HttpSession session = req.getSession();
		int member_seq = (int) session.getAttribute("session_seq");

		m_vo = m_dao.getDetail(member_seq);

		if (m_vo.getMember_profile_pic() == null) {
			if (m_dao.insertProfilePic(member_seq, multi)) {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath(req.getContextPath() + "/member/MemberEditProfile.me");
			}
		} else {
			File f = new File(saveFolder, m_vo.getMember_profile_pic());
			if (f.exists()) {
				f.delete();
			}
			if (m_dao.insertProfilePic(member_seq, multi)) {
				PrintWriter out = resp.getWriter();
				resp.setContentType("text/html;charset=utf-8");
				out.println("<script>");
				out.println("alert('프로필 사인이 성공적으로 변경되었습니다')");
				out.println("location.replace('MemberEditProfile.me')");
				out.println("</script>");
				out.close();
				return null;
			}
		}
		return forward;
	}

}
