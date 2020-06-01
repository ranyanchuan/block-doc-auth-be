package com.yyan.dao;

import com.yyan.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface UserRoleDao {

    void insertUserRole(UserRole userRole);


}
