package com.example.JspBoot;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.po.User;

@Controller
public class WelcomeController {

	@Value("${application.message}")
	private String message;

	@Autowired
	private User user;

	@RequestMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		System.out.println(this.message);
		return "welcome";
	}

	@RequestMapping("/user")
	@ResponseBody
	public Map<String, Object> getUser() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (user != null) {
			map.put("name", user.getName());
			map.put("age", user.getAge());
		}
		return map;

	}
}
