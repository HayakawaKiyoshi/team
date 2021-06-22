package com.tokyomethod.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//改変テスト_濱口
//修正追加
//コメント追加


@Controller
public class HelloController {

//	 @RequestMapping("/")
//	 public String index() {
//	 return "Hello Spring Boot Restful!!";
//	 }
//
//	@RequestMapping("/{num}")
//	public String index2(@PathVariable int num) {
//		return "Hello Spring Boot Restful!!"+num;
//	@RequestMapping("/")
//	 public String index() {
//	 return "index";
//	 }
//	@RequestMapping("/{num}")
//	 public String index(@PathVariable int num, Model model) {
//	 model.addAttribute("msg", "param:"+num);
//	 return "index";
//	 }
	 @RequestMapping("/{num}")
	 public ModelAndView index(@PathVariable int num, ModelAndView mav) {
	 mav.addObject("msg", "param:"+num); //データ類
	 mav.setViewName("index"); //ビュー
	 return mav;
	 }
	}

