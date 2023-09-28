package com.akshay.demoJavaScript.Repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.akshay.demoJavaScript.Model.UserModel;

public interface LoginRepository extends JpaRepository<UserModel,Integer>{
	
	UserModel getByUsernameAndPassword(String username, String password);
	
	UserModel findByUsername(String username);
	
	
}
