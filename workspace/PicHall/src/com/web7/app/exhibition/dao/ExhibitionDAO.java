package com.web7.app.exhibition.dao;

import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.web7.app.exhibition.vo.ExhibitionVO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.mybatis.config.SqlMapConfig;

public class ExhibitionDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public ExhibitionDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	//유저에 따른 전시회 목록
	public List<ExhibitionVO> getExhibitionListbySeq(int member_seq){
		return sqlsession.selectList("Exhibition.listAllbySeq", member_seq);
	}
	//시작날짜 구하기
	public Date getStartDate(String start_date) {
		return sqlsession.selectOne("Exhibition.getStartDate",start_date);
	}
	//종료날짜 구하기
	public Date getEndDate(String end_date) {
		return sqlsession.selectOne("Exhibition.getEndDate",end_date);
	}
	
	//전시회 seq로 해당 게시글 가져오기
	public ExhibitionVO getDetail(int exhibition_seq) {
		return sqlsession.selectOne("Exhibition.getDetail",exhibition_seq);
	}
	
	//전시회 seq로 member_seq 가져오기
	public int getMemberSeq(int exhibition_seq) {
		return sqlsession.selectOne("Exhibition.getMemberSeq",exhibition_seq);		
	}
	
	//exhibition_seq로 exhibition_text 가져오기
	public String getExhibitionText(int exhibition_seq) {
		return sqlsession.selectOne("Exhibition.getExhibitionText",exhibition_seq);	
	}
	
	//exhibition_seq로 exhibition_title 가져오기
	public String getExhibitionTitle(int exhibition_seq) {
		return sqlsession.selectOne("Exhibition.getExhibitionTitle",exhibition_seq);	
	}
	
	//게시글 전체 개수
	public int getExhibitionCnt() {
		return sqlsession.selectOne("Exhibition.getExhibitionCnt");
	}
	
	//게시글 전체 개수
	public int getExhibitionCntbySeq(int member_seq) {
		return sqlsession.selectOne("Exhibition.getExhibitionCntbySeq", member_seq);
	}
	
	//카테고리별 게시글 전체 개수
	public int getExhibitionCntbyCategory(int category_id) {
		return sqlsession.selectOne("Exhibition.getExhibitionCntbyCategory", category_id);
	}
	
	public int getExhibitionCntbyParentCategory(int category_id) {
		return sqlsession.selectOne("Exhibition.getExhibitionCntbyParentCategory",category_id);
	}
	
	//전시회 번호 가져오기
	public int getExhibitionSeq() {
		return sqlsession.selectOne("Board.getExhibitionSeq");
	}
		
	//전시회 추가
	public boolean insertExhibition(ExhibitionVO Exhibition) {
		return sqlsession.insert("Exhibition.insertExhibition", Exhibition) == 1;
	}
	
	//전시회 업데이트
	public boolean updateExhibition(ExhibitionVO Exhibition) {
		return sqlsession.update("Exhibition.updateExhibition", Exhibition) ==1;
	}
	
	//전시회 수정
	public boolean modifyExhibition(ExhibitionVO Exhibition) {
		return sqlsession.update("Exhibition.modifyExhibition", Exhibition) ==1;
	}
	
	//전시회 삭제
	public void deleteExhibition(int Exhibition_seq) {
		sqlsession.delete("Exhibition.deleteExhibition", Exhibition_seq);
	}
	
	//전시회 수정(제목, 설명, 날짜, 카테고리)(사진이랑 음악은 각각 dao에서 관리)
	public void updateBoard(ExhibitionVO e_vo) {
		sqlsession.update("Exhibition.updateExhibition", e_vo);
	}
	
	public int getNextVal() {
		return sqlsession.selectOne("Exhibition.getNextVal");
	}

	//페이지 별 전시회 목록
	public List<ExhibitionVO> getExhibitionList(int startRow, int endRow) {
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		return sqlsession.selectList("Exhibition.listAll", pageMap);
	}
	//전시회 목록(좋아요 순, 7개)
	public List<ExhibitionVO> getExhibitionListbyLike(int startRow, int endRow){
		HashMap<String, Integer> pageMap = new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		return sqlsession.selectList("Exhibition.listbyLike",pageMap);
	}
	//유저의 페이지 별 전시회 목록
	public List<ExhibitionVO> getExhibitionPageListbySeq(int startRow, int endRow, int member_seq) {
		HashMap<String, Integer> pageMap=new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("member_seq", member_seq);
		
		return sqlsession.selectList("Exhibition.listbySeq", pageMap);
	}

	public List<ExhibitionVO> getChildBoardList(int startRow, int endRow, int exhibition_category_id) {
		HashMap<String, Integer> pageMap=new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("exhibition_category_id", exhibition_category_id);
		
		return sqlsession.selectList("Exhibition.listChildAll", pageMap);
	}
	
	public List<ExhibitionVO> getParentBoardList(int startRow, int endRow, int exhibition_category_id) {
		HashMap<String, Integer> pageMap=new HashMap<>();
		
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("exhibition_category_id", exhibition_category_id);
		
		return sqlsession.selectList("Exhibition.listParentAll", pageMap);
	}

	public boolean updateLikeCnt(ExhibitionVO Exhibition) {
		return sqlsession.update("Exhibition.updateLikeCnt", Exhibition) ==1;
	}
	
}
