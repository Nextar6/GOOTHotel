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

import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.persistence.PlayDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class PlayDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(PlayDAOTest.class);

	@Autowired
	private PlayDAO dao;
	
	@Test
	public void testDAO(){
//		testInsert();
//		testSelectAll();
		testOrderByPrice();
	}

	private void testOrderByPrice() {
		PageCriteria criteria = new PageCriteria(1, 5, null);
				
		List<PlayVO> list =dao.selectOrderByPrice(criteria);
		for(PlayVO vo : list) {
			logger.info(vo.toString());
			
		}
		
	} // end testOrderByPrice

	private void testSelectAll() {
		List<PlayVO> list = dao.select();
		for(PlayVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

	private void testInsert() {
//		PlayVO vo = new PlayVO(0, "t", "t", "t", "t",  0, null, "tt", "tt");
		int result = dao.insert(vo);
		if(result == 1) {
			logger.info("insert 성공");
		} else {
			logger.info("insert 실패");
		}
		
	}


	
}
