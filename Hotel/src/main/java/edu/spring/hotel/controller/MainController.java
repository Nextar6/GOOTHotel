package edu.spring.hotel.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.spring.hotel.domain.HotelVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.HotelService;
import edu.spring.hotel.util.MediaUtil;

@Controller
@RequestMapping(value="/main")
public class MainController {
	private static final Logger logger =
				LoggerFactory.getLogger(MainController.class);
		
	@Autowired
	private HotelService hotelService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	@GetMapping("/main")
	public void main(Model model, Integer page, Integer numsPerPage) {
		logger.info("main() 호출");
		logger.info("page = " + page + ", numsPerPage = " + numsPerPage);
		
		PageCriteria criteria = new PageCriteria();
		if(page != null) {
			criteria.setPage(page);
		}
		
		if(numsPerPage != null) {
			criteria.setNumsPerPage(numsPerPage);
		}
		
		List<HotelVO> main = hotelService.read_all(criteria);
		model.addAttribute("main", main);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(hotelService.getTotalCount());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	}
	
	@GetMapping("/displayimages")
	public ResponseEntity<byte[]> display(String fileName) throws Exception{
		logger.info("displayimages() 호출");
		
		ResponseEntity<byte[]> entity = null;
		InputStream in = null;
		
		logger.info("fileName = " + fileName);
		
		String[] str = fileName.split(",");
		for(int i = 0; i < str.length; i++) {
			logger.info("str = " + str[i]);
		}
		
		String filePath = uploadPath + fileName;
		logger.info("전체주소 : " + filePath);
		in = new FileInputStream(filePath);

		String extension = 
				filePath.substring(filePath.lastIndexOf(".") + 1);
		logger.info(extension);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));
		
		entity = new ResponseEntity<byte[]>(
					IOUtils.toByteArray(in),
					httpHeaders,
					HttpStatus.OK
		);
		return entity;
	}
		
}