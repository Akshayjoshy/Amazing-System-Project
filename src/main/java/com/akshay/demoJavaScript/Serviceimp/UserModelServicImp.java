package com.akshay.demoJavaScript.Serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.akshay.demoJavaScript.Model.UserModel;
import com.akshay.demoJavaScript.Repo.LoginRepository;
import com.akshay.demoJavaScript.Service.UserModelService;

@Service
public class UserModelServicImp implements UserModelService {
	
	@Autowired
	private LoginRepository loginRepository;

	@Override
	public List<UserModel> getAllLoginUser() {
		// TODO Auto-generated method stub
		return loginRepository.findAll();
	}

	@Override
	public void saveLoginUser(UserModel UserModel) {
		// TODO Auto-generated method stub
		loginRepository.save(UserModel);
	}

	@Override
	public UserModel getLoginUserById(int id) {
		Optional<UserModel> optional=loginRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("LoginUser not found");
		}
	
	}

	@Override
	public void deleteLoginUserById(int id) {
		this.loginRepository.deleteById(id);
		
	}

}
