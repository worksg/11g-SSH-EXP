package org.dev.service.impl;

import java.util.List;

import org.dev.dao.CourseDao;
import org.dev.entity.Course;
import org.dev.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl extends BaseServiceImpl<Course, String> implements CourseService {
	@Autowired
	public CourseDao courseDAO;

	@Override
	public void addCourse(Course c) throws Exception {
		courseDAO.save(c);
	}

	@Override
	public void deleteCourse(String cno) throws Exception {
		courseDAO.delete(cno);
	}

	@Override
	public void updateCourse(Course c) throws Exception {
		courseDAO.update(c);
	}

	@Override
	public Course getOneCourse(String cno) throws Exception {
		return courseDAO.get(cno);
	}

	@Override
	public List<Course> getAllCourse() throws Exception {
		return courseDAO.getAll(Course.class);
	}

}
