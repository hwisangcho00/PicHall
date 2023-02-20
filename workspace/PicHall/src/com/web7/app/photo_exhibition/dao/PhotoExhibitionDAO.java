package com.web7.app.photo_exhibition.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.photo_exhibition.vo.PhotoExhibitionVO;
import com.web7.mybatis.config.SqlMapConfig;

public class PhotoExhibitionDAO {
	SqlSessionFactory sqlsessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public PhotoExhibitionDAO() {
		sqlsession = sqlsessionf.openSession(true);
	}
	public boolean checkIsNew(int exhibition_seq) {
		return (int)sqlsession.selectOne("PhotoExhibition.checkIsNew", exhibition_seq) == 0 ? true : false;
	}
	
	public boolean insertPhotoExhibition(PhotoExhibitionVO pe_vo) {
		return (int)sqlsession.insert("PhotoExhibition.insertPhotoExhibition", pe_vo) == 1;
	}
	
	public void deleteAll(int exhibition_seq) {
		sqlsession.delete("PhotoExhibition.deleteAll", exhibition_seq);
	}
	
	public void delete(int photo_seq) {
		sqlsession.delete("PhotoExhibition.delete", photo_seq);
	}
	
	//전시회에 맞는 사진들 가져오기
	public List<PhotoExhibitionVO> getPhotobySeq(int exhibition_seq){
		return sqlsession.selectList("PhotoExhibition.getPhotobySeq",exhibition_seq);
	}
}
