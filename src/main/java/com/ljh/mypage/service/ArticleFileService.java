package com.ljh.mypage.service;

import java.util.List;

public interface ArticleFileService {
	// 게시글 첨부파일 추가.
	public void addAttach(String fullName, Integer articleNo) throws Exception; 
	// 게시글 첨부파일 조회.
	public List<String> getAttach(Integer articleNo) throws Exception; 
	// 게시글 첨부파일 수정.
	public void replaceAttach(String fullName, Integer articleNo) throws Exception; 
	// 게시글 첨부파일 삭제. 
	public void deleteAttach(String fullName) throws Exception; 
	// 게시글 첨부파일 일괄 삭제.
	public void deleteAllAttach(Integer articleNo) throws Exception; 
	// 특정 게시글의 첨부파일 갯수 갱신.
	public void updateAttachCnt(Integer articleNo) throws Exception;
}