package com.tokyomethod.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tokyomethod.beans.DataObject;
import com.tokyomethod.beans.Hoge;
import com.tokyomethod.form.MyForm;

@Controller
@RequestMapping("/Thyme")
public class HelloThymeleafController {
	//変更

	//1
	@RequestMapping(path = "sample1", method = RequestMethod.GET)
	private ModelAndView index1(ModelAndView mav) {
		mav.setViewName("thyme/index");
		mav.addObject("msg", "Hello Thymeleaf!!");
		return mav;
	}

	//2
	@RequestMapping(path = "sample2", method = RequestMethod.GET)
	private ModelAndView index2(ModelAndView mav) {
		mav.setViewName("thyme/index02");
		mav.addObject("msg", "Hello Thymeleaf!!");
		return mav;
	}

	//3
	@RequestMapping(path = "sample3", method = RequestMethod.GET)
	private ModelAndView index3(ModelAndView mav) {
		mav.setViewName("thyme/index03");
		mav.addObject("msg", "Hello Thymeleaf!! パラメーターへのアクセス");
		return mav;
	}

	//5
	@RequestMapping(path = "sample5", method = RequestMethod.GET)
	private ModelAndView index5(ModelAndView mav) {
		mav.setViewName("thyme/index05");
		mav.addObject("msg", "Hello Thymeleaf!! メッセージ式");
		return mav;
	}

	//6
	@RequestMapping(path = "sample6", method = RequestMethod.GET)
	private ModelAndView index6(ModelAndView mav) {
		mav.setViewName("thyme/index06");
		mav.addObject("msg", "Hello Thymeleaf!! リンク式");
		mav.addObject("obj", "123456");
		return mav;
	}

	//7
	@RequestMapping(path = "sample7", method = RequestMethod.GET)
	private ModelAndView index7(ModelAndView mav) {
		mav.setViewName("thyme/index07");
		mav.addObject("msg", "Hello Thymeleaf!! 選択オブジェクト");
		DataObject obj = new DataObject(123, "早河", "hayakawa@tokyomethod.com");
		mav.addObject("obj", obj);
		return mav;

	}

	//8
	@RequestMapping(path = "sample8", method = RequestMethod.GET)
	private ModelAndView index8(ModelAndView mav) {
		mav.setViewName("thyme/index08");
		mav.addObject("msg", "Hello Thymeleaf!! リテラル置換");
		DataObject obj = new DataObject("早河", "hayakawa@tokyomethod.com");
		mav.addObject("obj", obj);
		return mav;
	}

	//9
	@RequestMapping(path = "sample9", method = RequestMethod.GET)
	private ModelAndView index9(ModelAndView mav) {
		mav.setViewName("thyme/index09");
		mav.addObject("msg", "Hello Thymeleaf!! HTMLコードの出力");
		mav.addObject("msg1", "message 1<hr/>message 2<br />message 3");
		return mav;
	}

	//10
	@RequestMapping(value = "sample10/{id}", method = RequestMethod.GET)
	private ModelAndView index10(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("thyme/index10");
		mav.addObject("msg", "Hello Thymeleaf!! 条件式");
		mav.addObject("id", id);
		mav.addObject("check", id % 2 == 0);
		mav.addObject("trueVal", "偶数");
		mav.addObject("falseVal", "奇数");
		return mav;
	}

	//11
	@RequestMapping(value = "sample11/{id}", method = RequestMethod.GET)
	private ModelAndView index11(@PathVariable int id, ModelAndView mav) {
		mav.setViewName("thyme/index11");
		mav.addObject("msg", "Hello Thymeleaf!! 条件分岐");
		mav.addObject("id", id);
		mav.addObject("check", id >= 0);
		mav.addObject("trueVal", "正数！");
		mav.addObject("falseVal", "負数・・・");
		return mav;
	}

	//12
	@RequestMapping(value = "sample12/{month}", method = RequestMethod.GET)
	private ModelAndView index12(@PathVariable int month, ModelAndView mav) {
		mav.setViewName("thyme/index12");
		mav.addObject("msg", "Hello Thymeleaf!! 多項分岐");
		int m = Math.abs(month) % 12;//引数に指定した値の絶対値(0からどれだけ離れているか)を取得
		m = m == 0 ? 12 : m;
		mav.addObject("month", m);
		mav.addObject("check", Math.floor(m / 3));//小数点以下の端数を切り捨てる
		return mav;
	}

	//13
	@RequestMapping(value = "sample13", method = RequestMethod.GET)
	private ModelAndView index13(ModelAndView mav) {
		mav.setViewName("thyme/index13");
		mav.addObject("msg", "Hello Thymeleaf!! 繰り返し");
		ArrayList<String[]> data = new ArrayList<String[]>();
		data.add(new String[] { "taro", "taro@yamada", "090-999-999" });
		data.add(new String[] { "hanako", "hanako@flower", "080-888-888" });
		data.add(new String[] { "ssachiko", "sachiko@happy", "070-777-777" });
		mav.addObject("data", data);
		return mav;
	}

