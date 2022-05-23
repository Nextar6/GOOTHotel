package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.MemberVO;
import edu.spring.hotel.persistence.MemberDAO;

@Service
public class MemberServiceImple implements MemberService {
	private static final Logger logger =
			LoggerFactory.getLogger(MemberServiceImple.class);
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Transactional
	@Override
	public int create(MemberVO vo) throws Exception{
		logger.info("create() 호출 : vo = " + vo.toString());
		return memberDAO.insert(vo);
	}

	@Override
	public String read_login(String memberUserid, String memberPassword) {
		logger.info("read_login() 호출 ");
		logger.info("memberUserid = " + memberUserid + ", memberPassword = " + memberPassword);
		return memberDAO.select_login(memberUserid, memberPassword);
	}

	@Override
	public int update(MemberVO vo) throws Exception {
		logger.info("update() 호출 : vo = " + vo.toString());
		return memberDAO.update(vo);
	}

	@Override
	public int delete(String memberUserid) {
		logger.info("delete() 호출 : memberUserid = " + memberUserid);
		return memberDAO.delete(memberUserid);
	}

	@Override
	public List<MemberVO> read_all(int memberNo) {
		logger.info("read_all() 호출 : memberNo = " + memberNo);
		return memberDAO.select_all(memberNo);
	}

	@Override
	public List<MemberVO> read_userid(String memberUserid) {
		logger.info("read_userid() 호출 : memberUserid = " + memberUserid);
		return memberDAO.select_userid(memberUserid);
	}

	@Override
	public List<MemberVO> read_name(String memberName) {
		logger.info("read_name() 호출 : memberName = " + memberName);
		return memberDAO.select_name(memberName);
	}

	@Override
	public String read_register_id_check(String memberUserid) {
		logger.info("read_register_id_check() 호출 : memberUserid = " + memberUserid);
		return memberDAO.select_register_id_check(memberUserid);
	}

	@Override
	public String read_find_userid(String memberEmail, String memberPhone) {
		logger.info("read_find_userid() 호출 : memberEmail = " + memberEmail + ", memberPhone = " + memberPhone);
		return memberDAO.select_find_userid(memberEmail, memberPhone);
	}

	@Override
	public String read_find_password(String memberUserid, String memberPhone) {
		logger.info("read_find_password() 호출 : memberUserid = " + memberUserid + ", memberPhone = " + memberPhone);
		return memberDAO.select_find_password(memberUserid, memberPhone);
	}

	@Override
	public MemberVO read_profile(String memberUserid) {
		logger.info("read_profile() 호출 : memeberUserid = " + memberUserid);
		return memberDAO.select_profile(memberUserid);
	}

}