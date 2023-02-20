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

public class MemberFindPwOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String member_id = req.getParameter("member_id");
		String member_email = req.getParameter("member_email_pw");
		
		MemberDAO m_dao = new MemberDAO();
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html;charset=utf-8");
		
		if(m_dao.isExistFindPw(member_id, member_email)) {
			String code = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
			String new_pw = "";
			for (int i = 0; i < 12; i++) {
				new_pw += code.charAt((int)(Math.random()*code.length()));
			}
			
			MemberVO m_vo = m_dao.getDetail(member_id);
			
			//임시 비밀번호 넣기
			m_vo.setMember_pw(m_dao.encrypt(new_pw));
			m_dao.updatePw(m_vo);
			
			send(req, resp, new_pw);
			
			out.println("<script>");
			out.println("alert('임시비밀번호가 발급되었습니다. 이메일함을 확인해주세요.')");
			out.println("location.replace('MemberFindIdPw.me')");
			out.println("</script>");
			out.close();
			
			return null;
			
		} else {
			 out.println("<script>");
			 out.println("alert('존재하지 않는 회원입니다.')");
			 out.println("location.replace('MemberFindIdPw.me')");
			 out.println("</script>");
			 out.close();
			 return null;
		}
		
		
	}
	
	private void send(HttpServletRequest req, HttpServletResponse resp, String new_pw) throws Exception {
		String host = "http://localhost:8081/PicHall/";

		String from = "gimminjoo2126@gmail.com";

		String to = req.getParameter("member_email_pw");

		String subject = "PicHall 임시 비밀번호 발급";

		String content = "임시비밀번호 : " + new_pw + "<br>로그인 후 비밀번호를 변경하여 PicHall을 사용해주세요";

			

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
