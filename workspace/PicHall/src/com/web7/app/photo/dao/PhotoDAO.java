package com.web7.app.photo.dao;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.web7.app.music.vo.MusicVO;
import com.web7.app.photo.vo.PhotoVO;
import com.web7.app.subscribe.vo.SubscribeVO;
import com.web7.mybatis.config.SqlMapConfig;

public class PhotoDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public PhotoDAO() {
		sqlsession = sessionf.openSession(true);
	}
	//페이지 별 게시글 목록
	/*public List<PhotoVO> getPhotoList(int photo_seq){
		return sqlsession.selectList("Photo.getPhotoList", photo_seq);
	}*/
	
	//사진업로드
	public boolean insertPhoto(PhotoVO photo, MultipartRequest multi) {
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			String systemName = multi.getFilesystemName(data);
			
			if(systemName == null) {continue;}
			
			photo.setPhoto_data(systemName);
			
			if(sqlsession.insert("Photo.insertPhoto", photo) != 1) {
				check = false;
				break;
			}
		}
		
		return check;
	}
	
 	//사진 리스트 가져오기
	public List<PhotoVO> getPhotoList(int member_seq) {
		return sqlsession.selectList("Photo.getPhotoList", member_seq);
	}
	
	//사진 개수 가져오기
	public int getPhotoCnt(int member_seq) {
		return sqlsession.selectOne("Photo.getPhotoCnt", member_seq);
	}
	
	//사진가져오기
	public PhotoVO getPhoto(int photo_seq) {
		return sqlsession.selectOne("Photo.getPhoto", photo_seq);
	}
	
	
	//사진 삭제
	public void deletePhoto(int photo_seq) {
		sqlsession.delete("Photo.deletePhoto", photo_seq);
	}
	//사진 수정
	public void editPhoto(PhotoVO p_vo) {
		sqlsession.update("Photo.editPhoto", p_vo);
	}
	
	//사진번호로 getPhoto_data
	public String getPhotoData(int photo_seq) {
		return sqlsession.selectOne("Photo.getPhotoData", photo_seq);
	}
	
	//사진업로드 미완
//	public boolean insertPhotos(int photo_num, MultipartRequest multi) {
//		Enumeration<String> photos = multi.getPhotoNames();
//		boolean check = true;
//		
//		PhotoVO photo =new PhotoVO();
//		photo.setPhoto_seq(photo_num);
//		
//		while(photo.hasMoreElements()) {
//			//사용자가 업로드한 파일명
//			String data = photos.nextElement();
//			//사용자가 업로드한 파일명을 통해서 중복이 없는 시스템파일명을 가져온다.
//			String systemName=multi.getFilesystemName(data);
//			
//			//슬롯 별로 검사하여 null이 아닐 때에만 DB에 INSERT한다.
//			if(systemName == null) {continue;}
//			photo.setPhoto_name(systemName);
//
//			if(sqlsession.insert("Photo.insertPhoto", photo) != 1) {
//				//추가 실패 시 check에 false 대입.
//				check = false;
//				break;
//			}
//		}
//		return check;
//	}
	
}
