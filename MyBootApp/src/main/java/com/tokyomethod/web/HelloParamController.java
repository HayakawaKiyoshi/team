package com.tokyomethod.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tokyomethod.form.InputForm;

@Controller
//@RequestMapping("/")
public class HelloParamController {

	@RequestMapping(method=RequestMethod.GET)
	 public ModelAndView index(ModelAndView mav) {
	 mav.setViewName("index");
	 mav.addObject("msg", "名前を書いて送信ください。");
	 return mav;
	 }
	 @RequestMapping(method=RequestMethod.POST)
//	 public ModelAndView send(@RequestParam("text1") String str,
//	 ModelAndView mav) {
//	 mav.setViewName("index");
//	 mav.addObject("msg", "こんにちは、" + str + "さん！");
//	 mav.addObject("value", str);
//	 return mav;
//	 }
	 public ModelAndView send(@ModelAttribute InputForm form,
			 ModelAndView mav) {
			 String str = form.getText1();
			 mav.setViewName("index");
			 mav.addObject("msg", "こんにちは、" + str + "さん！");
			 mav.addObject("value", str);
			 return mav;
			 }
	}

