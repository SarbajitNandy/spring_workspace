package com.infytel.dto;

import com.infytel.entity.Plan;

public class PlanDTO {
	
	private Integer plainId;
	
	private String planName;
	
	private Integer localRate;
	
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
	
	public static Plan preparePlanEntity(PlanDTO planDTO)
	{
		Plan planEntity = new Plan();
		planEntity.setPlainId(planDTO.getPlainId());
		planEntity.setPlanName(planDTO.getPlanName());
		planEntity.setLocalRate(planDTO.getLocalRate());
		planEntity.setNationalRate(planDTO.getNationalRate());
		return planEntity;
	}
	
	

}
