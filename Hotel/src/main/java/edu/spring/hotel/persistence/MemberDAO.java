package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.MemberVO;

public interface MemberDAO {
	int insert(MemberVO vo) throws Exception;
	String select_login(String memberUserid, String memberPassword);
	int update(MemberVO vo) throws Exception;
	int delete(String memberUserid);
	List<MemberVO> select_all(int memberNo);
	List<MemberVO> select_userid(String memberUserid);
	List<MemberVO> select_name(String memberName);
	String select_register_id_check(String memberUserid);
	String select_find_userid(String memberEmail, String memberPhone);
	String select_find_password(String memberUserid, String memberPhone);
	MemberVO select_profile(String memberUserid);
}
