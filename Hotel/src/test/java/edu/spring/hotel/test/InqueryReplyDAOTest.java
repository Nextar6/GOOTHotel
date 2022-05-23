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

import edu.spring.hotel.domain.InqueryReplyVO;
import edu.spring.hotel.persistence.InqueryReplyDAO;


	@RunWith(SpringJUnit4ClassRunner.class)
	@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"})
	@WebAppConfiguration
	public class InqueryReplyDAOTest {
		private static final Logger logger =
				LoggerFactory.getLogger(InqueryReplyDAOTest.class);

		@Autowired
		private InqueryReplyDAO dao;
		
		@Test
		public void testDAO() {
//			testInsert();
			testselectAll();
		}

		private void testselectAll() {
			List<InqueryReplyVO> list = dao.select(2);
			for(InqueryReplyVO vo : list) {
				logger.info(vo.toString());
			}
			
		}

		private void testInsert() {
			InqueryReplyVO vo = new InqueryReplyVO(0, 1, "네", "manager", null);
			int result = dao.insert(vo);
			if(result == 1) {
				logger.info("insert 성공");
			} else {
				logger.info("insert 실패");
			}
		} // end testInsert()
		
		
}
