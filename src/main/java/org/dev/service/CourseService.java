package org.dev.service;


import java.util.List;

import org.dev.entity.Course;

public interface CourseService extends BaseService<Course, String> {
	void addCourse(Course c) throws Exception;
	void deleteCourse(String cno) throws Exception;
	void updateCourse(Course c) throws Exception;
	Course getOneCourse(String cno) throws Exception;
	List<Course> getAllCourse() throws Exception;
}
