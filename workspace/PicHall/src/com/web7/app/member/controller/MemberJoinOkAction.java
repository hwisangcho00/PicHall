package com.web7.app.member.controller;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web7.action.Action;
import com.web7.action.ActionForward;
import com.web7.app.member.dao.MemberDAO;
import com.web7.app.member.vo.MemberVO;
import com.web7.util.Gmail;
import com.web7.util.SHA256;

public class MemberJoinOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		 req.setCharacterEncoding("UTF-8");
		
		 ActionForward forward = null;
		 
		 MemberDAO m_dao = new MemberDAO();
		 MemberVO m_vo = new MemberVO();
		 
		 int newMember_seq = m_dao.getNextVal();
		 
		 // 임시적으로 0으로 넣기. xml에서 nextval로 들어감
		 m_vo.setMember_seq(newMember_seq);
		 m_vo.setMember_name(req.getParameter("member_name"));
		 m_vo.setMember_id(req.getParameter("member_id"));
		 m_vo.setMember_pw(req.getParameter("member_pw"));
		 m_vo.setMember_nickname(req.getParameter("member_nickname"));
		 //m_vo.setMember_text(req.getParameter("member_text"));
		 m_vo.setMember_text("");
		 m_vo.setMember_email(req.getParameter("member_email"));
		 
		 //이메일 인증 부분
		 m_vo.setMember_email_checked(0);
		 m_vo.setMember_email_hash(SHA256.getSHA256(req.getParameter("member_email")));
		 
		 if(!m_dao.join(m_vo)) {
			 PrintWriter out = resp.getWriter();
			 resp.setContentType("text/html;charset=utf-8");
			 out.println("<script>");
			 out.println("alert('회원가입 실패. 잠시 후 다시 시도해주세요.')");
			 out.println("</script>");
			 out.close();
		 }else {
			 
			 //이메일 보내기
			 send(req, resp, newMember_seq);
			 
			 forward = new ActionForward();
			 
			 
			 
			 forward.setRedirect(true);
			 
			 /**이메일 파라미터 전달*/
			 /**회원가입에 성공했습니다. 이메일을 확인해보세요*/
			 forward.setPath(req.getContextPath()+"/member/MemberJoinSuccess.me?email="+m_vo.getMember_email());
		 }
		 
		return forward;
	}
	
	private void send(HttpServletRequest req, HttpServletResponse resp, int newMember_seq) throws Exception {
		String host = "http://localhost:8081/PicHall/";

		String from = "gimminjoo2126@gmail.com";

		String to = req.getParameter("member_email");

		String subject = "PicHall 이메일 인증 메일입니다.";

		String content = "다음 링크에 접속하여 이메일 확인을 진행하세요." +

			"<a href='" + host + "member/MemberJoinSuccessOk.me?code=" + SHA256.getSHA256(to) + "&member_seq="+ newMember_seq + "'>이메일 인증하기</a>";

		Properties p = new Properties();

		p.put("mail.smtp.user", from);

		p.put("mail.smtp.host", "smtp.googlemail.com");

		p.put("mail.smtp.port", "465");

		p.put("mail.smtp.starttls.enable", "true");

		p.put("mail.smtp.auth", "true");

		p.put("mail.smtp.debug", "true");

		p.put("mail.smtp.socketFactory.port", "465");

		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		p.put("mail.smtp.socketFactory.fallback", "false");

		try{

		    Authenticator auth = new Gmail();

		    Session ses = Session.getInstance(p, auth);

		    ses.setDebug(true);

		    MimeMessage msg = new MimeMessage(ses); 

		    msg.setSubject(subject);

		    Address fromAddr = new InternetAddress(from);

		    msg.setFrom(fromAddr);

		    Address toAddr = new InternetAddress(to);

		    msg.addRecipient(Message.RecipientType.TO, toAddr);

		    msg.setContent(content, "text/html;charset=UTF-8");

		    Transport.send(msg);

		} catch(Exception e){

		    e.printStackTrace();

			PrintWriter out = resp.getWriter();

			out.println("<script>");

			out.println("alert('오류가 발생했습니다..');");

			out.println("history.back();");

			out.println("</script>");

			out.close();		

		    return;

		}





	}
}














