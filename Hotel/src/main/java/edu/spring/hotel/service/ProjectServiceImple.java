package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.ProjectDAO;

@Service
public class ProjectServiceImple implements ProjectService{

	private static final Logger logger =
			LoggerFactory.getLogger(ProjectServiceImple.class);
	
	@Autowired
	private ProjectDAO dao;
	
	@Override
	public int create(ProjectVO vo) {
		logger.info("create() 호출 : vo = " + vo.toString());
		return dao.insert(vo);
	}

	@Override
	public List<ProjectVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : start = " + criteria.getStart());
		logger.info("read() 호출 : end = " + criteria.getEnd());
		return dao.select(criteria);
	}

	@Override
	public ProjectVO read(int projectNo) {
		logger.info("read() 호출 : projectNo = " + projectNo);
		return dao.select(projectNo);
	}

	@Override
	public int update(ProjectVO vo) {
		logger.info("update() 호출 : vo");
		return dao.update(vo);
	}

	@Override
	public int delete(int projectNo) {
		logger.info("delete() 호출 : projectNo = " + projectNo);

		return dao.delete(projectNo);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts() 호출");
		return dao.getTotalCounts();
	}
	

}
