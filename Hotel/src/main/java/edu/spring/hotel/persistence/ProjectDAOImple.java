package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class ProjectDAOImple implements ProjectDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(ProjectDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.ProjectMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ProjectVO vo) {
		logger.info("insert 호출");
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<ProjectVO> select() {
		logger.info("select 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public ProjectVO select(int projectNo) {
		logger.info("select() 호출 : projectNo = " + projectNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_project_no", projectNo);
	}

	@Override
	public int update(ProjectVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int projectNo) {
		logger.info("delete() 호출 : projectNo = " + projectNo);
		return sqlSession.delete(NAMESPACE + ".delete", projectNo);
	}

	@Override
	public List<ProjectVO> select(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

}
