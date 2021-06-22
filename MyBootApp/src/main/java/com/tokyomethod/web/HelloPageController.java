package com.tokyomethod.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloPageController {
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav;
	}

	@RequestMapping("/other")
	public String other() {
		return "redirect:/";
	}

	//@RequestMapping("/home")
	public String home() {
		return "forward:/";
	}

	/*
	 *
	 * @auther User 変更 tatsumi git確認のため
	 */

	@RequestMapping("/home")
	public ModelAndView home2(ModelAndView mav) {
		mav.setViewName("forward:/send");
		mav.addObject("msg", "こんにちは、××× さん！");
		return mav;
	}

	//@RequestMapping("/send")
	public ModelAndView send(HttpServletRequest request, ModelAndView mav) {
		mav.setViewName("send");
		String msg = (String) request.getAttribute("msg");
		mav.addObject("msg", msg);
		return mav;
	}

	@RequestMapping("/other2")
	public ModelAndView other2(RedirectAttributes redirectAttributes,
			ModelAndView mav) {
		mav.setViewName("redirect:/send");
		redirectAttributes.addFlashAttribute("msg", "redirect:message");
		return mav;
	}

	@RequestMapping("/send")
	 public ModelAndView send( ModelAndView mav,Model model){
	 mav.setViewName("send");
	 String msg = (String) model.asMap().get("msg");
	 mav.addObject("msg", msg);
	 return mav;
	}
}
