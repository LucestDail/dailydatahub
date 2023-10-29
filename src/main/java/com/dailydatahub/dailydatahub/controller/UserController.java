package com.dailydatahub.dailydatahub.controller;

import java.util.Optional;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dailydatahub.dailydatahub.domain.Team;
import com.dailydatahub.dailydatahub.domain.User;
import com.dailydatahub.dailydatahub.repository.UserRepositorty;
import com.dailydatahub.dailydatahub.service.UserService;
import com.nimbusds.jose.shaded.gson.JsonObject;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@CrossOrigin
@RestController
@SuppressWarnings({"unchecked", "unused"})
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	/**
	 * 사용자 로그인 확인
	 * @param userDto
	 * @param request
	 * @return
	 */
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public JSONObject postLoginUser(@RequestBody User userDto, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		Optional<User> user = userService.selectUserDetail(userDto);
		if(user.isPresent()){
			jsonObject.put("error", false);
			jsonObject.put("user", user.get());
			userService.createUserSession(userDto, request);
		}else{
			jsonObject.put("error", true);
			jsonObject.put("errorReason", "일치하는 사용자 정보가 없습니다.");
		}
		return jsonObject;
	}

	/**
	 * 사용자를 생성합니다.
	 * @param userDto
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/requestRegister", method = RequestMethod.POST)
	public JSONObject requestRegister(@RequestBody User userDto, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		Optional<User> user = userService.selectUserDetail(userDto);
		if(user.isPresent()){
			jsonObject.put("error", true);
			jsonObject.put("errorReason", "해당 ID 는 이미 사용중입니다.");
		}else{
			User saveUser = userService.saveUser(userDto);
			if(saveUser == null){
				jsonObject.put("error", false);
				jsonObject.put("errorReason", "사용자 생성에 실패했습니다.");
			}else{
				jsonObject.put("error", false);
				jsonObject.put("user", saveUser);
			}
		}
		return jsonObject;
	}

	/**
	 * 사용자의 비밀번호 정보를 초기화한다.
	 * @param userDto
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/initPassword", method = RequestMethod.POST)
	public JSONObject initPassword(@RequestBody User userDto, HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		Optional<User> user = userService.selectUserByInfo(userDto);
		if(!user.isPresent()){
			jsonObject.put("error", true);
			jsonObject.put("errorReason", "해당하는 유저 정보가 존재하지 않습니다.");
		}else{
			User saveUser = userService.initUserPassword(userDto);
			if(saveUser == null || !user.get().getPassword().equals(saveUser.getPassword())){
				jsonObject.put("error", false);
				jsonObject.put("errorReason", "사용자 비밀번호 초기화에 실패했습니다.");
			}else{
				jsonObject.put("error", false);
				jsonObject.put("user", saveUser);
			}
		}
		return jsonObject;
	}

	/**
	 * 사용자를 로그아웃 처리 및 세션 정보를 제거한다.
	 * @param request
	 * @return
	 */
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		userService.logoutUser(request);
		return new ModelAndView("main/login.html");
	}
}
