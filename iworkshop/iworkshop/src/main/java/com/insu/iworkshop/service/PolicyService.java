package com.insu.iworkshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insu.iworkshop.entities.Policy;

public interface PolicyService  {
	
	List<Policy> getAllPolicies();
	
	void savePolicy (Policy policy);
	Policy getPolicyById(long id);
	//void deletePolicyById(long id);

	Policy calculateTermPremium(Policy policy);
	
	Policy calculatePremium(Policy policy);
	
	
}
