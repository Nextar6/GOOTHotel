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

import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.ProjectService;

@Controller
@RequestMapping(value = "/board")
public class ProjectController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private ProjectService projectService;
	
	
	@GetMapping("project")
	public void projectGET(Model model, Integer page, Integer numsPerPage) {
		logger.info("projectGET() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);

		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<ProjectVO> projectList = projectService.read(criteria);
		model.addAttribute("projectList", projectList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(projectService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	} // end projectGET()
	
	@GetMapping("project-detail")
	public void projectDetail(Model model, Integer projectNo, Integer page) {
		logger.info("project-detail() 호출 : projectNo = " + projectNo);
		ProjectVO vo = projectService.read(projectNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	
	} // end project-detailGET()
	
	@GetMapping("/project-update")
	public void projectUpdateGET(Model model, Integer projectNo, Integer page) {
		logger.info("projectUpdateGet() 호출 : projectNo = " + projectNo);
		ProjectVO vo = projectService.read(projectNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}
	@PostMapping("/project-update")
	public String projectUpdatePOST(ProjectVO vo, Integer page) {
		logger.info("project-updatePOST() 호출 : vo = " + vo.toString());
		int result = projectService.update(vo);
		logger.info(""+result);
		if(result == 1) {
			return "redirect:/board/project?page=" + page;
		} else {
			return "redirect:/board/project-update?projectNo=" + vo.getProjectNo();
		}
	}

}
