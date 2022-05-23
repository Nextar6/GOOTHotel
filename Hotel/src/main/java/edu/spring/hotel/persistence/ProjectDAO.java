package edu.spring.hotel.persistence;

import java.util.List;

import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.pageutil.PageCriteria;

public interface ProjectDAO {
	int insert(ProjectVO vo);
	List<ProjectVO> select();
	ProjectVO select(int projectNo);
	int update(ProjectVO vo);
	int delete(int projectNo);
	List<ProjectVO> select(PageCriteria criteria);
	int getTotalCounts();

}
