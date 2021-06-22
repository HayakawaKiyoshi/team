package com.tokyomethod.beans;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
	private int emp_id;
	@NotEmpty(message="パスワードは、入力必須です。")
	 private String emp_pass;
	@NotEmpty(message="{0}：入力は必須です。")
	 @Size(min = 1,max=20,message="{min}文字数以上、{max}文字数以内を入力してください。")
	 private String emp_name;
	 private int gender;
	 @Size(min = 1,max=30,message="{min}文字数以上、{max}文字数以内を入力してください。")
	 private String address;
	 @NotNull(message="{0}：入力してください。")
	 @DateTimeFormat(pattern = "yyyy/MM/dd")
	 private Date birthday;
	 @Min(value=1,message="{0}:{value}以上です。")
	 private int post_id;
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_pass() {
		return emp_pass;
	}
	public void setEmp_pass(String emp_pass) {
		this.emp_pass = emp_pass;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
}
