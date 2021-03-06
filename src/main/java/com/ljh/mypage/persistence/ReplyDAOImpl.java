package com.ljh.mypage.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import com.ljh.mypage.commons.paging.Criteria;
import com.ljh.mypage.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	private static String NAMESPACE = "com.ljh.mypage.mappers.reply.replyMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public ReplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ReplyVO> list(Integer articleNo) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".list", articleNo);
	}

	@Override
	public void create(ReplyVO replyVO) throws Exception {
		sqlSession.insert(NAMESPACE + ".create", replyVO);
	}

	@Override
	public void update(ReplyVO replyVO) throws Exception {
		sqlSession.update(NAMESPACE + ".update", replyVO);
	}

	@Override
	public void delete(Integer replyNo) throws Exception {
		sqlSession.delete(NAMESPACE + ".delete", replyNo);
	}

	@Override
	public List<ReplyVO> listPaging(Integer articleNo, Criteria criteria) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("articleNo", articleNo);
		paramMap.put("criteria", criteria);
		return sqlSession.selectList(NAMESPACE + ".listPaging", paramMap);
	}

	@Override
	public int countReplies(Integer articleNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".countReplies", articleNo);
	}

	@Override
	public int getArticleNo(Integer replyNo) throws Exception {
		return sqlSession.selectOne(NAMESPACE + ".getArticleNo", replyNo);
	}

	@Override
	public List<ReplyVO> userReplies(String userId) throws Exception {
		return sqlSession.selectList(NAMESPACE + ".userReplies", userId);
	}	
}
