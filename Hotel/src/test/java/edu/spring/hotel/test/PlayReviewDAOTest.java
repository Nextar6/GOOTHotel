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

import edu.spring.hotel.domain.PlayReviewVO;
import edu.spring.hotel.persistence.PlayReviewDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class PlayReviewDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(PlayReviewDAOTest.class);
	
	@Autowired
	private PlayReviewDAO dao;
	
	@Test
	public void testDAO() {
		testInsert();
//		testSelectByPlayNo();
	}

	private void testSelectByPlayNo() {
		List<PlayReviewVO> list = dao.select(12);
		for(PlayReviewVO vo : list) {
			logger.info(vo.toString());
		}
		
		
	}

	private void testInsert() {
		PlayReviewVO vo = new PlayReviewVO(0, 1, "제목", "내용", "작성자", null, 12);
		int result = dao.insert(vo);
		if(result == 1) {
			logger.info("insert 성공");
		} else {
			logger.info("insert 실패");
		}
		
	}


}
