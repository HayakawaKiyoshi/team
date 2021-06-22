package com.tokyomethod.web;

import java.util.ArrayList;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tokyomethod.beans.Employee;
import com.tokyomethod.dao.EmployeeDao;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/Jdbc")
public class SampleJdbcController {
	private static final Logger log = (Logger) LoggerFactory.getLogger(HelloValidateController.class);

	@RequestMapping(path = "/sample", method = RequestMethod.GET)
	private ModelAndView index(Employee form, ModelAndView mav) {
		ArrayList<Employee> emplist = EmployeeDao.getEmployeeList();
		mav.setViewName("sample/index");
		mav.addObject("list", emplist);
		return mav;
	}

	private void commoncreate(ModelAndView mav) {
		ArrayList<Employee> emplist = EmployeeDao.getEmployeeList();
		mav.setViewName("sample/index");
		mav.addObject("list", emplist);
	}

	//登録
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	private ModelAndView create(@Validated Employee form,
			BindingResult result,
			ModelAndView mav) {
		if (result.hasErrors()) {
			commoncreate(mav);
		} else {
			int ret = EmployeeDao.insertEmployee(form);
			if (ret == 0) {
				commoncreate(mav);
			} else {
				result.reject("com.tokyomethod.err.dbcreate", "default Message");
				mav.setViewName("redirect:/Jdbc/sample");
			}
		}
		return mav;
	}

	//削除
	@RequestMapping(path = "/delete")
	private ModelAndView delete(@RequestParam("id") String id,
			@Validated Employee form, //エラー設定のために追加
			BindingResult result, //エラー設定のために追加
			ModelAndView mav) {
		int ret = EmployeeDao.deleteEmployee(id);
		if (ret == 1) {
			result.reject("com.tokyomethod.err.dbdelete", "default Message");
			//エラー設定のために追加
			mav.setViewName("redirect:/Jdbc/sample");
		} else {
			mav.setViewName("sample/index");
		}
		return mav;
	}
	//更新
	@RequestMapping(path = "/update", method = RequestMethod.GET)
	private ModelAndView update(@RequestParam("id") String id,
			Employee form,
			ModelAndView mav) {
		ArrayList<Employee> emplist = EmployeeDao.getEmployeeListById(id);
		BeanUtils.copyProperties(emplist.get(0), form);
		mav.setViewName("/sample/edit");
		return mav;
	}

	@RequestMapping(path = "/update", params = "goToTop", method = RequestMethod.POST)
	private ModelAndView updateToTop(ModelAndView mav) {
		mav.setViewName("redirect:/Jdbc/sample");
		return mav;
	}

	@RequestMapping(path = "/update", params = "exec", method = RequestMethod.POST)
	private ModelAndView updateexec(@Validated Employee form,
			BindingResult result,
			ModelAndView mav) {
		if (result.hasErrors()) {
			mav.setViewName("sample/edit");
		} else {
			int ret = EmployeeDao.updateEmployee(form);
			if (ret != 1) {
				mav.setViewName("sample/edit");
				result.reject("com.tokyomethod.err.dbupdate", "default Message");
			} else {
				mav.setViewName("redirect:/Jdbc/sample");
			}
		}
		return mav;
	}
}
