package edu.spring.hotel.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.spring.hotel.domain.AnounceVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@WebAppConfiguration
public class SqlSessionFactoryTest {
	private static final Logger logger =
			LoggerFactory.getLogger(SqlSessionFactoryTest.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.BoardMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Test
	public void testInsert() {
		AnounceVO vo = new AnounceVO(0, "test", "test", "yang", null);
		int result = sqlSession.insert(NAMESPACE + ".insert", vo);
		// .insert : mapper.xml 의 id
		logger.info(result + "행 삽입");
	}

}
