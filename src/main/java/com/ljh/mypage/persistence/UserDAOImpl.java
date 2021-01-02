package com.ljh.mypage.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ljh.mypage.domain.LoginDTO;
import com.ljh.mypage.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final String NAMESPACE = "com.ljh.mypage.mappers.user.UserMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public UserDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void register(UserVO userVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".register", userVO);
	}

	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
	}

	@Override
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		paramMap.put("sessionId", sessionId);
		paramMap.put("sessionLimit", sessionLimit);
		sqlSession.update(NAMESPACE + ".keepLogin", paramMap);
	}

	@Override
	public UserVO checkUserWithSessionKey(String value) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
	}
}
