package com.web7.app.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.comment.vo.CommentVO;
import com.web7.mybatis.config.SqlMapConfig;

public class CommentDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public CommentDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public List<CommentVO> getCommentList(int board_seq) {
		return sqlsession.selectList("Comment.getCommentList", board_seq);
	}
	
	public int getCnt(int board_seq) {
		return sqlsession.selectOne("Comment.getCnt", board_seq);
	}
	
	public void deleteAllComment(int board_seq) {
		sqlsession.delete("Comment.deleteAllComment", board_seq);
	}
	
	public void deleteUserComment(int member_seq) {
		sqlsession.delete("Comment.deleteUserComment", member_seq);
	}
	
	public void deleteComment(int comment_seq) {
		sqlsession.delete("Comment.deleteComment", comment_seq);
	}
	
	public boolean insertComment(CommentVO comment) {
		return sqlsession.insert("Comment.insertComment", comment) == 1;
	}

	public void modifyComment(CommentVO comment) {
		sqlsession.update("Comment.modifyComment", comment);
		
	}
	
}
