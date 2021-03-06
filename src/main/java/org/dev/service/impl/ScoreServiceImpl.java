package org.dev.service.impl;

import java.util.List;

import org.dev.dao.ScoreDao;
import org.dev.entity.Score;
import org.dev.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceImpl extends BaseServiceImpl<Score, String> implements ScoreService {
	@Autowired
	public ScoreDao scoreDAO;

	@Override
	public void addScore(Score s) throws Exception {
		scoreDAO.save(s);
	}

	@Override
	public void deleteScore(String sno, String cno) throws Exception {
		scoreDAO.delete(sno, cno);
	}

	@Override
	public void updateScore(Score s) throws Exception {
		scoreDAO.update(s);
	}

	@Override
	public Score getOneScore(String sno, String cno) throws Exception {
		return scoreDAO.get(sno, cno);
	}

	@Override
	public List<Score> getAllScore() throws Exception {
		return scoreDAO.getAll(Score.class);
	}

}
