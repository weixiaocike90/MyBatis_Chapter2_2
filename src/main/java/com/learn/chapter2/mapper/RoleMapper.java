package com.learn.chapter2.mapper;

import com.learn.chapter2.pojo.Role;

public interface RoleMapper {

	Role getRole(int id );
	
	int insertRole(Role role);
}
