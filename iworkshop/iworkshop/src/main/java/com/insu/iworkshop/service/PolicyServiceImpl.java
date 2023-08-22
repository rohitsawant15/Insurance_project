package com.insu.iworkshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insu.iworkshop.entities.Policy;
import com.insu.iworkshop.repo.Policyrepo;
@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private Policyrepo policyrepo;
	
	@Override
	public List<Policy> getAllPolicies() {
		return policyrepo.findAll();
	
		
	}

	@Override
	public void savePolicy(Policy policy) {
		// TODO Auto-generated method stub
		this.policyrepo.save(policy);
		
	}


	@Override
	public Policy getPolicyById(long id) {
		// TODO Auto-generated method stub
		Optional<Policy> optional = policyrepo.findById(id);
		Policy policy = null;
		 if (optional.isPresent()) {
	            policy = optional.get();
	        } else {
	            throw new RuntimeException(" Policy not found for id :: " + id);
	        }
	        return policy;
	}

	@Override
	public Policy calculateTermPremium(Policy policy) {
		// TODO Auto-generated method stub
		
		float p= Float.parseFloat(policy.getLifeCover());
		p=p*0.01f;
		int age=2022-Integer.parseInt(policy.getDob().substring(0, 4));
		String tobacco=policy.getTobacco();
		policy.setPremium(p);
		
		if(policy.getAccidentDeathBenifit().equals("Yes")) {
				p=p+120;
				p=this.calAge(p,age,tobacco);
				policy.setPremium(p);
			}

			if(policy.getComprehensiveCare().equals("Yes")) {
				p=p+120;
				p=this.calAge(p,age,tobacco);
			policy.setPremium(p);
			}
			
		
		if (policy.getPaymentMode().equals("Annual")) {

		p=p-(p*0.15f);

		p=this.calAge(p,age,tobacco);

		policy.setPremium(p);

		}

		else if(policy.getPaymentMode().equals("Half Yearly")){

		p=p-(p*0.1f);

		p=p/2;

		policy.setPremium(p);
		}
		else {

		p=p/12;

		policy.setPremium(p);

		}
		
	
	return policy;
	
}
	
	private float calAge(float p, int age, String tobacco) {
		if (age<25) {
		p=p;
		}
		else if (age<35) {
		p=p+p*0.1f;
		}
		else if (age<45) {
		p=p+p*0.2f;
		}
		else if (age<55) {
		p=p+p*0.3f;
		}
		else {
		p=p+p*0.4f;
		}
		if(tobacco.equals("Yes")) {
		p=p+p*0.25f;
		}
		return p;
		}
	
	
	
	

	@Override
	public Policy calculatePremium(Policy policy) {
		// TODO Auto-generated method stub
		float p= Float.parseFloat(policy.getLifeCover());
		int age=2022-Integer.parseInt(policy.getDob().substring(0, 4));	
		p=this.calAge(p, age);
		
		
		if(policy.getTobacco().equals("Yes")) {
			p=p+(p*0.20f);
			policy.setPremium(p);
		}
		p=p*0.01f;
		policy.setPremium(p);
		
		
		if (policy.getPaymentMode().equals("Annual")) {
		p=p-(p*0.15f);
		
		policy.setPremium(p);
		}
		
		else if(policy.getPaymentMode().equals("Half Yearly")){
			System.out.println("HALF...");
		p=p-(p*0.1f);
		p=p/2;
		policy.setPremium(p);
		}
		else {
		p=p/12;
		policy.setPremium(p);
		}
		System.out.println("IN METHOD....");
		return policy;
	}

	//Age Calculation
	private float calAge(float p, int age) {
		if (age<25) {

		p=p;

		}

		else if (age<35) {

		p=p+p*0.1f;

		}

		else if (age<45) {

		p=p+p*0.2f;

		}

		else if (age<55) {

		p=p+p*0.3f;

		}

		else {

		p=p+p*0.4f;

		}
		return p;
	}
	
}
	


	/*
	 * @Override public void deletePolicyById(long id) { // TODO Auto-generated
	 * method stub this.policyrepo.deleteById(id); }
	 */

