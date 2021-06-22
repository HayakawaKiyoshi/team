package com.tokyomethod.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tokyomethod.form.SampleForm;

@Controller
public class HelloFormController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index2(@ModelAttribute SampleForm form,
			ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("msg", "フォームを送信してください");
		return mav;
	}

	/*どうも玄番大介です。*/
	/*追加コメントします*/
	@RequestMapping(value = "/Form/next", method = RequestMethod.POST)
	public ModelAndView send2(@ModelAttribute SampleForm form,
			ModelAndView mav) {
		String res = null;
		try {
			res = "text1:" + form.getText1();
			String[] check1 = form.getCheck1();
			res += " check1:";
			for (int i = 0; i < check1.length; i++) {
				res += check1[i];
				mav.addObject("checkoption" + check1[i], "true");
			}
			res += " radio1:" + form.getRadio1() +
					" select1:" + form.getSelect1() +
					"\nselect2:";
		} catch (NullPointerException e) {
		}
		try {
			String[] select2 = form.getSelect2();
			res += select2[0];
			for (int i = 1; i < select2.length; i++) {
				res += ", " + select2[i];
			}
		} catch (NullPointerException e) {
			res += "null";
		}
		res += "\nkanso:" + form.getKanso();
		mav.setViewName("index");
		mav.addObject("msg", res);
		return mav;
	}
}
