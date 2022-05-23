package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class HotelDAOImple implements HotelDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(HotelDAOImple.class);
	
	private static final String NAMESPACE =
			"edu.spring.hotel.HotelMapper";

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(HotelVO vo) throws Exception {
		logger.info("insert() 호출 : vo = " + vo);
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public HotelVO select_by_no(int hotelNo) {
		logger.info("select_by_no() 호출  : hotelNo = " + hotelNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_no", hotelNo);
	}
	
	@Override
	public List<HotelVO> select_all(PageCriteria criteria) {
		logger.info("select_all() 호출");
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int update(HotelVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int hotelNo) {
		logger.info("delete() 호출 : hotelNo = " + hotelNo);
		return sqlSession.delete(NAMESPACE + ".delete", hotelNo);
	}

	@Override
	public List<HotelVO> select_by_title(String hotelTitle) {
		logger.info("select_by_title() 호출 : hotelTitle = " + hotelTitle);
		hotelTitle = "%" + hotelTitle + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_title", hotelTitle);
	}

	@Override
	public int getTotalCount() {
		logger.info("getTotalCount() 호출");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

	@Override
	public List<HotelVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	

}
