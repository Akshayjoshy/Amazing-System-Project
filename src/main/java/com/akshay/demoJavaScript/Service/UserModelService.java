package com.akshay.demoJavaScript.Service;

import java.util.List;

import com.akshay.demoJavaScript.Model.UserModel;

public interface UserModelService {
	
	List<UserModel> getAllLoginUser();
	void saveLoginUser(UserModel UserModel);
	UserModel getLoginUserById(int id);
	void deleteLoginUserById(int id);

}
