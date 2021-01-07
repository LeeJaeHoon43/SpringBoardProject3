package com.ljh.mypage.persistence;

import java.util.List;

import com.ljh.mypage.commons.paging.Criteria;
import com.ljh.mypage.commons.paging.SearchCriteria;
import com.ljh.mypage.domain.ArticleVO;

public interface ArticleDAO {
	public void create(ArticleVO articleVO) throws Exception;
	public ArticleVO read(Integer articleNo) throws Exception;
	public void update(ArticleVO articleVO) throws Exception;
	public void delete(Integer articleNo) throws Exception;
	public List<ArticleVO> listAll() throws Exception;
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
	public int countArticles(Criteria criteria) throws Exception;
	public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception; 
	public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
	public void updateReplyCnt(Integer articleNo, int amount) throws Exception;
	public void updateViewCnt(Integer articleNo) throws Exception;
	// 회원이 작성한 게시글 목록.
	public List<ArticleVO> userBoardList(String userId) throws Exception; 
	// 회원 프로필 사진 수정.
	public void updateWriterImg(ArticleVO articleVO) throws Exception;
}
