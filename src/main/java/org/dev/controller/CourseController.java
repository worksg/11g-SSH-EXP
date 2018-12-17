package org.dev.controller;

import javax.validation.Valid;

import org.dev.entity.Course;
import org.dev.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javassist.NotFoundException;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	public CourseService courseService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String CourseIndexPage(ModelMap model) throws Exception {
		model.addAttribute("message", courseService.getAllCourse());
		return "courselist";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchCourse() {
		return "searchCourse";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllCourse(@RequestParam(value = "id", required = false) String id, ModelMap model)
			throws Exception {
		if (id == null) {
			model.addAttribute("message", courseService.getAllCourse());
		} else {
			Course item = courseService.getOneCourse(id);
			if (item != null) {
				model.addAttribute("item", item);
				return "courseTable";
			}else {
				throw new NotFoundException("");
			}
		}
		return "courselist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addCourse(@Valid @ModelAttribute("Course") Course course) throws Exception {
		courseService.addCourse(course);
		ModelAndView mav = new ModelAndView("redirect:/course");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addCoursePage() throws Exception {
		ModelAndView mav = new ModelAndView("addCourse");
		mav.addObject("Course", new Course());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateCourse(@Valid @ModelAttribute("Course") Course course) throws Exception {
		courseService.updateCourse(course);
		ModelAndView mav = new ModelAndView("redirect:/course");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateCoursePage(@RequestParam(value = "id") String id) throws Exception {
		ModelAndView mav = new ModelAndView("updateCourse");
		mav.addObject("Course", courseService.getOneCourse(id));
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteCourse(@RequestParam(value = "id") String id) throws Exception {
		courseService.deleteCourse(id);
		ModelAndView mav = new ModelAndView("redirect:/course");
		return mav;
	}
}
