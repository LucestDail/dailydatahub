package com.dailydatahub.dailydatahub.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dailydatahub.dailydatahub.domain.Team;
import com.dailydatahub.dailydatahub.domain.User;
import com.dailydatahub.dailydatahub.repository.UserRepositorty;
import com.dailydatahub.dailydatahub.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    final UserRepositorty userRepository;

    @Override
    public Optional<User> selectUserDetail(User userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        return userOptional;
    }

    @Override
    public List<User> selectUserList(Long teamSeq) {
        User user = User.builder().build();
        List<User> listUser = new ArrayList<>();
        listUser.add(user);
        return listUser;
    }

    @Override
    public User saveUser(User userDto) {
        User user = User.builder()
                    .id(userDto.getId())
                    .password(userDto.getPassword())
                    .email(userDto.getEmail())
                    .name(userDto.getId())
                    .info("안녕하세요")
                    .build();
        return userRepository.save(user.toEntity(user));
    }

    @Override
    public Optional<User> selectUserByInfo(User userDto) {
        return userRepository.findByIdAndNameAndEmail(userDto.getId(), userDto.getName(), userDto.getEmail());
    }

    @Override
    public User initUserPassword(User userDto) {
        Optional<User> userOptional = userRepository.findById(userDto.getId());
        User findUser = userOptional.get();
        findUser.setPassword(findUser.getId());
        return userRepository.save(findUser);
    }

    @Override
    public void createUserSession(User userDto, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userDto;
        session.setAttribute("user", user);
    }

    @Override
    public void logoutUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
		session.invalidate();
    }
    
}
