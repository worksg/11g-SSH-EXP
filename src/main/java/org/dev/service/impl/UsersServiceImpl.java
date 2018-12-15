package org.dev.service.impl;

import java.util.List;

import org.dev.dao.UsersDao;
import org.dev.entity.Student;
import org.dev.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl extends BaseServiceImpl<Student, String> implements UsersService {

	@Autowired
	public UsersDao usersDAO;

	@Override
	public void addStudent(Student s) throws Exception {
		usersDAO.save(s);
	}

	@Override
	public void deleteStudent(String sno) throws Exception {
		usersDAO.delete(sno);
	}

	@Override
	public void updateStudent(Student s) throws Exception {
		usersDAO.update(s);
	}

	@Override
	public Student getOneStudent(String sno) throws Exception {
		return usersDAO.get(sno);
	}

	@Override
	public List<Student> getAllStudent() throws Exception {
		return usersDAO.getAll(Student.class);
	}

}
