package org.dev.controller;

import org.dev.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
    public UsersService usersService;

	@RequestMapping(value="/list",method = RequestMethod.GET)
	public String listAllStudent(ModelMap model) throws Exception {
        model.addAttribute("message", usersService.getAllStudent());
        return "studentlist";
	}
}
