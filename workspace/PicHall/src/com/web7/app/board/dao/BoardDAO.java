package com.web7.app.board.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.board.vo.BoardVO;
import com.web7.mybatis.config.SqlMapConfig;

public class BoardDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public BoardDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	//페이지 별 게시글 목록
	public List<BoardVO> getBoardList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		return sqlsession.selectList("Board.listAll", pageMap);
	}
	
	//카테고리 설정시 페이지별 게시글 목록
	public List<BoardVO> getSpecificBoardList(int startRow, int endRow, int board_category_id) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("board_category_id", board_category_id);
		
		return sqlsession.selectList("Board.listSpecificAll", pageMap);
	}
	
	public List<BoardVO> getSearchBoardList(int startRow, int endRow, String query) {
		
		HashMap<String, Object> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("query", "%"+query+"%");
		
		return sqlsession.selectList("Board.listSearchAll", pageMap);
	}
	
	//총 게시글 갯수 반환
	public int getBoardCnt() {
		return sqlsession.selectOne("Board.getBoardCnt");
	}
	
	//카테고리별 게시글 개수 반환
	public int getSpecificBoardCnt(int board_category_id) {
		return sqlsession.selectOne("Board.getSpecificBoardCnt", board_category_id);
	}
	
	//게시글 추가
	public boolean insertBoard(BoardVO board) {
		return sqlsession.insert("Board.insertBoard", board) ==1;
	}
	
	//게시글 객체 가져오기
	public BoardVO getBoard(int board_seq) {
		return sqlsession.selectOne("Board.getBoard", board_seq);
	}
	
	//게시글 수정
	public boolean modifyBoard(BoardVO board) {
		return sqlsession.update("Board.modifyBoard", board)==1;
	}
	
	//게시글 삭제
	public void deleteBoard(int board_seq) {
		sqlsession.delete("Board.deleteBoard", board_seq);
	}
	
	//새로운 게시글 번호 반환
	public int getBoardSeq() {
		return sqlsession.selectOne("Board.getSeq");
	}
	
	public int getBoardHits(int board_seq){
		return sqlsession.selectOne("Board.getBoardHits", board_seq);
	}
	
	public void updateBoardHits(int board_seq) {
		sqlsession.update("Board.updateBoardHits", board_seq);
	}

	public int getSearchBoardCnt(String query) {
		return sqlsession.selectOne("Board.getSearchBoardCnt", "%"+query+"%");
	}

	

	
}
















