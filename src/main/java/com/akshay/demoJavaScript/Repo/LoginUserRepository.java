package com.akshay.demoJavaScript.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akshay.demoJavaScript.Model.LoginUser;



public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {

/*	@Query("SELECT c FROM LoginUser AS c WHERE c.luId = ?1 and c.luPassword=?2")
	LoginUser findByIdPassword(int id,String password);
	
	@Query("SELECT c FROM LoginUser AS c WHERE c.luPhone = ?1 and c.luPassword=?2")
	LoginUser findByPhonePassword(String phone,String password);; */
	
	@Query(value="SELECT role, count(*) FROM login_user GROUP BY role",
			nativeQuery=true)
	List<Object> getCountByRole();
	
	//LoginUser findByEmail(String email);
	
	LoginUser findByUsername(String username);
	

}

