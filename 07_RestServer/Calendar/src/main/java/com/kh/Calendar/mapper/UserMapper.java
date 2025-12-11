package com.kh.Calendar.mapper;

import com.kh.Calendar.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    List<User> getUsers();
}
