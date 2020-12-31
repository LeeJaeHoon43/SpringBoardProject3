package com.ljh.mypage.persistence;

import java.util.List;

import com.ljh.mypage.commons.paging.Criteria;
import com.ljh.mypage.domain.ReplyVO;

public interface ReplyDAO {
	public List<ReplyVO> list(Integer articleNo) throws Exception;
	public void create(ReplyVO replyVO) throws Exception;
	public void update(ReplyVO replyVO) throws Exception;
	public void delete(Integer replyNo) throws Exception;
	public List<ReplyVO> listPaging(Integer articleNo, Criteria criteria) throws Exception; 
	public int countReplies(Integer articleNo) throws Exception;
	public int getArticleNo(Integer replyNo) throws Exception;
}
