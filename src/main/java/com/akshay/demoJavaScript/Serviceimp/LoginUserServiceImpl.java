package com.akshay.demoJavaScript.Serviceimp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akshay.demoJavaScript.Model.LoginUser;
import com.akshay.demoJavaScript.Repo.LoginUserRepository;
import com.akshay.demoJavaScript.Service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService {
	
	@Autowired
	LoginUserRepository loginUserRepository;
	
	@Override
	public List<LoginUser> getAllLoginUser() {
		return loginUserRepository.findAll();
	}

	@Override
	public void saveLoginUser(LoginUser LoginUser) {
			
		loginUserRepository.save(LoginUser);
		
	}

	@Override
	public LoginUser getLoginUserById(int id) {
		
		Optional<LoginUser> optional=loginUserRepository.findById( id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new RuntimeException("LoginUser not found");
		}
	}

	@Override
	public void deleteLoginUserById(int id) {
		this.loginUserRepository.deleteById(id);
		
	}

	
/*	@Override
	public LoginUser getLoginUserById(int id, String password) {
		
		System.out.println(loginUserRepository.findByIdPassword(id,password));
		return loginUserRepository.findByIdPassword(id,password);
	}

	@Override
	public LoginUser getLoginUserByPhone(String phone, String password) {
		// TODO Auto-generated method stub
		return  loginUserRepository.findByPhonePassword(phone,password);
	} */

}

