package com.dailydatahub.dailydatahub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailydatahub.dailydatahub.domain.User;

import jakarta.servlet.http.HttpServletRequest;


@Service
public interface UserService {

    /**
     * 해당하는 사용자의 상세 정보를 조회한다.
     * @param userDto
     * @return
     */
    public Optional<User> selectUserDetail(User userDto);

    /**
     * 해당하는 팀의 사용자 리스트를 조회한다.
     * @param teamSeq
     * @return
     */
    public List<User> selectUserList(Long teamSeq);

    /**
     * 사용자를 신규 생성한다.
     * @param userDto
     * @return
     */
    public User saveUser(User userDto);

    /**
     * 아이디, 이름, 팀명, 이메일을 기준으로 사용자를 조회한다.
     * @param userDto
     * @return
     */
    public Optional<User> selectUserByInfo(User userDto);

    /**
     * 해당하는 사용자의 비밀번호를 초기화한다.
     * @param userDto
     * @return
     */
    public User initUserPassword(User userDto);

    /**
     * 사용자 세션 정보를 생성합니다.
     * @param userDto
     */
    public void createUserSession(User userDto, HttpServletRequest request);

    /**
     * 로그아웃 처리 및 사용자 세션 정보를 초기화합니다.
     * @param userDto
     */
    public void logoutUser(HttpServletRequest request);
    
} 
