package com.web7.app.like.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.like.vo.LikeVO;
import com.web7.mybatis.config.SqlMapConfig;

public class LikeDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public LikeDAO() {
		sql_session = sessionf.openSession(true);
	}
	
	//exhibition_seq로 member_seq LIST 가져오기(좋아요 했는지 판단)
	public List<LikeVO> getMemberList(int exhibition_seq) {
		return sql_session.selectList("Like.listAllbySeq",exhibition_seq);
	}
	//좋아요 추가
	public boolean like(LikeVO like) {
		return sql_session.insert("Like.like", like)==1;
	}
	//좋아요 취소
	public boolean cancel(LikeVO cancel) {
		return sql_session.insert("Like.cancel", cancel)==1;
	}
	//좋아요 개수
	public int getlikeCnt(int exhibition_seq) {
		return sql_session.selectOne("Like.getLikeCnt",exhibition_seq);
	}
	public void deleteAll(int exhibition_seq) {
		sql_session.delete("Like.deleteAll",exhibition_seq);
	}
}
