package com.ljh.mypage.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleVO read(Integer articleNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(ArticleVO articleVO) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer articleNo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
