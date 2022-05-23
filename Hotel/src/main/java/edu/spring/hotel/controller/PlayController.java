package edu.spring.hotel.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.hamcrest.core.SubstringMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.FoodVO;
import edu.spring.hotel.domain.PlayVO;
import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.FoodService;
import edu.spring.hotel.service.PlayService;
import edu.spring.hotel.util.FileUploadUtil;
import edu.spring.hotel.util.MediaUtil;

@Controller
@RequestMapping("play")
public class PlayController {
	private static final Logger logger = LoggerFactory.getLogger(PlayController.class);

	@Autowired
	private PlayService playService;

	@Autowired
	private FoodService foodService;
	
	@GetMapping("login")
	public String loginGET() {
		logger.info("loginGET 호출");
		return "redirect:/member/login";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		logger.info("logout() 호출");

		HttpSession session = request.getSession();
		session.removeAttribute("userid");

		return "redirect:/main/main";
	}

	// 다른 경로 더보기 게시판이동 anounce,event,project,inquery,policy

	@GetMapping("play-insert")
	public void playInsertGET() {
		logger.info("play-insert 호출");

	} // end register()

	@PostMapping("insert")
	public String playInsertPOST(PlayVO vo, Model model, RedirectAttributes reAttr) throws IOException {
		logger.info("playInsertPOST() 호출 : ");

		logger.info("files Name : " + vo.getPlayPic());
		logger.info(vo.getPlayPic());

		logger.info(vo.toString());
		int result = playService.create(vo);
		logger.info(result + "행삽입");

		if (result == 1) {
			reAttr.addFlashAttribute("insert_result", "success");
			return "redirect:/play/play";
		} else {
			reAttr.addFlashAttribute("insert_result", "fail");
			return "redirect:/play/insert";
		}

	} // post register()

