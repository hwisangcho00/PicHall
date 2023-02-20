package com.web7.app.report.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.report.vo.ReportVO;
import com.web7.mybatis.config.SqlMapConfig;

public class ReportDAO {
	
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sql_session;
	
	public ReportDAO() {
		//세션 팩토리로 세션을 열어주고 모든 쿼리문은 auto 커밋으로 설정
		sql_session = sessionf.openSession(true);
	}
	
	//신고하기
	public boolean report(ReportVO report) {
		return sql_session.insert("Report.report", report) == 1;
	}
	
	public void deleteAll(int exhibition_seq) {
		sql_session.delete("Report.deleteAll", exhibition_seq);
	}
}
