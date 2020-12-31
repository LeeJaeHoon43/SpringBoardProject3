package com.ljh.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ljh.mypage.commons.paging.Criteria;
import com.ljh.mypage.commons.paging.SearchCriteria;
import com.ljh.mypage.domain.ArticleVO;
import com.ljh.mypage.persistence.ArticleDAO;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	private final ArticleDAO articleDAO;
	
	@Inject
	public ArticleServiceImpl(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	} 

	@Override
	public void create(ArticleVO articleVO) throws Exception {
		articleDAO.create(articleVO);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public ArticleVO read(Integer articleNo) throws Exception {
		articleDAO.updateViewCnt(articleNo);
		return articleDAO.read(articleNo);
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		articleDAO.update(articleVO);
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		articleDAO.delete(articleNo);
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		return articleDAO.listAll();
	}

	@Override
	public List<ArticleVO> listCriteria(Criteria criteria) throws Exception {
		return articleDAO.listCriteria(criteria);
	}

	@Override
	public int countArticles(Criteria criteria) throws Exception {
		return articleDAO.countArticles(criteria);
	}

	@Override
	public List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception {
		return articleDAO.listSearch(searchCriteria);
	}

	@Override
	public int countSearchedArticles(SearchCriteria searchCriteria) throws Exception {
		return articleDAO.countSearchedArticles(searchCriteria);
	}
}
