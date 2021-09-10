package com.infytel.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infytel.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer>{
	//Method to update Plan details in DB
	@Transactional
	@Modifying
	 @Query(value = "update  Plan set local_rate = ?, national_rate=? " + " where plan_id = ?", nativeQuery = true)
	public void updatePlan(Integer localRate, Integer nationalRate, Integer planId);

}
