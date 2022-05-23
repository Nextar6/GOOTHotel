package edu.spring.hotel.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })
@WebAppConfiguration
public class DataSourceTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	
	@Test
	public void testDataSource( ) {
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			logger.info("DataSource 연결 성공");
		} catch(SQLException e) {
			logger.info("DataSource 연결 실패 : " + e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				logger.info("DataSource 연결 반환 성공");
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}
