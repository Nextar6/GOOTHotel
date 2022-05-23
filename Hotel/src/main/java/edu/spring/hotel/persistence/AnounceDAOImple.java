package edu.spring.hotel.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.spring.hotel.domain.AnounceVO;
import edu.spring.hotel.pageutil.PageCriteria;

@Repository
public class AnounceDAOImple implements AnounceDAO{
	private static final Logger logger =
			LoggerFactory.getLogger(AnounceDAOImple.class);
	private static final String NAMESPACE =
			"edu.spring.hotel.AnounceMapper";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(AnounceVO vo) {
		logger.info("insert() 호출");
		
		return sqlSession.insert(NAMESPACE + ".insert", vo);
	}

	@Override
	public List<AnounceVO> select() {
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	}

	@Override
	public AnounceVO select(int anounceNo) {
		logger.info("select() 호출 : anounceNo = " + anounceNo);
		return sqlSession.selectOne(NAMESPACE + ".select_by_anounce_no", anounceNo);
	}

	@Override
	public int update(AnounceVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return sqlSession.update(NAMESPACE + ".update", vo);
	}

	@Override
	public int delete(int anounceNo) {
		logger.info("delete() 호출 : AnounceNo = " + anounceNo);
		return sqlSession.delete(NAMESPACE + ".delete", anounceNo);
	}

	@Override
	public List<AnounceVO> select(PageCriteria criteria) {
		logger.info("select() 호출 : start = " + criteria.getStart());
		logger.info("select() 호출 : end = " + criteria.getEnd());
		
		return sqlSession.selectList(NAMESPACE + ".paging", criteria);
	}

	@Override
	public int getTotalCounts() {
		logger.info("getTotalCounts()");
		return sqlSession.selectOne(NAMESPACE + ".total_count");
	}

//	검색 기능 강화 mapper 쿼리문에 %%가 들어가는게아니라 imple에서 변수에 앞뒤로 wildcard %%을 넣어 주는 방식!!
	@Override
	public List<AnounceVO> searchByTitleOrContent(PageCriteria criteria) {
		logger.info("select() 호출 : keyword = " + criteria.getKeyword());
		criteria.setKeyword("%" + criteria.getKeyword() + "%");
		return sqlSession.selectList(NAMESPACE + ".search_by_title_content", criteria);
	}
	
	@Override
	public int searchByTitleOrContentCount(String keyword) {
		logger.info("searchTitleOrContent() 호출");
		keyword = "%" + keyword + "%";
		return sqlSession.selectOne(NAMESPACE + ".search_by_title_content_count", keyword);
	}
	

//	작성자 아이디로 찾기와 페이징처리 총갯수 구하는 getCount
	
	@Override
	public List<AnounceVO> searchByWriter(PageCriteria criteria) {
		logger.info("select() 호출 : keyword = " + criteria.getKeyword());
		criteria.setKeyword("%" + criteria.getKeyword() + "%");
		logger.info("select() 호출 : page = " + criteria.getPage());
		logger.info("select() 호출 : numsPerPage = " + criteria.getNumsPerPage());
		return sqlSession.selectList(NAMESPACE + ".search_by_writer", criteria);
	} 

	
	@Override
	public int searchByWriterCount(String keyword) {
		logger.info("searchByWriterCount keyword : "+ keyword);
		keyword = "%" + keyword + "%";
		return sqlSession.selectOne(NAMESPACE + ".search_by_writer_count", keyword);
	}

}
