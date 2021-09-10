package com.infytel.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.stereotype.Repository;
import com.infytel.entity.Plan;

@Repository("planRepository")
public class PlanDAOImpl implements PlanDAO {

	private EntityManagerFactory entityManagerFactory;

	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public void updatePlan(Plan plan) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Plan newPlan = entityManager.find(Plan.class, plan.getPlanId());
		newPlan.setPlanId(plan.getPlanId());
		newPlan.setPlanName(plan.getPlanName());
		newPlan.setNationalRate(plan.getNationalRate());
		newPlan.setLocalRate(plan.getLocalRate());
		entityManager.persist(newPlan);
		entityManager.getTransaction().commit();

	}

}
