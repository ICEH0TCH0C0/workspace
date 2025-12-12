package com.kh.Calendar.service;

import com.kh.Calendar.entity.User;
import com.kh.Calendar.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Override
    public User getUsers() {
        return userMapper.getUsers();
    }
}
