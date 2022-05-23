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

import edu.spring.hotel.domain.PolicyVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.PolicyService;

@Controller
@RequestMapping(value = "/board")
public class PolicyController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private PolicyService policyService;
	
	@GetMapping("policy")
	public void policyGET(Model model, Integer page, Integer numsPerPage) {
		logger.info("policyGET() 호출");//
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);

		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<PolicyVO> policyList = policyService.read(criteria);
		model.addAttribute("policyList", policyList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(policyService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	} // end policyGET()
	
	@GetMapping("policy-detail")
	public void policyDetail(Model model, Integer policyNo, Integer page) {
		logger.info("policy-detail() 호출 : policyNo = " + policyNo);
		PolicyVO vo = policyService.read(policyNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	
	} // end policy-detailGET() 
	
	@GetMapping("/policy-update")
	public void policyUpdateGET(Model model, Integer policyNo, Integer page) {
		logger.info("policyUpdateGet() 호출 : policyNo = " + policyNo);
		PolicyVO vo = policyService.read(policyNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}
	@PostMapping("/policy-update")
	public String policyUpdatePOST(PolicyVO vo, Integer page) {
		logger.info("policy-updatePOST() 호출 : vo = " + vo.toString());
		int result = policyService.update(vo);
		logger.info(""+result);
		if(result == 1) {
			return "redirect:/board/policy?page=" + page;
		} else {
			return "redirect:/board/policy-update?policyNo=" + vo.getPolicyNo();
		}
	}
}
