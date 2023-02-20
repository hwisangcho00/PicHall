package com.web7.app.music.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.web7.app.attach.vo.AttachVO;
import com.web7.app.music.vo.MusicVO;
import com.web7.mybatis.config.SqlMapConfig;

public class MusicDAO {

	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public MusicDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public List<MusicVO> getMusicList(int member_seq){
		return sqlsession.selectList("Music.getMusicList", member_seq);
	}
	
	public void deleteMusic(int music_seq) {
		sqlsession.delete("Music.deleteMusic", music_seq);
	}
	
	public MusicVO getMusic(int music_seq) {
		return sqlsession.selectOne("Music.getMusic", music_seq);
	}
	
	public boolean insertMusic(MusicVO music, MultipartRequest multi) {
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		while(files.hasMoreElements()) {
			String data = files.nextElement();
			String systemName = multi.getFilesystemName(data);
			
			if(systemName == null) {continue;}
			
			music.setMusic_data(systemName);
			
			if(sqlsession.insert("Music.insertMusic", music) != 1) {
				check = false;
				break;
			}
		}
		
		return check;
	}

	public void modifyMusic(MusicVO mu_vo) {
		sqlsession.update("Music.modifyMusic", mu_vo);
	}

	public int getMusicCnt(int member_seq) {
		return sqlsession.selectOne("Music.getMusicCnt", member_seq);
	}
	
	
	
}
