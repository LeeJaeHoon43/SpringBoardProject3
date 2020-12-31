package com.ljh.mypage.service;

import java.util.List;

import com.ljh.mypage.commons.paging.Criteria;
import com.ljh.mypage.domain.ReplyVO;

public interface ReplyService {
	public List<ReplyVO> list(Integer articleNo) throws Exception;
	public void addReply(ReplyVO replyVO) throws Exception;
	public void update(ReplyVO replyVO) throws Exception;
	public void removeReply(Integer replyNo) throws Exception;
	public List<ReplyVO> getRepliesPaging(Integer articleNo, Criteria criteria) throws Exception; 
	public int countReplies(Integer articleNo) throws Exception;
}
