package com.web7.app.attach.dao;

import java.util.Enumeration;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oreilly.servlet.MultipartRequest;
import com.web7.app.attach.vo.AttachVO;
import com.web7.mybatis.config.SqlMapConfig;

public class AttachDAO {

	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public AttachDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	public boolean insertAttach(int board_seq, MultipartRequest multi) {
		Enumeration<String> files = multi.getFileNames();
		boolean check = true;
		
		AttachVO attach = new AttachVO();
		attach.setBoard_seq(board_seq);

		while(files.hasMoreElements()) {
			String data = files.nextElement();
			String systemName = multi.getFilesystemName(data);
			
			if(systemName == null) {continue;}
			
			attach.setAttach_name(systemName);
			
			if(sqlsession.insert("Attach.insertAttach", attach) != 1) {
				check = false;
				break;
			}
		}
		
		return check;
	}

	public List<AttachVO> getDetail(int board_seq) {
		return sqlsession.selectList("Attach.getDetail", board_seq);
	}
	
	public void deleteAttach(int board_seq) {
		sqlsession.delete("Attach.deleteAttach", board_seq);
	}
	
}
