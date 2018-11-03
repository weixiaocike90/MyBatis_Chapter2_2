package com.learn.chapter2.main;

import org.apache.ibatis.session.SqlSession;

import com.learn.chapter2.mapper.RoleMapper;
import com.learn.chapter2.pojo.Role;
import com.learn.chapter2.util.SqlSessionFactoryUtil;

public class Chapter2Main {

	public static void main(String[] args) {
		SqlSession sqlSession = SqlSessionFactoryUtil.openSqlSession();
		try {
			RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
			Role role = roleMapper.getRole(1);
			Role role2 = new Role();
			role2.setNote("shandong");
			role2.setRoleName("shandong");
			roleMapper.insertRole(role2);
			sqlSession.commit();
			System.out.println(role.getNote());
		} catch (Exception e) {
			
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
