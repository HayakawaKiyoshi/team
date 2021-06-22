package com.tokyomethod.web;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tokyomethod.form.All;
import com.tokyomethod.form.MyDate;
import com.tokyomethod.form.MyForm1;

@Controller
@RequestMapping("/Validate")

public class HelloValidateController {
	//
	 /**
	 * 　@author nagasawa 変更 Git確認のため
	 */
	 final static Map<String, String> SELECT_ITEMS =
	 Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	 {
	 put("選択_A", "A"); put("選択_B", "B");
	 put("選択_C", "C");
	 put("選択_D", "D");
	 put("選択_E", "E");
	 }
	 });
	 /**
	 * check boxの表示に使用するアイテム
	 */
	 final static Map<String, String> CHECK_ITEMS =
	 Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	 {
	 put("チェックボックス_A", "A");
	 put("チェックボックス_B", "B");
	 put("チェックボックス_C", "C");
	 put("チェックボックス_D", "D");
	 put("チェックボックス_E", "E");
	 }
	 });
	 /**
	 * radio buttonの表示に使用するアイテム
	 */
	 final static Map<String, String> RADIO_ITEMS =
	 Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	 {
	 put("ラジオボタン_A", "A");
	 put("ラジオボタン_B", "B");
	 put("ラジオボタン_C", "C");
	 put("ラジオボタン_D", "D");
	 put("ラジオボタン_E", "E");
	 }
	 });
	 @RequestMapping(value="sample1",method=RequestMethod.GET)
	 private ModelAndView index1(MyForm1 form,
	 ModelAndView mav){
	 mav.setViewName("validate/index1");
	 mav.addObject("msg", "Hello!! フォーム連携入力画面");
	 mav.addObject("selectItems", SELECT_ITEMS);
	 mav.addObject("checkItems", CHECK_ITEMS);
	 mav.addObject("radioItems", RADIO_ITEMS);
	 return mav;
	 }
	 @RequestMapping(value = "/sample1/confirm", method = RequestMethod.POST)
	 public ModelAndView confirm(@Validated MyForm1 form,
	 BindingResult result,
	 ModelAndView mav) {
	 if(result.hasErrors()) { //エラーチェック
	 mav.setViewName("validate/index1");
	 mav.addObject("msg", "Hello Thymeleaf!! 不正な値が入力されました。");
	 mav.addObject("selectItems", SELECT_ITEMS);
	 mav.addObject("checkItems", CHECK_ITEMS);
	 mav.addObject("radioItems", RADIO_ITEMS);
	 }else {
	 mav.setViewName("validate/index1_confirm");
	 mav.addObject("msg", "Hello Thymeleaf!! フォーム連携確認画面");
	 }
	 return mav;
	 }
	 //sample2
	 @RequestMapping(value="sample2",method=RequestMethod.GET)
	 private ModelAndView index2(MyDate form,
	 ModelAndView mav){
	 mav.setViewName("validate/index2");
	 mav.addObject("msg", "Hello Thymeleaf!! Validate画面 日本語");
	 return mav;
	 }
	 @RequestMapping(value = "/sample2/confirm", method = RequestMethod.POST)
	 public ModelAndView confirm2(@Validated(All.class) MyDate form,
	 BindingResult result,
	 ModelAndView mav) {
	 if(result.hasErrors()) { //エラーチェック
	 mav.setViewName("validate/index2");
	 mav.addObject("msg", "Hello Thymeleaf!! 不正な値が入力されました。");
	 }else {
	 mav.setViewName("validate/index2_confirm");
	 mav.addObject("msg", "Hello Thymeleaf!! フォーム連携確認画面");
	 }
	 return mav;
	 }

}

