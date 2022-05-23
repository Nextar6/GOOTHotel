package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.ReservatVO;

@Repository
public class ReservatDAOImple implements ReservatDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(ReservatDAOImple.class);

	private static final String NAMESPACE =
			"edu.spring.hotel.ReservatMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(ReservatVO vo) throws Exception {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public int update(ReservatVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int reservatNo) {
		logger.info("delete() 호출 : reservatNo = " + reservatNo);
		return sqlSession.delete(NAMESPACE + ".delete", reservatNo);
	}

	@Override
	public List<ReservatVO> select_by_reservatUserid(String reservatUserid) {
		logger.info("select_by_reservatUserid() 호출 : reservatUserid = " + reservatUserid);
		return sqlSession.selectList(NAMESPACE + ".select_by_reservatUserid", reservatUserid);
	}

	@Override
	public List<ReservatVO> select_by_hotelNo(int hotelNo) {
		logger.info("select_by_hotelNo() 호출 : hotelNo = " + hotelNo);
		return sqlSession.selectList(NAMESPACE + ".select_by_hotelNo", hotelNo);
	}

	@Override
	public ReservatVO select_by_reservatNo(int reservatNo) {
		logger.info("select_by_reservatNo() 호출 : reservatNo = " + reservatNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_reservatNo", reservatNo);
	}

	@Override
	public List<ReservatVO> select_by_reservatUserid_hotelNo(int hotelNo, String reservatUserid) {
		logger.info("select_by_reservatUserid_hotelNo() 호출");
		logger.info("hotelNo = " + hotelNo + ", reservatUserid = " + reservatUserid);
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("reservatUserid", reservatUserid);
		args.put("hotelNo", hotelNo);
		return sqlSession.selectList(NAMESPACE + ".select_by_reservatUserid_hotelNo", args);
	}

}
