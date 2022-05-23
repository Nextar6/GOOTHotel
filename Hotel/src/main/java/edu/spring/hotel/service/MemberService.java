package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.MemberVO;

public interface MemberService {
	int create(MemberVO vo) throws Exception;
	String read_login(String memberUserid, String memberPassword);
	int update(MemberVO vo) throws Exception;
	int delete(String memberUserid);
	List<MemberVO> read_all(int memberNo);
	List<MemberVO> read_userid(String memberUserid);
	List<MemberVO> read_name(String memberName);
	String read_register_id_check(String memberUserid);
	String read_find_userid(String memberEmail, String memberPhone);
	String read_find_password(String memberUserid, String memberPhone);
	MemberVO read_profile(String memberUserid);
}
