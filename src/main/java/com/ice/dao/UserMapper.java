package com.ice.dao;

import com.ice.vo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User selectUserById(@Param("userId") long userId);
}
