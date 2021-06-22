package com.tokyomethod.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.tokyomethod.form.InputForm;


@Controller
@RequestMapping("/Session")
@SessionAttributes("inputForm")
public class SessionController {
	@Autowired
	HttpSession session;
	//セッションのオブジェクト代入格納メソッド
	@ModelAttribute("inputForm")
	 InputForm inputForm(){
    InputForm ii= new InputForm();
	 ii.setText1("Program setting text1");
	 return ii;
	 } @RequestMapping(value="/index",method=RequestMethod.GET)

	public String index(@ModelAttribute InputForm form) {
		try {
			String other = (String) session.getAttribute("sessionother");
			session.setAttribute("sessionother", other);
			int count = (int) session.getAttribute("sessioncount");
			session.setAttribute("sessioncount", new Integer(++count));
		} catch (NullPointerException e) {
			session.setAttribute("sessioncount", new Integer(1));
			session.setAttribute("sessionother", "index初期設定");
		}
		return "session/index";
	} @PostMapping("post")

	public String post(@ModelAttribute InputForm form) {
		session.setAttribute("sessionother", "post 設定");
		return "session/post";
	} @GetMapping("destroy")

	public String destroy(SessionStatus sessionStatus) {
	 // セッション廃棄
	 sessionStatus.setComplete();
	 session.removeAttribute("sessioncount");
	 session.removeAttribute("sessionother");
	 return "redirect:/Session/index";
	 }
}
