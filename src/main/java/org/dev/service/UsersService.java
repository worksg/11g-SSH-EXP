package org.dev.service;

import java.util.List;

import org.dev.entity.Student;

public interface UsersService extends BaseService<Student, String> {
	void addStudent(Student s) throws Exception;
	void deleteStudent(String sno) throws Exception;
	void updateStudent(Student s) throws Exception;
	Student getOneStudent(String sno) throws Exception;
	List<Student> getAllStudent() throws Exception;
}
