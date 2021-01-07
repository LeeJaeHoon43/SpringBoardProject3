package com.ljh.mypage.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ljh.mypage.domain.LoginDTO;
import com.ljh.mypage.domain.UserVO;
import com.ljh.mypage.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService{
	
	private UserDAO userDAO;
	
	@Inject
	public UserServiceImpl(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	// 회원가입 처리.
	@Override
	public void register(UserVO userVO) throws Exception {
		userDAO.register(userVO);
	}

	@Override
	public UserVO login(LoginDTO loginDTO) throws Exception {
		userDAO.updateLoginDate(loginDTO.getUserId());
		return userDAO.login(loginDTO);
	}

	@Override
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
		userDAO.keepLogin(userId, sessionId, sessionLimit);
	}

	@Override
	public UserVO checkLoginBefore(String value) throws Exception {
		return userDAO.checkUserWithSessionKey(value);
	}

	@Override
	public void updateUser(UserVO userVO) throws Exception {
		userDAO.updateUser(userVO);
	}

	@Override
	public UserVO getUser(String uid) throws Exception {
		return userDAO.getUser(uid);
	}

	@Override
	public void updatePw(UserVO userVO) throws Exception {
		userDAO.updatePw(userVO);
	}

	@Override
	public void updateUimage(String uid, String uimage) throws Exception {
		userDAO.updateUimage(uid, uimage);
	}
}
