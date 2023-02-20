package com.web7.app.subscribe.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.subscribe.vo.SubscribeVO;
import com.web7.mybatis.config.SqlMapConfig;

public class SubscribeDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public SubscribeDAO() {
		//세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto 커밋으로 설정
		sql_session = sessionf.openSession(true);
	}
	
//	로그인한 유저가 다른 사람의 유저페이지에 들어가서 구독을 누른다고 가정
//	FOLLOWED(팔로워)에는 SESSION_ID, FOLLOWING에는 유저페이지 주인의 MEMBER_ID
	//구독하기
	public boolean subscribe(SubscribeVO subscribe) {
		return sql_session.insert("Subscribe.subscribe", subscribe) == 1;
	}
	//구독해지
	public boolean unsubscribe(SubscribeVO unsubscribe) {
		return sql_session.delete("Subscribe.unsubscribe", unsubscribe)==1;
	}
	//팔로잉 보기
	public List<SubscribeVO> getFollowingList(int member_seq) {
	
		return sql_session.selectList("Subscribe.getFollowingList", member_seq);
	}
	//팔로워(followed) 보기
	public List<SubscribeVO> getFollowerList(int member_seq) {

		return sql_session.selectList("Subscribe.getFollowerList", member_seq);
	}

}
