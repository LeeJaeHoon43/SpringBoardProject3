package com.ljh.mypage.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleFileDAOImpl implements ArticleFileDAO{
	
	private static final String NAMESPACE = "com.ljh.mypage.mappers.upload.ArticleFileMapper"; 
	
	@Inject
	private SqlSession sqlSession;

	@Override
	public void addAttach(String fileName, Integer articleNo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fileName", fileName);
		paramMap.put("articleNo", articleNo);
		sqlSession.insert(NAMESPACE + ".replaceAttach", paramMap);
	}

	@Override
	public List<String> getAttach(Integer articleNo) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".getAttach", articleNo);
	}

	@Override
	public void replaceAttach(String fileName, Integer articleNo) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fileName", fileName);
		paramMap.put("articleNo", articleNo);
		sqlSession.insert(NAMESPACE + ".replaceAttach", paramMap);
	}

	@Override
	public void deleteAttach(String fileName) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteAttach", fileName);
	}

	@Override
	public void deleteAllAttach(Integer articleNo) throws Exception {
		sqlSession.delete(NAMESPACE + ".deleteAllAttach", articleNo);
	}

	@Override
	public void updateAttachCnt(Integer articleNo) throws Exception {
		sqlSession.update(NAMESPACE + ".updateAttachCnt", articleNo);
	}
}
