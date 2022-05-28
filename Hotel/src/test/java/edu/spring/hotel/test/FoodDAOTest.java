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

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.persistence.FoodDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@WebAppConfiguration
public class FoodDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(InqueryReplyDAOTest.class);

	
	@Autowired
	private FoodDAO dao;
	
	@Test
	public void foodTestDAO() {
//		foodInsertTest();
//		foodRecommendkeyword();
		foodSearchKeyword();
	}

	private void foodSearchKeyword() {
		String keyword = "2";
		List<FoodVO> list = dao.searchKeyword(keyword);
		for(FoodVO vo : list) {
			logger.info(vo.toString());
		}
		
		
		
	}

	private void foodRecommendkeyword() {
		String keyword = "2";
		List<FoodVO> list = dao.recommendKeyword(keyword);
		for(FoodVO vo  : list) {
			logger.info(vo.toString());
		}
		
	} // end foodSelectRecommend

	private void foodInsertTest() {
		FoodVO vo = new FoodVO(0, "제목", "내용", "그림", "예약날짜", "아이디", 14, 0, 0, null);
			
		int result = dao.insert(vo);
		if(result == 1 ) {
			logger.info("성공");
		} else {
			
			logger.info("실패");
		}
	} // TODO 시퀀스 트리거,
}
