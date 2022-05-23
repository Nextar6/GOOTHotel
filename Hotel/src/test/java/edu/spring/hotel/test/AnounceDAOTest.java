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

import edu.spring.hotel.domain.AnounceVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.persistence.AnounceDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class AnounceDAOTest {
	private static final Logger logger =
			LoggerFactory.getLogger(AnounceDAOTest.class);

	@Autowired
	private AnounceDAO dao;
	
	@Test
	public void testDAO() {
//		testInsert();
//		testSelectAll();
//		testSelectPaging();
//		testSearchByTitleOrContent();
//		testSearchWriter();
//		testselectByWriterCount();
		testSearchByTitleOrContentCount();
	}


	private void testSearchByTitleOrContentCount() {
		PageCriteria criteria = new PageCriteria(1, 2, "2");
		List<AnounceVO> list = dao.searchByTitleOrContent(criteria);
		for(AnounceVO vo : list ) {
			logger.info(vo.toString());
		}
		String keyword = "2";
		System.out.println();
		System.out.println("페이지 총 갯수 : " + dao.searchByTitleOrContentCount(keyword));
	}


	private void testselectByWriterCount() {
		PageCriteria criteria = new PageCriteria(1, 2, "2");
		List<AnounceVO> list = dao.searchByWriter(criteria);
		for(AnounceVO vo : list ) {
			logger.info(vo.toString());
		}
		String keyword = "2";
		System.out.println();
		System.out.println("페이지 총 갯수 : " + dao.searchByWriterCount(keyword));
		
		
	}


	private void testSearchWriter() {
		PageCriteria criteria = new PageCriteria(1, 2, "2");
		List<AnounceVO> list = dao.searchByWriter(criteria);
		for(AnounceVO vo : list ) {
			logger.info(vo.toString());
		}
				
	}

	private void testSearchByTitleOrContent() {
		PageCriteria criteria = new PageCriteria(1, 2, "2");
		List<AnounceVO> list = dao.searchByTitleOrContent(criteria);
		for(AnounceVO vo : list) {
			logger.info(vo.toString());
		}
		
	}

//	private void testSelectPaging() {
//		PageCriteria criteria = new PageCriteria(1, 3);
//
//		List<AnounceVO> list = dao.select(criteria);
//		for(AnounceVO vo : list) {
//			logger.info(vo.toString());
//		}
//		
//	}

	private void testInsert() {
		AnounceVO vo = new AnounceVO(0, "1", "t", "ad", null);
		int result = dao.insert(vo);
		if(result == 1) {
			logger.info("insert 성공");
		} else {
			logger.info("insert 실패");
		}
	} // end testInsert()
	
	private void testSelectAll() {
		List<AnounceVO> list = dao.select();
		for(AnounceVO vo : list) {
			logger.info(vo.toString());
		}
	}
}


