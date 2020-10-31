package com.sumanth;

import java.util.Map;
import com.sumanth.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewMethodReturnValueHandler;

@Controller
public class GreetingController {

	@PostMapping(value = "/greeting", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String greeting(@RequestBody Map<String, Object> params,
			@RequestParam(name = "name") String nam, Model model) {
		Person p = new Person();
		System.out.println(params.get("employee2"));
		System.out.println(p.getFirstName());
		System.out.println(nam);
		model.addAttribute("name", nam);
		return "greeting";
	}
	
	@GetMapping(value="/hello")
	@ResponseBody
	public Person hello() {
		Person per = new Person();
		per.setFirstName("Sumanth");
		per.setLastName("Bodapati");
		per.setId(1302839);
		 
		return per;
	}
	@PostMapping(value = "/param", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public String customParam(@RequestBody Map<String, Object> params1, Model model,Params params) {
		
		System.out.println(params1);
		System.out.println(params.get("query"));
		return "greeting";
	}
	@GetMapping(value="/greet")
	public ModelAndView hello1() {
		Person per = new Person();
		per.setFirstName("Sumanth");
		per.setLastName("Bodapati");
		per.setId(1302839);
		 ModelAndView mv = new ModelAndView();
		 mv.setViewName("profile");
		 mv.addObject("person", per);
		return mv;
	}

}