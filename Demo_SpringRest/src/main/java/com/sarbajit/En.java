package com.sarbajit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.lang.NonNull;

public class En {
	private String name;
	private int roll;
	private List<Integer> subs = new ArrayList<>();
	
	public En(String name, int roll, List<Integer> s) {
		this.name=name; this.roll=roll; this.subs=s;
	}
	public String getName() {
		return name;
	}
	public List<Integer> getSubs() {
		return subs;
	}
	public void setSubs(List<Integer> subs) {
		this.subs = subs;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "En [name=" + name + ", roll=" + roll + ", subs=" + subs + "]";
	}
}
