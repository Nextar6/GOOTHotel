package edu.spring.hotel.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.persistence.EventDAO;
import edu.spring.hotel.persistence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class EventDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(EventDAOTest.class);
	
	
	@Autowired
	private ProjectDAO dao;
	
	@Test
	public void testDAO() {
//		testInsert();
//		testSelectAll();
//		testSelectAllProject();
	}

	private void testSelectAllProject() {
		List<ProjectVO> list = dao.select();
		for(ProjectVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testSelectAll() {
		List<EventVO> list = dao.select();
		for(EventVO vo : list) {
			logger.info(vo.toString());
		}
		
		
	}

	private void testInsert() {
		EventVO vo = new EventVO(0, "eventTest", "eventTest", "ad", null);
		int result = dao.insert(vo);
		if(result == 1) {
			logger.info("insert 성공");
		} else {
			logger.info("insert 실패");
		}
	} // end testInsert()
}
