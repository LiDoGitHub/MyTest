package com.gjyl.appserver.service;

import com.gjyl.appserver.pojo.AppUser;


public interface UserService {
	
	public AppUser GetUserById(String id);
	
	public AppUser GetUserByPhone(String phone);

	public Boolean addUser(AppUser user);

	public Boolean updateUser(AppUser user);

	public AppUser umLogin(String uid);
}
