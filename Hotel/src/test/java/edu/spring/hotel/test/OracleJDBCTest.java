package edu.spring.hotel.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import oracle.jdbc.OracleDriver;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"}) 
@WebAppConfiguration
public class OracleJDBCTest {
	private static final Logger logger = 
			LoggerFactory.getLogger(OracleJDBCTest.class);
	
	private static final String URL =
			"jdbc:oracle:thin:@172.16.3.4:1521:xe";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";
	
	@Test
	public void testOracleConnect() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			logger.info("oracle test 연결 성공");
		} catch(SQLException e) {
			logger.error("oracle test 연결 실패" + e.getMessage());
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
