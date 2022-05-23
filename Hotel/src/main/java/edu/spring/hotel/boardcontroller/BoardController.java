package edu.spring.hotel.boardcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.AnounceVO;
import edu.spring.hotel.domain.EventVO;
import edu.spring.hotel.domain.InqueryVO;
import edu.spring.hotel.domain.PolicyVO;
import edu.spring.hotel.domain.ProjectVO;
import edu.spring.hotel.domain.QuestionVO;

import edu.spring.hotel.pageutil.PageCriteria;
import edu.spring.hotel.pageutil.PageMaker;
import edu.spring.hotel.service.AnounceService;
import edu.spring.hotel.service.EventService;
import edu.spring.hotel.service.InqueryService;
import edu.spring.hotel.service.PolicyService;
import edu.spring.hotel.service.ProjectService;
import edu.spring.hotel.service.QuestionService;
//보드 메인페이지 anounce(공지사항) 컨트롤러
//register와 delete 각 게시판 찾아서 등록 및 삭제 


@Controller
@RequestMapping(value = "/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private AnounceService anounceService;
	@Autowired
	private EventService eventService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private PolicyService policyService;
	@Autowired
	private InqueryService inqueryService;
//	이부분은 register, delete에서 묶여 있기 때문에 일단 놔두기
	
	
	// 4-22 강사님 피드백 ** 유지보수 **
	// 코드 쉽고 간편하게 하는거보다 유지보수측면에서
	// 바꾸기 좋고 알아보기 좋게 나누는것이 낫다. 한군데 대려박지말고 나누기
	
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
	@GetMapping("play")
	public String play() {
		logger.info("play 호출");
		return "redirect:/hotel/play";
	}


	@GetMapping("/register")
	public void registerGET() {
		logger.info("registerGET() 호출");
	} // end registerGET()

//	카테고리별 맞는 DB찾아서 글 등록
	@PostMapping("/register")
	public String regitserPOST(HttpServletRequest request, HttpServletResponse response,RedirectAttributes reAttr) throws ServletException, IOException{
		logger.info("registerPOST() 호출");
		
		String boardCategory = request.getParameter("boardCategory");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String writer = request.getParameter("writer");
		
		if(boardCategory.equals("anounce")) {
			
			System.out.println("카테고리 anounce DB글 등록");
			AnounceVO vo = new AnounceVO(0, boardTitle, boardContent, writer, null); 
			int result = anounceService.create(vo);
			if(result == 1) {
				reAttr.addFlashAttribute("insert_result", "success");
				return "redirect:/board/anounce"; 
			} else {
				reAttr.addFlashAttribute("insert_result", "fail");
				return "redirect:/board/register"; 
			}
			
		} else if(boardCategory.equals("event")) {
			System.out.println("카테고리 event DB글 등록");
			EventVO vo = new EventVO(0, boardTitle, boardContent, writer, null); 
			int result = eventService.create(vo);
			if(result == 1) {
				reAttr.addFlashAttribute("insert_result", "success");
				return "redirect:/board/event"; 
			} else {
				reAttr.addFlashAttribute("insert_result", "fail");
				return "redirect:/board/register"; 
			}
		} else if(boardCategory.equals("project")) {
			System.out.println("카테고리 project DB글 등록");
			ProjectVO vo = new ProjectVO(0, boardTitle, boardContent, writer, null); 
			int result = projectService.create(vo);
			if(result == 1) {
				reAttr.addFlashAttribute("insert_result", "success");
				return "redirect:/board/project"; 
			} else {
				reAttr.addFlashAttribute("insert_result", "fail");
				return "redirect:/board/register"; 
			}
			
		} else if(boardCategory.equals("question")) {
			System.out.println("카테고리  question글 등록");
			QuestionVO vo = new QuestionVO(0, boardTitle, boardContent, writer, null); 
			int result = questionService.create(vo);
			if(result == 1) {
				reAttr.addFlashAttribute("insert_result", "success");
				return "redirect:/board/question"; 
			} else {
				reAttr.addFlashAttribute("insert_result", "fail");
				return "redirect:/board/register"; 
			}
			
		} else if(boardCategory.equals("policy")) {
			System.out.println("카테고리 policy DB글 등록");
			PolicyVO vo = new PolicyVO(0, boardTitle, boardContent, writer, null); 
			int result = policyService.create(vo);
			if(result == 1) {
				reAttr.addFlashAttribute("insert_result", "success");
				return "redirect:/board/policy"; 
			} else {
				reAttr.addFlashAttribute("insert_result", "fail");
				return "redirect:/board/register"; 
			}
			
		
		}
		return "redirect:/board/register"; 
	} // end registerPOST()
	
	
	// 공지사항 게시판 기본 전체리스트 불러오기 + 페이징처리 + 검색기능 추가
	@GetMapping("anounce")
	public void anounceGET(Model model, String select, Integer page, Integer pagingCount, String keyword) {
		
		logger.info("anounceGET() 호출");
		logger.info("page = " + page + ", numsPerPage = " + pagingCount);

		// 제목과 검색
		
		if(select != null) {
			if(select.equals("writer")) {
				logger.info("검색 select : " + select  );
				logger.info("keyword : " + keyword);
				PageCriteria criteria = new PageCriteria();
				// 이전 페이지 확인
				logger.info("크리테리아 확인");
				if (page != null) {
					criteria.setPage(page);
				}	
//					작성자로 검색
					criteria.setKeyword(keyword);
					
				// 페이징처리 보여질 갯수 기본5개와 10개 20개 
				// pagingCount : 선택한 페이징 개수
					if(pagingCount != null) {
					criteria.setNumsPerPage(pagingCount);
					logger.info("설정한 페이징 갯수로 진행");
					}
				// 키워드 - 작성자로 검색하는 쿼리로 연결	
					List<AnounceVO> anounceList = anounceService.readByWriter(criteria);
				// anounce로 값 보내주기	
					model.addAttribute("anounceList", anounceList);
					model.addAttribute("keyword", keyword);
					model.addAttribute("select", select);
					model.addAttribute("pagingCount", pagingCount);
					
					logger.info("searchCount"+anounceService.searchByWriterCounts(keyword));
					PageMaker pageMaker = new PageMaker();
					pageMaker.setCriteria(criteria);
					// totalCount query
					logger.info("검색 갯수 : " + anounceList.size());
					pageMaker.setTotalCount(anounceService.searchByWriterCounts(keyword));
					pageMaker.setPageData();
					model.addAttribute("pageMaker", pageMaker);
				} 
			else if (select.equals("titleOrContent")) {
				PageCriteria criteria = new PageCriteria();
				logger.info("검색 select : " + select  );
				logger.info("keyword : " + keyword);
				
				// 이전 페이지 확인
		
				if (page != null) {
					criteria.setPage(page);
				}
				
				if(pagingCount != null) {
					criteria.setNumsPerPage(pagingCount);
					logger.info("설정한 페이징 갯수로 진행");
					}
			
//					제목 + 내용으로 검색
					criteria.setKeyword(keyword);

				// 페이징처리 보여질 갯수 기본5개 10개 20개
				// pagingCount : 선택한 페이징 개수

				// 키워드 - 작성자로 검색하는 쿼리로 연결	
					List<AnounceVO> anounceList = anounceService.readByTitleOrContent(criteria);
					model.addAttribute("anounceList", anounceList);
					
					model.addAttribute("keyword", keyword);
					model.addAttribute("select", select);
					model.addAttribute("pagingCount", pagingCount);
					
					logger.info("searchCount" + anounceService.searchByTitleOrCounts(keyword));
					PageMaker pageMaker = new PageMaker();
					pageMaker.setCriteria(criteria);
					// totalCount query
					pageMaker.setTotalCount(anounceService.searchByTitleOrCounts(keyword));
					pageMaker.setPageData();
					model.addAttribute("pageMaker", pageMaker);
			} // end titleOrContent search IF
			
		} else {
		PageCriteria criteria = new PageCriteria();
		
		if(pagingCount != null) {
			criteria.setNumsPerPage(pagingCount);
			logger.info("설정한 페이징 갯수로 진행");
			}
		if (page != null) {
			criteria.setPage(page);
		}

		List<AnounceVO> anounceList = anounceService.read(criteria);
		model.addAttribute("anounceList", anounceList);
		model.addAttribute("pagingCount", pagingCount);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(anounceService.getTotalCounts());
		pageMaker.setPageData();
		model.addAttribute("pageMaker", pageMaker);
		}
		
	} // end anounceGET()

	
	
//	 -------------글 상세 정보 detail ------------
	
	@GetMapping("anounce-detail")
	public void anounceDetail(Model model, Integer anounceNo, Integer page) {
		logger.info("anounce-detail() 호출 : boardNo = " + anounceNo);
		AnounceVO vo = anounceService.read(anounceNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	
	} // end anounce-detailGET()

	
	// ------- 삭제-------
	@GetMapping("/delete")
	public String delete(Integer boardNo, String board) {
		logger.info("delete() 호출 : boardNo = " + boardNo);
		logger.info("delete() 호출 : board = " + board);
		
		if(board.equals("anounce")) {
			logger.info("anounce delete 호출");
			int result = anounceService.delete(boardNo);
			if(result == 1) {
				return "redirect:/board/anounce";
			} else {
				return "redirect:/board/anounce-detail";
			}
			
		} else if(board.equals("event")){
			logger.info("event delete 호출");
			int result = eventService.delete(boardNo);
			if(result == 1) {
				return "redirect:/board/event";
			} else {
				return "redirect:/board/event-detail";
			}
		} else if(board.equals("project")){
			logger.info("project delete 호출");
			int result = projectService.delete(boardNo);
			if(result == 1) {
				return "redirect:/board/project";
			} else {
				return "redirect:/board/project-detail";
			}
		} else if(board.equals("question")){
			logger.info("question delete 호출");
			int result = questionService.delete(boardNo);
			if(result == 1) {
				return "redirect:/board/question";
			} else {
				return "redirect:/board/question-detail";
			}
		} else if(board.equals("policy")){
			logger.info("policy delete 호출");
			int result = policyService.delete(boardNo);
			if(result == 1) {
				return "redirect:/board/policy";
			} else {
				return "redirect:/board/policy-detail";
			}
		} 
			return "redirect:/board/anounce";
			
		} // end delete()
	
	@GetMapping("/anounce-update")
	public void anounceUpdateGET(Model model, Integer anounceNo, Integer page) {
		logger.info("anounceUpdateGet() 호출 : anounceNo = " + anounceNo);
		AnounceVO vo = anounceService.read(anounceNo);
		model.addAttribute("vo", vo);
		model.addAttribute("page", page);
	} // anounce-updateGET()
	
	@PostMapping("/anounce-update")
	public String anounceUpdatePOST(AnounceVO vo, Integer page) {
		logger.info("anounce-updatePOST() 호출 : vo = " + vo.toString());
		int result = anounceService.update(vo);
		logger.info(""+result);
		if(result == 1) {
			return "redirect:/board/anounce?page=" + page;
		} else {
			return "redirect:/board/anounce-update?anounceNo=" + vo.getAnounceNo();
		}
	} // end anounce-updatePOST()
	
	
	

	



} // end BoardController