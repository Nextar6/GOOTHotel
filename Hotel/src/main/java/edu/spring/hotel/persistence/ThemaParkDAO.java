package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ThemaparkVO;

public interface ThemaParkDAO {
	int insert(ThemaparkVO vo);
	List<ThemaparkVO> select();
	ThemaparkVO select(int themaparkNo);
	
	
	
		


}
