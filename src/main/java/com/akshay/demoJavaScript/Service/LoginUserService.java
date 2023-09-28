package com.akshay.demoJavaScript.Service;

import java.util.List;

import com.akshay.demoJavaScript.Model.LoginUser;

public interface LoginUserService {
	List<LoginUser> getAllLoginUser();
	void saveLoginUser(LoginUser LoginUser);
	LoginUser getLoginUserById(int id);
	void deleteLoginUserById(int id);

	/*LoginUser getLoginUserById(int id,String password);
	LoginUser getLoginUserByPhone(String phone,String password); */
	
}

