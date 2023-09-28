package com.akshay.demoJavaScript.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.akshay.demoJavaScript.Model.UserModel;
import com.akshay.demoJavaScript.Repo.LoginRepository;
import com.akshay.demoJavaScript.Service.UserModelService;

@Controller
public class LoginController {
	
	@Autowired
	private UserModelService userModelService;
	@Autowired
	private LoginRepository loginRepository;
	
	@GetMapping("/addExcel")
	public String addExcel(Model model) {
		//ExcelData excelData = new ExcelData();
		//model.addAttribute("excelData", excelData);
		return "excel";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		UserModel loginModel=new UserModel();
		model.addAttribute("loginModel", loginModel);
		return "Login";
				
	}
	
	@GetMapping("/loginHome")
	public String loginHome(Model model) {
		return "Home";
				
	}
	
	@GetMapping("/loginAdmin")
	public String loginAdmin(Model model) {
		model.addAttribute("adminlist",userModelService.getAllLoginUser());
		return "Adminlist";
				
	}
	
	@GetMapping("/loginAdmin/addAdmin")
	public String addAdmin(Model model) {
		UserModel userModel=new UserModel();
		model.addAttribute("userModel", userModel);
		return "AddAdmin";
	}
	
	@PostMapping("/loginAdmin/saveAdmin")
	public String saveAdmin(@ModelAttribute("userModel") UserModel userModel, Model model) {
	
	UserModel storedDetailz= loginRepository.findByUsername(userModel.getUsername());
		
		if(storedDetailz!=null) {
			
			model.addAttribute("message", "USERNAME ALREADYT EXSISTS.");
			
			return "AddAdmin";
		} 
		userModelService.saveLoginUser(userModel);
		return "redirect:/loginAdmin";
		}
	
		
	@PostMapping("/home")
	public String homeList(@RequestParam String username,@RequestParam String password) {
		
		UserModel loginModel1=loginRepository.getByUsernameAndPassword(username, password);
		
		if(loginModel1!=null) {
			System.out.println("user found");
			return "Home";
		}else {
			return "Error";
		}
		
	}
	
	
	@PostMapping("/loginAdmin/saveUser")
	public String saveUpdatedAdmin(@ModelAttribute("user_model") UserModel userModel, Model model) {
	
	userModelService.saveLoginUser(userModel);
		return "redirect:/loginAdmin";
		}
	
	
	@GetMapping("/loginAdmin/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") int id, Model model,UserModel userModel) {
		UserModel userModels=userModelService.getLoginUserById(id);
		// set LoginUser as a model attribute to pre-populate the form
			
		model.addAttribute("userModel",userModels);
		
		return "Adminupdate";
	}
	
	@GetMapping("/loginAdmin/deleteLoginUser/{id}")
	public String deleteLoginUser(@PathVariable (value = "id") int id) {
		
		// call delete employee method 
		this.userModelService.deleteLoginUserById(id);
		return "redirect:/loginAdmin";
	}
} 
