package com.kenneth.wu;

import java.io.Serializable;

public class EMP1 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private int age;
	private String first;
	private String last;

	public EMP1() {
		this.age = 0;
		this.first = "";
		this.last = "";
	}

	public EMP1(int id, int age, String first, String last) {
		this.id = id;
		this.age = age;
		this.first = first;
		this.last = last;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

}
