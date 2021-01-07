package com.ljh.mypage.persistence;

import java.util.Date;
import com.ljh.mypage.domain.LoginDTO;
import com.ljh.mypage.domain.UserVO;

public interface UserDAO {
	// 회원가입 처리.
	public void register(UserVO userVO) throws Exception;
	
	// 로그인 처리.
	public UserVO login(LoginDTO loginDTO) throws Exception;
	
	// 로그인 유지 처리.
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception;
	
	// 세션키 검증.
	public UserVO checkUserWithSessionKey(String value) throws Exception;
	
	// 회원정보 수정처리.
	public void updateUser(UserVO userVO) throws Exception; 
	
	// 회원 비밀번호.
	public UserVO getUser(String uid) throws Exception; 
	
	// 회원비밀번호 수정처리.
	public void updatePw(UserVO userVO) throws Exception; 
	
	// 회원 프로필 사진 수정.
	public void updateUimage(String uid, String uimage) throws Exception;
	
	// 로그인 일자 갱신.
	public void updateLoginDate(String userId) throws Exception;

}
