package org.dev.service;


import java.util.List;

import org.dev.entity.Course;

public interface CourseService extends BaseService<Course, String> {
	void addCourse(Course s) throws Exception;
	void deleteCourse(String sno) throws Exception;
	void updateCourse(Course s) throws Exception;
	Course getOneCourse(String sno) throws Exception;
	List<Course> getAllCourse() throws Exception;
}
