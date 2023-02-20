package com.web7.app.music_exhibition.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.music_exhibition.vo.MusicExhibitionVO;
import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;
import com.web7.mybatis.config.SqlMapConfig;

public class MusicExhibitionDAO {

	SqlSessionFactory sqlsessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MusicExhibitionDAO() {
		sqlsession = sqlsessionf.openSession(true);
	}
	
	/**
	 * true면 새로 만들어진 전시회_음악, false면 이미 만들어지고 수정되는 전시회_음악*/
	public boolean checkIsNew(int exhibition_seq) {
		return (int)sqlsession.selectOne("MusicExhibition.checkIsNew", exhibition_seq) == 0 ? true : false;
	}
	
	public boolean insertMusicExhibition(MusicExhibitionVO me_vo) {
		return (int)sqlsession.insert("MusicExhibition.insertMusicExhibition", me_vo) == 1;
	}
	
	public void deleteAll(int exhibition_seq) {
		sqlsession.delete("MusicExhibition.deleteAll", exhibition_seq);
	}
	
	
	public void delete(int music_seq) {
		sqlsession.delete("MusicExhibition.delete", music_seq);
	}
	
	//전시회에 맞는 음악리스트 가져오기
	public List<MusicExhibitionVO> getMusicbySeq(int exhibition_seq){
		return sqlsession.selectList("MusicExhibition.getMusicbySeq",exhibition_seq);
	}
	
	
}
