package com.ljh.mypage.service;

import java.util.Date;

import com.ljh.mypage.domain.LoginDTO;
import com.ljh.mypage.domain.UserVO;

public interface UserService {
	// 회원가입 처리.
	public void register(UserVO userVO) throws Exception;

	// 로그인 처리.
	public UserVO login(LoginDTO loginDTO) throws Exception;

	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception; 

	public UserVO checkLoginBefore(String value) throws Exception;

	// 회원정보 수정처리.
	public void updateUser(UserVO userVO) throws Exception; 

	// 회원 비밀번호.
	public UserVO getUser(String uid) throws Exception; 

	// 회원비밀번호 수정처리.
	public void updatePw(UserVO userVO) throws Exception; 

	// 회원 프로필 사진 수정.
	public void updateUimage(String uid, String uimage) throws Exception;
}
