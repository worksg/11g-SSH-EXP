package org.dev.dao;

import org.dev.entity.Score;

public interface ScoreDao extends BaseDao<Score, String> {

	Score get(String sno, String cno);
	void delete(String sno, String cno);
}
