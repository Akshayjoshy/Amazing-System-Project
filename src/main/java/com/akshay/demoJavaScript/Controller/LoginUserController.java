package com.akshay.demoJavaScript.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.akshay.demoJavaScript.Model.LoginUser;
import com.akshay.demoJavaScript.Repo.LoginUserRepository;
import com.akshay.demoJavaScript.Service.LoginUserService;

@Controller
public class LoginUserController {
	
	@Autowired
	private LoginUserService loginUserService;
	
	@Autowired
	LoginUserRepository loginUserRepository;
	
	
	
	
	// display list of LoginUsers
    @GetMapping("/loginUser")
    public String viewHomePage(Model model) {
    	//List<LoginUser> loginUsers = loginUserService.getAllLoginUser();
		model.addAttribute("listLoginUsers", loginUserService.getAllLoginUser());
	    return "loginUser_list";
		
        
    }
	
	@GetMapping("/loginUser/showNewLoginUserForm")
	public String showNewLoginUserForm(Model model) {
		// create model attribute to bind form data
		LoginUser loginUser = new LoginUser();
		model.addAttribute("loginUser", loginUser);
		return "loginUser_new";
	}
	@PostMapping("/loginUser/saveLoginUser")
	public String saveLoginUser(@ModelAttribute("loginUser") LoginUser loginUser, Model model) {
		// save LoginUser to database
		
		LoginUser storedDetailzz= loginUserRepository.findByUsername(loginUser.getUsername());
		
		if(storedDetailzz!=null) {
			model.addAttribute("messages", "USERNAME ALREADYT EXSISTS.");
			return "loginUser_new";
		}
		loginUserService.saveLoginUser(loginUser);
		
		return "redirect:/loginUser";
	}
	
	@PostMapping("/loginUser/saveUser")
	public String saveUpdateLoginUser(@ModelAttribute("loginUser") LoginUser loginUser, Model model) {
		// save LoginUser to database
		
		loginUserService.saveLoginUser(loginUser);
		
		return "redirect:/loginUser";
	}
	@GetMapping("/loginUser/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model,LoginUser loginUser) {
		LoginUser loginUsers=loginUserService.getLoginUserById(id);
		// set LoginUser as a model attribute to pre-populate the form
			
		model.addAttribute("loginUser", loginUsers);
		
		return "loginUser_update";
	}
	@GetMapping("/loginUser/deleteLoginUser/{id}")
	public String deleteLoginUser(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.loginUserService.deleteLoginUserById(id);
		return "redirect:/loginUser";
	}
	
	//GRAPH
	@GetMapping("/chart")
    public String showChart(Model model) {
  
        model.addAttribute("userList", loginUserRepository.getCountByRole());
        return "Graph";
    }
}

