package com.web7.app.exhibition_category.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.web7.app.exhibition_category.vo.CategoryVO;
import com.web7.mybatis.config.SqlMapConfig;

public class CategoryDAO {
	SqlSessionFactory sessionf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	public CategoryDAO() {
		sqlsession = sessionf.openSession(true);
	}
	
	//카테고리 세부사항 가져오기
	public CategoryVO getDetail(int category_id) {
		return sqlsession.selectOne("Category.getDetail",category_id);
	}
	
	//카테고리 이름(type)으로 category_seq 가져오기
	public int getIdbyType(String category_type) {
		return sqlsession.selectOne("Category.getIdbyType", category_type);
	}
}
