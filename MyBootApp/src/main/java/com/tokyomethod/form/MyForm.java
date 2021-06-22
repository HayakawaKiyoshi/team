package com.tokyomethod.form;

import org.thymeleaf.util.StringUtils;

public class MyForm {
	 private String ftext;
	 private String ftdate;
	 private String ftnum;
	 private Integer fnum;
	 private String farea;
	 private String femail;
	 private String fpass;
	 private String fselect;
	 private String[] fmselect;
	 private String fcheck;
	 private String[] fchecks;
	 private String fradio;
	public String getFtext() {
		return ftext;
	}
	public void setFtext(String ftext) {
		this.ftext = ftext;
	}
	public String getFtdate() {
		return ftdate;
	}
	public void setFtdate(String ftdate) {
		this.ftdate = ftdate;
	}
	public String getFtnum() {
		return ftnum;
	}
	public void setFtnum(String ftnum) {
		this.ftnum = ftnum;
	}
	public Integer getFnum() {
		return fnum;
	}
	public void setFnum(Integer fnum) {
		this.fnum = fnum;
	}
	public String getFarea() {
		return farea;
	}
	public void setFarea(String farea) {
		this.farea = farea;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpass() {
		return fpass;
	}
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}
	public String getFselect() {
		return fselect;
	}
	public void setFselect(String fselect) {
		this.fselect = fselect;
	}
	public String[] getFmselect() {
		return fmselect;
	}
	public void setFmselect(String[] fmselect) {
		this.fmselect = fmselect;
	}
	public String getFcheck() {
		return fcheck;
	}
	public void setFcheck(String fcheck) {
		this.fcheck = fcheck;
	}
	public String[] getFchecks() {
		return fchecks;
	}
	public void setFchecks(String[] fchecks) {
		this.fchecks = fchecks;
	}
	public String getFradio() {
		return fradio;
	}
	public void setFradio(String fradio) {
		this.fradio = fradio;
	}

	 public String getFareaNl2br() {
		 if (!StringUtils.isEmpty(this.farea)) {
		 return this.farea.replaceAll("\n", "<br/>");
		 }
		 return "";
	 }
}
