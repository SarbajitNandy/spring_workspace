package com.infytel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plan {
	@Id
	@Column(name = "plan_id")
	private Integer plainId;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "local_rate")
	private Integer localRate;
	@Column(name = "national_rate")
	private Integer nationalRate;
	public Integer getPlainId() {
		return plainId;
	}
	public void setPlainId(Integer plainId) {
		this.plainId = plainId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public Integer getLocalRate() {
		return localRate;
	}
	public void setLocalRate(Integer localRate) {
		this.localRate = localRate;
	}
	public Integer getNationalRate() {
		return nationalRate;
	}
	public void setNationalRate(Integer nationalRate) {
		this.nationalRate = nationalRate;
	}
	@Override
	public String toString() {
		return "Plan [plainId=" + plainId + ", planName=" + planName + ", localRate=" + localRate + ", nationalRate="
				+ nationalRate + "]";
	}
	
	
	
	

}
