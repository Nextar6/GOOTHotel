package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ReservatVO;

public interface ReservatDAO {
	int insert(ReservatVO vo) throws Exception;
	int update(ReservatVO vo) throws Exception;
	int delete(int reservatNo);
	List<ReservatVO> select_by_reservatUserid(String reservatUserid);
	List<ReservatVO> select_by_hotelNo(int hotelNo);
	ReservatVO select_by_reservatNo(int reservatNo);
	List<ReservatVO> select_by_reservatUserid_hotelNo(int hotelNo, String reservatUserid);
}
