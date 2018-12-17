package org.dev.controller;

import javax.validation.Valid;

import org.dev.entity.Score;
import org.dev.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javassist.NotFoundException;

@Controller
@RequestMapping("/score")
public class ScoreController {
	@Autowired
	public ScoreService scoreService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String ScoreIndexPage(ModelMap model) throws Exception {
		model.addAttribute("message", scoreService.getAllScore());
		return "scorelist";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchScore() {
		return "searchScore";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAllScore(@RequestParam(value = "sid", required = false) String sid,
			@RequestParam(value = "cid", required = false) String cid, ModelMap model) throws Exception {
		if (sid == null && cid == null) {
			model.addAttribute("message", scoreService.getAllScore());
		} else if (sid != null && cid != null) {
			Score item = scoreService.getOneScore(sid, cid);
			if (item != null) {
				model.addAttribute("item", item);
				return "scoreTable";
			} else {
				throw new NotFoundException("");
			}
		} else {
			throw new IllegalArgumentException("The 'sid' and 'cid' parameters must not be null or empty");
		}
		return "scorelist";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addScore(@Valid @ModelAttribute("Score") Score score) throws Exception {
		scoreService.addScore(score);
		ModelAndView mav = new ModelAndView("redirect:/score");
		return mav;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addScorePage() throws Exception {
		ModelAndView mav = new ModelAndView("addScore");
		mav.addObject("Score", new Score());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateScore(@Valid @ModelAttribute("Score") Score score) throws Exception {
		scoreService.updateScore(score);
		ModelAndView mav = new ModelAndView("redirect:/score");
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateScorePage(@RequestParam(value = "sid") String sid,
			@RequestParam(value = "cid") String cid) throws Exception {
		ModelAndView mav = new ModelAndView("updateScore");
		mav.addObject("Score", scoreService.getOneScore(sid, cid));
		return mav;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ModelAndView deleteScore(@RequestParam(value = "sid") String sid, @RequestParam(value = "cid") String cid)
			throws Exception {
		scoreService.deleteScore(sid, cid);
		ModelAndView mav = new ModelAndView("redirect:/score");
		return mav;
	}
}
