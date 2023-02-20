package com.web7.app.member.dao;

import java.util.Enumeration;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.web7.app.member.vo.MemberVO;
import com.web7.mybatis.config.SqlMapConfig;

public class MemberDAO {
	
	private static final int KEY = 3;
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public MemberDAO() {
		//세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto 커밋으로 설정
		sql_session = sessionf.openSession(true);
	}
	
	//아이디로 member_seq 가져오기
	public int getSeq(String member_id) {
		return sql_session.selectOne("Member.getSeq", member_id);
	}
	
	//member_seq로 member_id 가져오기
	public String getId(int member_seq) {
		return sql_session.selectOne("Member.getId", member_seq);
	}
	
	//member_id로 유저의 정보 가져오기
	public MemberVO getDetail(String member_id) {
		return sql_session.selectOne("Member.getDetail",member_id);
	}

	//member_seq로 유저의 정보 가져오기 (오버로딩)
	public MemberVO getDetail(int member_seq) {
		return sql_session.selectOne("Member.getDetailbySeq",member_seq);
	}
	
	//member_id로 닉네임 가져오기
	public String getNickname(String member_id) {
		return sql_session.selectOne("Member.getNickname",member_id);
	}

	//member_seq로 닉네임 가져오기
	public String getNicknamebySeq(int member_seq) {
		return sql_session.selectOne("Member.getNicknamebySeq",member_seq);
	}
	
	//member_id로 member_text 가져오기
	public String getText(String member_id) {
		return sql_session.selectOne("Member.getText",member_id);
	}
	
	//member_seq로 member_text 가져오기
	public String getTextbySeq(int member_seq) {
		return sql_session.selectOne("Member.getTextbySeq",member_seq);
	}
	
	public String getEmailbySeq(int member_seq) {
		return sql_session.selectOne("Member.getEmailbySeq", member_seq);
	}
	
	public int getNextVal() {
		return sql_session.selectOne("Member.getNextVal");
	}
	
	//회원가입
	public boolean join(MemberVO member) {
		member.setMember_pw(encrypt(member.getMember_pw()));
		return sql_session.insert("Member.join", member) == 1;
	}
	
	
	/***
	 * 아이디검사
	 * @param member_id
	 * true이면 사용 가능
	 * false이면 사용 불가능
	 */
	public boolean checkId(String member_id) {
		
		return (Integer)sql_session.selectOne("Member.checkId", member_id) == 0;
	}
	
	//이메일 검사
	public boolean checkEmail(String member_email) {
		return (Integer)sql_session.selectOne("Member.checkEmail", member_email) == 0;
	}
	
	//비밀번호 맞는지 검사
	public boolean checkPw(int member_seq, String member_pw) {
		HashMap<String, Object> member = new HashMap<>();
		
		member.put("member_seq", member_seq);
		member.put("member_pw", encrypt(member_pw));
		
		return (Integer)sql_session.selectOne("Member.checkPw", member) == 1;
	}
	
	//로그인
	public boolean login(String member_id, String member_pw) {
		HashMap<String, String> member = new HashMap<>();
		
		member.put("member_id", member_id);
		member.put("member_pw", encrypt(member_pw));
		
		return (Integer)sql_session.selectOne("Member.login", member) == 1;
	}
	
	/* 프로필 사진 */
	public boolean insertProfilePic(int member_seq, MultipartRequest multi) {
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		MemberVO member = new MemberVO();
		member.setMember_seq(member_seq);
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			String systemName = multi.getFilesystemName(data);
			
			if(systemName == null) {continue;}
			
			member.setMember_profile_pic(systemName);
			
			if(sql_session.insert("Member.insertProfilePic", member) != 1) {
				check = false;
				break;
			}
		}
		return check;
	}
	
	/* 회원정보 수정 관련 메소드 */
	public void updatePw(MemberVO member) {
		sql_session.update("Member.updatePw", member);
	}
	
	public void updateNickname(MemberVO member) {
		sql_session.update("Member.updateNickname", member);
	}
	
	public void updateText(MemberVO member) {
		sql_session.update("Member.updateText", member);
	}
	
	public void updateEmailChecked(MemberVO member) {
		sql_session.update("Member.updateEmailChecked", member);
	}
	
	//암호화
	public String encrypt(String pw) {
		
		String en_pw = "";
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		
		return en_pw;
	}
	
	
	//복호화
	public String decrypt(String en_pw) {
		
		String de_pw = "";
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		
		return de_pw;
	}

	//비번 아이디 찾기
	public String findId(String member_name, String member_email) {
		HashMap<String, String> member = new HashMap<>();
		
		member.put("member_name", member_name);
		member.put("member_email", member_email);
		
		return sql_session.selectOne("Member.findId", member);
	}
	
	public boolean isExistFindPw(String member_id, String member_email) {
		HashMap<String, String> member = new HashMap<>();
		
		member.put("member_id", member_id);
		member.put("member_email", member_email);
		
		return (int)sql_session.selectOne("Member.isExistFindPw", member) != 0;
	}

	


	
	/*//Gmail API
	public send() {
		
	}*/
}

















