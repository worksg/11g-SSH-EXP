package org.dev.service;

import java.util.List;

import org.dev.entity.Score;

public interface ScoreService extends BaseService<Score, String> {
	void addScore(Score s) throws Exception;
	void deleteScore(String sno,String cno) throws Exception;
	void updateScore(Score s) throws Exception;
	Score getOneScore(String sno,String cno) throws Exception;
	List<Score> getAllScore() throws Exception;
}
