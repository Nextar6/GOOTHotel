package edu.spring.hotel.boardcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.hotel.domain.QuestionVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.QuestionService;

@Controller
@RequestMapping(value = "/board")
public class QuestionController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private QuestionService questionService;
	

	@GetMapping("question")
	public void questionGET(Model model, Integer page, Integer numsPerPage) {
		logger.info("questionGET() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);

		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		List<QuestionVO> questionList = questionService.read(criteria);
		model.addAttribute("questionList", questionList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(questionService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	} // end questionGET()
	
	@GetMapping("question-detail")
	public void questionDetail(Model model, Integer questionNo, Integer page) {
		logger.info("question-detail() 호출 : questionNo = " + questionNo);
		QuestionVO vo = questionService.read(questionNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	
	} // end question-detailGET()
	
	@GetMapping("/question-update")
	public void questionUpdateGET(Model model, Integer questionNo, Integer page) {
		logger.info("questionUpdateGet() 호출 : questionNo = " + questionNo);
		QuestionVO vo = questionService.read(questionNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}
	@PostMapping("/question-update")
	public String questionUpdatePOST(QuestionVO vo, Integer page) {
		logger.info("question-updatePOST() 호출 : vo = " + vo.toString());
		int result = questionService.update(vo);
		logger.info(""+result);
		if(result == 1) {
			return "redirect:/board/question?page=" + page;
		} else {
			return "redirect:/board/question-update?questionNo=" + vo.getQuestionNo();
		}
	}
}
