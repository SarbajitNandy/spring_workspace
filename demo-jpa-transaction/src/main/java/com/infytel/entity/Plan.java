package com.infytel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.infytel.dto.PlanDTO;

@Entity
public class Plan {
	@Id
	@Column(name = "plan_id")
	private Integer planId;
	@Column(name = "plan_name")
	private String planName;
	@Column(name = "local_rate")
	private Integer localRate;
	@Column(name = "national_rate")
	private Integer nationalRate;
	
	
	public Plan() {
		super();

	}
	
	
	
	public Plan(Integer planId, String planName, Integer localRate, Integer nationalRate) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.localRate = localRate;
		this.nationalRate = nationalRate;
	}



	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
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
		return "Plan [plainId=" + planId + ", planName=" + planName + ", localRate=" + localRate + ", nationalRate="
				+ nationalRate + "]";
	}
	
	
	public static PlanDTO preparePlaDTO(Plan planEntity)
	{
	
		return new PlanDTO(planEntity.getPlanId(), planEntity.getPlanName(), planEntity.getLocalRate(), planEntity.getNationalRate());
	}
	

}
