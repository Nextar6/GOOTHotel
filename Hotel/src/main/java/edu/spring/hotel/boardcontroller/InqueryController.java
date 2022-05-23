package edu.spring.hotel.boardcontroller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.domain.InqueryVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.InqueryService;

@Controller
@RequestMapping(value = "/board")
public class InqueryController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private InqueryService inqueryService;

	@GetMapping("inquery")
	public void inqueryGET(Model model, Integer page, Integer numsPerPage) {

		logger.info("inqueryGET() 호출");

		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);

		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<InqueryVO> inqueryList = inqueryService.read(criteria);
		model.addAttribute("inqueryList", inqueryList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(inqueryService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	} // end eventGET()

	@GetMapping("inquery-register")
	public void inqueryRegisterGET() {
		logger.info("inquery-registerGET() 호출");

	} // end registerGET

	// TODO 05-12 1:1문의 게시글 등록시 타겟문제?
	@PostMapping("inquery-register")
	public String inqueryRegisterPOST(InqueryVO vo, Model model, RedirectAttributes reAttr) throws IOException {
		logger.info("inquery-registerPOST() 호출");
		int result = inqueryService.create(vo);
		logger.info(result + "행삽입");

		if (result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/board/inquery";
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/board/inquery";
		}
	}

	@GetMapping("inquery-detail")
	public void inqueryDetail(Model model, Integer inqueryNo, Integer page) {
		logger.info("inquery-detail() 호출 : inqueryNo = " + inqueryNo);
		InqueryVO vo = inqueryService.read(inqueryNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);

	} // end inquery-detailGET()

	@GetMapping("inquery-admin")
	public void inqeuryAdmin(Model model, Integer page, Integer numsPerPage) {
		logger.info("inqueryAdminGET 호출");
		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<InqueryVO> inqueryList = inqueryService.read(criteria);
		model.addAttribute("inqueryList", inqueryList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(inqueryService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	}

	@GetMapping("inquery-delete")
	public String inqueryDelete(Integer inqueryNo, RedirectAttributes reAttr) {
		logger.info("inquery-delete 호출 inqueryNo : " + inqueryNo);
		int result = inqueryService.delete(inqueryNo);
		if(result == 1) {
			reAttr.addFlashAttribute("delete_result", "success");
			return "redirect:/board/inquery-admin";
		} else {
			reAttr.addFlashAttribute("delete_fail", "fail");
			return "redirect:/board/inquery-detail";
		}
		

	}
}
