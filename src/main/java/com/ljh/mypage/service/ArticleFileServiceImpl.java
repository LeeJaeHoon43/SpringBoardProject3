package com.ljh.mypage.service;

import java.util.List;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.ljh.mypage.persistence.ArticleFileDAO;

@Service
public class ArticleFileServiceImpl implements ArticleFileService{
	
	private final ArticleFileDAO articleFileDAO;
	
	@Inject
	public ArticleFileServiceImpl(ArticleFileDAO articleFileDAO) {
		this.articleFileDAO = articleFileDAO;
	}

	@Override
	public void addAttach(String fullName, Integer articleNo) throws Exception {
		articleFileDAO.addAttach(fullName, articleNo);
	}

	@Override
	public List<String> getAttach(Integer articleNo) throws Exception {
		return articleFileDAO.getAttach(articleNo);
	}

	@Override
	public void replaceAttach(String fullName, Integer articleNo) throws Exception {
		articleFileDAO.replaceAttach(fullName, articleNo);
	}

	@Override
	public void deleteAttach(String fullName) throws Exception {
		articleFileDAO.deleteAttach(fullName);
	}

	@Override
	public void deleteAllAttach(Integer articleNo) throws Exception {
		articleFileDAO.deleteAllAttach(articleNo);
	}

	@Override
	public void updateAttachCnt(Integer articleNo) throws Exception {
		articleFileDAO.updateAttachCnt(articleNo);
	}

}
