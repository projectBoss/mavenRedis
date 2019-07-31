package com.entity;

import java.io.Serializable;

/**
 * 创建一个User实体对象   
 * @author Shinelon
 *
 */
public class UserEntity implements Serializable {
	/**
	 * xulihua
	 */
	private static final long serialVersionUID = 1L;
	private String uname;
	private String sex;
	private Integer age;
	private String FamilyAddress;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getFamilyAddress() {
		return FamilyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		FamilyAddress = familyAddress;
	}
	@Override
	public String toString() {
		return "UserEntity [uname=" + uname + ", sex=" + sex + ", age=" + age + ", FamilyAddress=" + FamilyAddress
				+ "]";
	}
	public UserEntity(String uname, String sex, Integer age, String familyAddress) {
		super();
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		FamilyAddress = familyAddress;
	}
	
}
