package com.tokyomethod.form;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MyDate {

	 @NotEmpty(groups = First.class,message="{0}:入力は必須です。")
	 @Size(min = 2, max = 30, groups = Second.class,message="{0}:{min}文字以上 {max}文字以下で入力してください。")
	 private String name;
	 @Email
	 private String email;
	 @Min(0)
	 @Max(100)
	 private Integer age;
	 private Date birth;
	 private Date from_period;
	 private Date to_period;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Date getFrom_period() {
		return from_period;
	}
	public void setFrom_period(Date from_period) {
		this.from_period = from_period;
	}
	public Date getTo_period() {
		return to_period;
	}
	public void setTo_period(Date to_priod) {
		this.to_period = to_priod;
	}
}