package edu.spring.hotel.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.hotel.domain.InqueryReplyVO;
import edu.spring.hotel.persistence.InqueryDAO;
import edu.spring.hotel.persistence.InqueryReplyDAO;

@Service
public class InqueryReplyServiceImple implements InqueryReplyService {
	private static final Logger logger = LoggerFactory.getLogger(InqueryReplyServiceImple.class);

	@Autowired
	private InqueryDAO inqueryDAO;
	@Autowired
	private InqueryReplyDAO inqueryReplyDAO;

	@Transactional
	@Override
	public int create(InqueryReplyVO vo) throws Exception {

		logger.info("create() 호출 : vo = " + vo.toString());
		inqueryReplyDAO.insert(vo);
		logger.info("댓글 입력 성공");
		inqueryDAO.updateReplyCount(1, vo.getInqueryNo());
		logger.info("게시판 댓글 개수 업데이트 성공");
	
		return 1;
	}

	@Override
	public List<InqueryReplyVO> read(int inqueryNo) {
		logger.info("read() 호출 : inqueryNo = " + inqueryNo);
		return inqueryReplyDAO.select(inqueryNo);
	}

	@Override
	public int update(InqueryReplyVO vo) {
		logger.info("update() 호출 : vo = " + vo.toString());
		return inqueryReplyDAO.update(vo);
	}

	@Transactional
	@Override
	public int delete(int inqueryRpNo, int inqueryNo) throws Exception {
		logger.info("delete() 호출 : inqueryRpNo = " + inqueryRpNo);
		inqueryReplyDAO.delete(inqueryRpNo);
		logger.info("댓글 삭제 성공");
		inqueryDAO.updateReplyCount(-1, inqueryNo);
		logger.info("게시판 댓글 개수 업데이터 성공");
		return 1;
	}
}