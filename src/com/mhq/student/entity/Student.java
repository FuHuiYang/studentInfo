package com.mhq.student.entity;

public class Student {
	private String stu_id;
	private String stu_name;
	private int stu_achievement;
	private String stu_subject;
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public int getStu_achievement() {
		return stu_achievement;
	}
	public void setStu_achievement(int stu_achievement) {
		this.stu_achievement = stu_achievement;
	}
	public String getStu_subject() {
		return stu_subject;
	}
	public void setStu_subject(String stu_subject) {
		this.stu_subject = stu_subject;
	}
	@Override
	public String toString() {
		return "Student [stu_id=" + stu_id + ", stu_name=" + stu_name
				+ ", stu_achievement=" + stu_achievement + ", stu_subject="
				+ stu_subject + "]";
	}
	


}
