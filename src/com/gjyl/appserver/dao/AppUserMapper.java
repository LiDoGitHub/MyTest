package com.gjyl.appserver.dao;

import com.gjyl.appserver.pojo.AppUser;

public interface AppUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(AppUser record);

    int insertSelective(AppUser record);

    //通过ID获取用户信息
    AppUser getUserById(String userid);
    
    //根据手机号,获取用户信息
    AppUser getUserByPhone(String phone);

    //新增用户
	int addUser(AppUser user);
	//更新用户
	int updateUserByPhone(AppUser user);

	//友盟登录
	AppUser umLogin(String uid);
}