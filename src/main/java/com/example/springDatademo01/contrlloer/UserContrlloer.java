package com.example.springDatademo01.contrlloer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springDatademo01.entity.User;
import com.example.springDatademo01.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserContrlloer {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/login")
	public String dologin(){
		return "login";
	}
	@RequestMapping(value="register")
	public String doregister(){
		return "register";
	}
	
	@RequestMapping(value="/dologin")
	public String login(User user, Model model){
		System.out.println("user:" + user);
		User user1 = userService.selectUser(user) ;
		System.out.println(user1);
		if(user1 == null){
			model.addAttribute("msg", "用户名或者密码错误！！");
			return "fail";
		}else {
			model.addAttribute("msg", "登录成功！！！");
			return "success";
		}
		
	}
	
	@RequestMapping(value="/doregister")
	public String register(User user, Model model){
		System.out.println("user:" + user);
		int user2 = userService.insertUser(user) ;
		System.out.println(user2);
		if(user2 != 0 ){
			model.addAttribute("msg", "注册成功");
			return "fail";
		}else {
			model.addAttribute("msg", "请输入正确的用户名或密码！！！");
			return "success";
		}
		
	}
	
	
	

}
