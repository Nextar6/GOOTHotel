package edu.spring.hotel.service;

import java.util.List;

import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface ProjectService {
	int create(ProjectVO vo);
	List<ProjectVO> read(PageCriteria criteria);
	ProjectVO read(int projectNo);
	int update(ProjectVO vo);
	int delete(int projectNo);
	int getTotalCounts();

}
