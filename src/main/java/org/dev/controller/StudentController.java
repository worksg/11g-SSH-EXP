package org.dev.controller;

import javax.validation.Valid;

import org.dev.entity.Student;
import org.dev.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	public UsersService usersService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllStudent(@RequestParam(value = "id", required = false) String id, ModelMap model)
			throws Exception {
		if (id == null) {
			model.addAttribute("message", usersService.getAllStudent());
		} else {
			model.addAttribute("message", usersService.getOneStudent(id));
		}
		return "studentlist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute("Student") Student student) throws Exception {
		usersService.addStudent(student);
		ModelAndView mav = new ModelAndView("studentlist");
		mav.addObject("message", usersService.getAllStudent());
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addStudentPage() throws Exception {
		ModelAndView mav = new ModelAndView("addStudent");
		mav.addObject("Student", new Student());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@Valid @ModelAttribute("Student") Student student) throws Exception {
		usersService.updateStudent(student);
		ModelAndView mav = new ModelAndView("studentlist");
		mav.addObject("message", usersService.getAllStudent());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateStudentPage(@RequestParam(value = "id") String id) throws Exception {
		ModelAndView mav = new ModelAndView("updateStudent");
		mav.addObject("Student", usersService.getOneStudent(id));
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam(value = "id") String id) throws Exception {
		usersService.deleteStudent(id);
		ModelAndView mav = new ModelAndView("studentlist");
		mav.addObject("message", usersService.getAllStudent());
		return mav;
	}
}
