package edu.spring.hotel.boardcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.EventService;

@Controller
@RequestMapping(value = "/board")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	@Autowired
	private EventService eventService;
	
		

	
	@GetMapping("event")
	public void eventGET(Model model, Integer page, Integer numsPerPage) {
		logger.info("eventGET() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);

		PageCriteria criteria = new PageCriteria();
		if (page != null) {
			criteria.setPage(page);
		}
		if (numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}

		List<EventVO> eventList = eventService.read(criteria);
		model.addAttribute("eventList", eventList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(eventService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	} // end eventGET()
	
	@GetMapping("event-detail")
	public void eventDetail(Model model, Integer eventNo, Integer page) {
		logger.info("event-detail() 호출 : eventNo = " + eventNo);
		EventVO vo = eventService.read(eventNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
		
		} // end event-detailGET() 
	
	@GetMapping("/event-update")
	public void eventUpdateGET(Model model, Integer eventNo, Integer page) {
		logger.info("eventUpdateGet() 호출 : eventNo = " + eventNo);
		EventVO vo = eventService.read(eventNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	}
	@PostMapping("/event-update")
	public String eventUpdatePOST(EventVO vo, Integer page) {
		logger.info("event-updatePOST() 호출 : vo = " + vo.toString());
		int result = eventService.update(vo);
		logger.info(""+result);
		if(result == 1) {
			return "redirect:/board/event?page=" + page;
		} else {
			return "redirect:/board/event-update?eventNo=" + vo.getEventNo();
		}
	} // end evetnUpdatePOST()

}