	@GetMapping("play-detail")
	public void playDetailGET(Model model, Integer playNo, Integer page) {
		logger.info("playDetail 호출");
		logger.info("play-detail() 호출 : playNo = " + playNo);
		PlayVO vo = playService.read(playNo);
		logger.info("이미지 경로 : " + vo.getPlayPic());

		String[] picArray = vo.getPlayPic().split(",");
		for (int i = 0; i < picArray.length; i++) {
			logger.info("그림 배열 저장 확인 : " + picArray[i]);
		}
		model.addAttribute("picArray", picArray);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end play-detail
	
	@GetMapping("play-all")
	public void playAllGET(Model model, Integer page) {
		logger.info("play-all 호출");
		List<PlayVO> playList = playService.read();
		
		model.addAttribute("playList", playList);
	} // end playAllGET()
	@GetMapping("play")
	public void playGET(Model model, Integer page) {
		logger.info("playGET() 호출");
		PageCriteria criteria = new PageCriteria();

		if (page != null) {
			criteria.setPage(page);

		}
		List<PlayVO> playList = playService.read(criteria);
		model.addAttribute("playList", playList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setTotalCount(foodService.getTotalCounts());
		System.out.println("food페이지 총 갯수 확인" + pageMaker.getTotalCount());
		int foodButtonControll = (int) Math.ceil((double) pageMaker.getTotalCount()/ 5) ;
		System.out.println("foodButtonControll : " + foodButtonControll );
		model.addAttribute("foodButtonControll", foodButtonControll);
		
		
		pageMaker.setTotalCount(playService.getTotalCounts());
		System.out.println("play페이지 총 갯수 확인" + pageMaker.getTotalCount());
		int playButtonControll = (int) Math.ceil((double) pageMaker.getTotalCount()/ 5) ;
		System.out.println("playButtonControll : " + playButtonControll );
		model.addAttribute("playButtonControll", playButtonControll);
	}// end playGET()

	@GetMapping("play-update")
	public void updateGET(Model model, Integer playNo, Integer page) {
		logger.info("updateGET 호출 : playNo = " + playNo);
		PlayVO vo = playService.read(playNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // end updateGET()

	@PostMapping("update")
	public String updatePOST(PlayVO vo, Integer page, RedirectAttributes reAttr) {
		logger.info("updatePOST 호출 : vo " + vo.toString());

		int result = playService.update(vo);

		if (result == 1) {
			reAttr.addFlashAttribute("update_result", "success");
			return "redirect:/play/play";
		} else
			reAttr.addFlashAttribute("update_fail", "fail");
		return "redirect:/play/play-update?playNo=" + vo.getPlayNo();

	} // end updatePOST()

	@PostMapping("/upload-ajax")
	@ResponseBody
	public ResponseEntity<String> uploadAjaxPOST(MultipartFile[] files) throws IOException {
		logger.info("uploadAjaxPOST() 호출");

		// 파일 하나만 저장
		String result = null; // result : 파일 경로 및 썸네일 이미지 이론
		result = FileUploadUtil.saveUploadedFile(uploadPath, files[0].getOriginalFilename(), files[0].getBytes());
		return new ResponseEntity<String>(result, HttpStatus.OK);
	} // end upload-ajax

	@GetMapping("delete")
	public String delete(Integer playNo, RedirectAttributes reAttr) {
		logger.info("play delete 호출  playNo : " + playNo);
		int result = playService.delete(playNo);
		if (result == 1) {
			reAttr.addFlashAttribute("delete_result", "success");
			return "redirect:/play/play";
		} else {
			reAttr.addFlashAttribute("delete_fail", "fail");
			return "redirect:/play/play-detail";
		}
	}

	@GetMapping("play-orderby-reply")
	public void orderByReplyGET(Model model, Integer page) {
		logger.info("orderby-replyGET() 호출");

		PageCriteria criteria = new PageCriteria();

		if (page != null) {
			criteria.setPage(page);
		}
		List<PlayVO> playList = playService.readOrderByReply(criteria);

		model.addAttribute("playList", playList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(playService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
	}// end playGET()

	// 가격순 정렬 TODO : 05- 10
	@GetMapping("play-orderby-price")
	public void orderByPriceGET(Model model, String keyword, Integer page) {
		logger.info("orderByPriceGET() 호출");
		if (keyword.equals("max")) {
			logger.info("max 확인");
			PageCriteria criteria = new PageCriteria();
			criteria.setKeyword("max");

			if (page != null) {
				criteria.setPage(page);

			}
			List<PlayVO> playList = playService.readOrderByPrice(criteria);
			model.addAttribute("playList", playList);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			pageMaker.setTotalCount(playService.getTotalCounts());
			pageMaker.setPageData();
			model.addAttribute("pageMaker", pageMaker);

		} else if (keyword.equals("min")) {
			logger.info("min 확인");
			PageCriteria criteria = new PageCriteria();
			criteria.setKeyword("min");

			if (page != null) {
				criteria.setPage(page);

			}
			List<PlayVO> playList = playService.readOrderByPrice(criteria);
			model.addAttribute("playList", playList);

			PageMaker pageMaker = new PageMaker();
			pageMaker.setCriteria(criteria);
			pageMaker.setTotalCount(playService.getTotalCounts());
			pageMaker.setPageData();
			model.addAttribute("pageMaker", pageMaker);

		}
	}

	@GetMapping("play-orderby-like")
	public void orderByLikeGET(Model model, Integer page) {
		logger.info("orderByLikeGET() 호출");

		PageCriteria criteria = new PageCriteria();

		if (page != null) {
			criteria.setPage(page);
		}
		// TODO 인기 순으로 정렬하는 Query짜서 구현하기
		List<PlayVO> playList = playService.readOrderByLike(criteria);
		model.addAttribute("playList", playList);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(playService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);

	}

//	 ------------------이미지 전송-------------------

	// servlet-context.xml와 root-context 파일에 설정된 문자열 리소스 주입
	@Resource(name = "uploadPath")
	private String uploadPath;

	@ResponseBody
	@PostMapping("/fileUpload")
	public ResponseEntity<String[]> fileUploadPOST(MultipartFile[] filelist) throws Exception {
		logger.info("fileUploadPOST() 호출");

		String result = "";
		String[] images = new String[filelist.length];
		for (int i = 0; i < filelist.length; i++) {
			result = FileUploadUtil.saveUploadedFile(uploadPath, filelist[i].getOriginalFilename(),
					filelist[i].getBytes());
			images[i] = result;
			logger.info("images = " + images[i]);
		}
		return new ResponseEntity<String[]>(images, HttpStatus.OK);
	}

	@GetMapping("/display")
	public ResponseEntity<byte[]> display(String fileName) throws Exception {
		logger.info("display() 호출");
		logger.info("fileName : " + fileName);

		ResponseEntity<byte[]> entity = null;
		InputStream in = null;

//		String[] str = fileName.split(","); , 파일이름 ,을 기준으로 나눠서 배열에 저장.
//		for ( int i = 0; i<array.length; i++) {
//			logger.info("fileName : " + array[i]);
//		}

		String[] str = fileName.split(",");
		for (int i = 0; i < str.length; i++) {
			logger.info("str = " + str[i]);
		}

		String filePath = uploadPath + fileName;
		logger.info("filePath = " + filePath);
		in = new FileInputStream(filePath);

		// 파일 확장자
		String extension = filePath.substring(filePath.lastIndexOf(".") + 1);
		logger.info(extension);

		// 응답 헤더(response header)에 Context-Type 설정
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaUtil.getMediaType(extension));

		// 데이터 전송
		entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), // 파일에서 읽은 데이터
				httpHeaders, // 응답 헤더
				HttpStatus.OK);
		return entity;
	}

	private String saveUploadFile(MultipartFile file) {
		// UUID : 업로드 하는 파일 이름이 중복되지 않도록 유니크하게 만들어주는 클래스
		UUID uuid = UUID.randomUUID();
		String savedName = uuid + "_" + file.getOriginalFilename();

		File target = new File(uploadPath, savedName);

		try {
			FileCopyUtils.copy(file.getBytes(), target);
			logger.info("파일 저장 성공");
			return savedName;
		} catch (IOException e) {
			logger.error("파일 저장 실패");
			return null;
		}
	}

}
