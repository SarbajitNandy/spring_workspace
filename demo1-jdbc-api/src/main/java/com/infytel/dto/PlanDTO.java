package com.infytel.dto;

import com.infytel.entity.Plan;

public class PlanDTO {

	private Integer planId;

	private String planName;

	private Integer localRate;

	private Integer nationalRate;

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
		return "Plan [planId=" + planId + ", planName=" + planName + ", localRate=" + localRate + ", nationalRate="
				+ nationalRate + "]";
	}

	public static Plan preparePlanEntity(PlanDTO planDTO) {
		Plan planEntity = new Plan();
		planEntity.setPlanId(planDTO.getPlanId());
		planEntity.setPlanName(planDTO.getPlanName());
		planEntity.setLocalRate(planDTO.getLocalRate());
		planEntity.setNationalRate(planDTO.getNationalRate());
		return planEntity;
	}
}
