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
	public CourseDao<Course, String> courseDAO;

	@Override
	public void addCourse(Course s) throws Exception {
		courseDAO.save(s);
	}

	@Override
	public void deleteCourse(String sno) throws Exception {
		courseDAO.delete(sno);
	}

	@Override
	public void updateCourse(Course s) throws Exception {
		courseDAO.update(s);
	}

	@Override
	public Course getOneCourse(String sno) throws Exception {
		return courseDAO.get(sno);
	}

	@Override
	public List<Course> getAllCourse() throws Exception {
		return courseDAO.getAll(Course.class);
	}

}
