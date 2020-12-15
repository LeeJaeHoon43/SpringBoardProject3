package com.ljh.mypage.controller;

import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ljh.mypage.commons.paging.Criteria;
import com.ljh.mypage.commons.paging.PageMaker;
import com.ljh.mypage.domain.ArticleVO;
import com.ljh.mypage.service.ArticleService;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	private final ArticleService articleService;
	
	@Inject
	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	// 등록 페이지 이동.
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String writeGET() {
		logger.info("writeGET");
		return "/article/write";
	}
	
	// 등록 처리.
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String writePOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("writePOST");
		logger.info(articleVO.toString());
		
		articleService.create(articleVO);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/article/list";
	}
	
	// 목록 페이지 이동.
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) throws Exception{
		logger.info("list");
		model.addAttribute("articles", articleService.listAll());
		return "/article/list";
	}
	
	// 조회 페이지 이동.
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception{
		logger.info("read");
		model.addAttribute("article", articleService.read(articleNo));
		return "/article/read";
	}
	
	// 수정 페이지 이동.
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyGET(@RequestParam("articleNo") int articleNo, Model model) throws Exception{
		logger.info("modifyGET");
		model.addAttribute("article", articleService.read(articleNo));
		return "/article/modify";
	}
	
	// 수정 처리.
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modifyPOST(ArticleVO articleVO, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("modifyPOST");
		articleService.update(articleVO);
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/article/list";
	}
	
	// 삭제 처리.
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@RequestParam("articleNo") int articleNo, RedirectAttributes redirectAttributes)throws Exception{
		logger.info("delete");
		articleService.delete(articleNo);
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/article/list";
	}	
	
	// 페이징 목록.
	@RequestMapping(value = "/listPaging", method = RequestMethod.GET)
	public String listPaging(Model model, Criteria criteria)throws Exception{
		logger.info("listPaging");
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(articleService.countArticles(criteria));
		model.addAttribute("articles", articleService.listCriteria(criteria));
		model.addAttribute("pageMaker", pageMaker);
		return "/article/list_paging";
	}
	
	@RequestMapping(value = "/readPaging", method = RequestMethod.GET)
	public String readPaging(@RequestParam("articleNo") int articleNo, @ModelAttribute("criteria") Criteria criteria, Model model) throws Exception{
		model.addAttribute("article", articleService.read(articleNo));
		return "/article/read_paging";
	}
	
	@RequestMapping(value = "/modifyPaging", method = RequestMethod.GET)
	public String modifyGETPaging(@RequestParam("articleNo") int articleNo, @ModelAttribute("criteria") Criteria criteria, Model model) throws Exception{
		logger.info("modifyGETPaging");
		model.addAttribute("article", articleService.read(articleNo));
		return "/article/modify_paging";
	}
	
	@RequestMapping(value = "/modifyPaging", method = RequestMethod.POST)
	public String modifyPOSTPaging(ArticleVO articleVO, Criteria criteria, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("modifyPOSTPaging");
		articleService.update(articleVO);
		redirectAttributes.addAttribute("page", criteria.getPage());
		redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("msg", "modSuccess");
		return "redirect:/article/listPaging";
	}
	
	@RequestMapping(value = "/removePaging", method = RequestMethod.POST)
	public String removePaging(@RequestParam("articleNo") int articleNo, Criteria criteria, RedirectAttributes redirectAttributes) throws Exception{
		logger.info("remove");
		articleService.delete(articleNo);
		redirectAttributes.addAttribute("page", criteria.getPage());
		redirectAttributes.addAttribute("perPageNum", criteria.getPerPageNum());
		redirectAttributes.addFlashAttribute("msg", "delSuccess");
		return "redirect:/article/listPaging";
	}
}