	//14
	@RequestMapping(value = "sample14/{num}", method = RequestMethod.GET)
	private ModelAndView index14(@PathVariable int num, ModelAndView mav) {
		mav.setViewName("thyme/index14");
		mav.addObject("msg", "Hello Thymeleaf!! プリプロセッシング");
		mav.addObject("num", num);
		if (num >= 0) {
			mav.addObject("check", "num >=data.size() ? 0 : num");
		} else {
			mav.addObject("check", "num <=data.size() * -1 ? 0 : num * -1");
		}
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0, "taro", "taro@yamada"));
		data.add(new DataObject(1, "hanako", "hanako@flower"));
		data.add(new DataObject(2, "sachiko", "sachiko@happy"));
		mav.addObject("data", data);
		return mav;
	}

	//15
	@RequestMapping(value = "sample15", method = RequestMethod.GET)
	private ModelAndView index15(ModelAndView mav) {
		mav.setViewName("thyme/index15");
		mav.addObject("msg", "Hello Thymeleaf!! インライン");
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0, "taro", "taro@yamada"));
		data.add(new DataObject(1, "hanako", "hanako@flower"));
		data.add(new DataObject(2, "sachiko", "sachiko@happy"));
		mav.addObject("data", data);
		return mav;
	}

	//16
	@RequestMapping(value = "sample16", method = RequestMethod.GET)
	private ModelAndView index16(ModelAndView mav) {
		mav.setViewName("thyme/index16");
		mav.addObject("msg", "Hello Thymeleaf!! javascriptのインライン");
		return mav;
	}

	//17
	@RequestMapping(value = "sample17", method = RequestMethod.GET)
	private ModelAndView index17(ModelAndView mav) {
		mav.setViewName("thyme/index17");
		mav.addObject("msg", "Hello Thymeleaf!! フィールド・プロパティ・メソッドの参照");
		mav.addObject("hoge", new Hoge());
		return mav;
	}

	//18
	@RequestMapping(value = "sample18", method = RequestMethod.GET)
	private ModelAndView index18(ModelAndView mav) {
		mav.setViewName("thyme/index18");
		mav.addObject("msg", "Hello Thymeleaf!! Mapの参照");
		HashMap<String, String> map = new HashMap<>();
		map.put("message", "Hello World!!");
		mav.addObject("map", map);
		return mav;
	}

	//19
	@RequestMapping(value = "sample19", method = RequestMethod.GET)
	private ModelAndView index19(ModelAndView mav) {
		mav.setViewName("thyme/index19");
		mav.addObject("msg", "Hello Thymeleaf!! Listの参照");
		mav.addObject("list", Arrays.asList(1, 2, 3));
		return mav;
	}

	//20
	@RequestMapping(value = "sample20", method = RequestMethod.GET)
	private ModelAndView index20(ModelAndView mav) {
		mav.setViewName("thyme/index20");
		return mav;
	}

	//layout1
	@RequestMapping(value = "sample22_01_content1", method = RequestMethod.GET)
	private ModelAndView index21(ModelAndView mav) {
		mav.setViewName("thyme/sample22_01_content1");
		mav.addObject("msg", "Hello Thymeleaf!! フラグメント1");
		return mav;
	}

	@RequestMapping(value = "sample22_01_content2", method = RequestMethod.GET)
	private ModelAndView index22(ModelAndView mav) {
		mav.setViewName("thyme/sample22_01_content2");
		mav.addObject("msg", "Hello Thymeleaf!!　フラグメント2");
		return mav;
	}

	//layout2
	@RequestMapping(value = "sample22_02_content1", method = RequestMethod.GET)
	private ModelAndView index22_02_01(ModelAndView mav) {
		mav.setViewName("thyme/index22_02_content1");
		mav.addObject("msg", "Hello Thymeleaf!! レイアウト １");
		return mav;
	}

	@RequestMapping(value = "sample22_02_content2", method = RequestMethod.GET)
	private ModelAndView index22_02_02(ModelAndView mav) {
		mav.setViewName("thyme/index22_02_content2");
		mav.addObject("msg", "Hello Thymeleaf!! レイアウト ２");
		return mav;
	}

	//bootstrap
	@RequestMapping(value = "sample22", method = RequestMethod.GET)
	private ModelAndView index22_2(ModelAndView mav) {
		mav.setViewName("thyme/index22");
		mav.addObject("msg", "Hello Thymeleaf!! レイアウト");
		return mav;
	}

	//form
	/**
	 * selectの表示に使用するアイテム
	 */
	 final static Map<String, String> SELECT_ITEMS =
	 Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	 {
	 put("選択_A", "A");
	 put("選択_B", "B");
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
	 */ final static Map<String, String> RADIO_ITEMS =
	 Collections.unmodifiableMap(new LinkedHashMap<String, String>() {
	 {
	 put("ラジオボタン_A", "A");
	 put("ラジオボタン_B", "B");
	 put("ラジオボタン_C", "C");
	 put("ラジオボタン_D", "D");
	 put("ラジオボタン_E", "E");
	 }
	 });

	@RequestMapping(value="sample23",method=RequestMethod.GET)
	 private ModelAndView index23(MyForm form,
	 ModelAndView mav){
	 mav.setViewName("thyme/index23");
	 mav.addObject("msg", "Hello Thymeleaf!! フォーム連携入力画面");
	 mav.addObject("selectItems", SELECT_ITEMS);
	 mav.addObject("checkItems", CHECK_ITEMS);
	 mav.addObject("radioItems", RADIO_ITEMS);
	 return mav;
	 }
	 @RequestMapping(value = "/sample23/confirm", method = RequestMethod.POST)
	 public ModelAndView confirm(@ModelAttribute MyForm form,
	 ModelAndView mav) {
	 mav.setViewName("thyme/index23_confirm");
	 mav.addObject("msg", "Hello Thymeleaf!! フォーム連携確認画面");
	 return mav;
	 }
}
