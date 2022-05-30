package edu.spring.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.ThemaparkVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.service.ThemaparkService;

@RestController
@RequestMapping(value="play")
public class ThemaparkRESTController {
	private static final Logger logger = LoggerFactory.getLogger(ThemaparkRESTController.class);
	
	
	@Autowired
	private ThemaparkService themaparkService;
	
	@GetMapping("themapark/readNext/{page}")
	public ResponseEntity<List<ThemaparkVO>> readThemapark(
			@PathVariable("page") int page) {
		logger.info("themapark select All 확인");
		PageCriteria criteria = new PageCriteria();
		criteria.setPage(page);
		
		List<ThemaparkVO> list = themaparkService.read(criteria);
		for(ThemaparkVO vo : list) {
			int searchIndex = vo.getThemaparkPic().indexOf(',');
			if(searchIndex == -1) {
//				vo.setThemaparkPic(vo.getThemaparkPic().replace("s_", ""));
			} else {
				System.out.println(searchIndex);
				vo.setThemaparkPic(vo.getThemaparkPic().substring(0, searchIndex));
				vo.setThemaparkPic(vo.getThemaparkPic().replace("s_", ""));
			}
			logger.info(vo.toString());
		}
		logger.info("test");
		
		return new ResponseEntity<List<ThemaparkVO>>(list, HttpStatus.OK);
	} // end getThemaparkAll

}
