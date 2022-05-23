package edu.spring.hotel.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.MemberVO;

@Repository
public class MemberDAOImple implements MemberDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(MemberDAOImple.class);

	private static final String NAMESPACE =
			"edu.spring.hotel.MemberMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(MemberVO vo) {
		logger.info("insert() 호출 : vo = " + vo.toString());
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public String select_login(String memberUserid, String memberPassword) {
		logger.info("select_login() 호출 ");
		logger.info("memberUserid = " + memberUserid + ", memberPassword = " + memberPassword);
		Map<String, String> args = new HashMap<String, String>();
		args.put("memberUserid", memberUserid);
		args.put("memberPassword", memberPassword);
		return sqlSession.selectOne(NAMESPACE + ".select_login", args);
	}

	@Override
	public int update(MemberVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(String memberUserid) {
		logger.info("delete() 호출 : memberUserid = " + memberUserid);
		return sqlSession.delete(NAMESPACE + ".delete", memberUserid);
	}

	@Override
	public List<MemberVO> select_all(int memberNo) {
		logger.info("select_all() 호출 : memberNo = " + memberNo);
		return sqlSession.selectList(NAMESPACE + "select_all", memberNo);
	}

	@Override
	public List<MemberVO> select_userid(String memberUserid) {
		logger.info("select_userid() 호출 : memberUserid = " + memberUserid);
		memberUserid = "%" + memberUserid + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_userid", memberUserid);
	}

	@Override
	public List<MemberVO> select_name(String memberName) {
		logger.info("select_name() 호출 : memberName = " + memberName);
		memberName = "%" + memberName + "%";
		return sqlSession.selectList(NAMESPACE + ".select_by_name", memberName);
	}

	@Override
	public String select_register_id_check(String memberUserid) {
		logger.info("select_register_id_check() 호출 : memberUserid = " + memberUserid);
		return sqlSession.selectOne(NAMESPACE + ".select_register_id_check", memberUserid);
	}

	@Override
	public String select_find_userid(String memberEmail, String memberPhone) {
		logger.info("select_find_userid() 호출 : memberEmail = " + memberEmail + ", memberPhone = " + memberPhone);
		Map<String, String> args = new HashMap<String, String>();
		args.put("memberEmail", memberEmail);
		args.put("memberPhone", memberPhone);
		return sqlSession.selectOne(NAMESPACE + ".select_find_userid", args);
	}

	@Override
	public String select_find_password(String memberUserid, String memberPhone) {
		logger.info("select_find_password() 호출 : memberUserid = " + memberUserid + ", memberPhone = " + memberPhone);
		Map<String, String> args = new HashMap<String, String>();
		args.put("memberUserid", memberUserid);
		args.put("memberPhone", memberPhone);
		return sqlSession.selectOne(NAMESPACE + ".select_find_password", args);
	}

	@Override
	public MemberVO select_profile(String memberUserid) {
		logger.info("select_profile() 호출 : memberUserid = " + memberUserid);
		return sqlSession.selectOne(NAMESPACE + ".select_profile", memberUserid);
	}
	
	
}
