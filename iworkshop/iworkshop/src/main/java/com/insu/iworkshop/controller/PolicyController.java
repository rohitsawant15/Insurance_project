package com.insu.iworkshop.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insu.iworkshop.entities.Policy;
import com.insu.iworkshop.entities.User;
import com.insu.iworkshop.repo.Policyrepo;
import com.insu.iworkshop.repo.UserRepo;
import com.insu.iworkshop.service.PolicyService;

@Controller
@RequestMapping("/users/")
public class PolicyController {


	@Autowired
	private PolicyService policyService;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private Policyrepo policyRepo;
	
	
	@GetMapping("/addpolicy")
	public String viewHomePage(Model model,Principal p) {
		String email = p.getName();
		User user = this.userRepo.findByEmail(email);
		List<Policy> listPolicy = this.policyRepo.findPolicyByUser(user.getUid());

		model.addAttribute("listPolicies",listPolicy );
        return "indexp";
	}
	
	 @GetMapping("/showNewPolicyForm")
	    public String showNewPolicyForm(Model model) {
	        // create model attribute to bind form data
	       Policy policy = new Policy();
	        model.addAttribute("policy", policy);
	        return "new_policy";
	    }
	 
		/*
		 * @PostMapping("/savePolicy") public String
		 * savePolicy(@ModelAttribute("policy") Policy policy) { // save employee to
		 * database policyService.savePolicy(policy); return "redirect:/";}
		 */
	
	 @GetMapping("/showFormForUpdate/{id}")
	    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

	        // get employee from the service
	        Policy policy = policyService.getPolicyById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("policy", policy);
	        return "update_policy";
	    }
	 
	 @GetMapping("/showFormForUpdate1/{id}")
	    public String showFormForUpdate1(@PathVariable(value = "id") long id, Model model) {

	        // get employee from the service
	        Policy policy = policyService.getPolicyById(id);

	        // set employee as a model attribute to pre-populate the form
	        model.addAttribute("policy", policy);
	        return "admin_update_policy";
	    }
	 
	 @GetMapping("/deletePolicy/{id}")
	 public String delete(@PathVariable(value = "id") long id, Model model) {

	 Policy policy = policyService.getPolicyById(id);
	 policy.setStatus("Cancelled");
	 policyService.savePolicy(policy);
	 return "redirect:/users/addpolicy";
	 }
	 
		

	 @PostMapping("/savePolicy")

	 public String savePolicy(@ModelAttribute("policy") Policy policy) {

	 // save policy to database

	 User u=userRepo.findByEmail(policy.getEmail());

	 policy.setUser(u);
//	 policy.setStatus("pending");
	System.out.println("IN CONTROLLER....");
	 
	 if(policy.getPolicyType().equals("Term insurance Policy")&& (policy.getAccidentDeathBenifit()!=null || policy.getComprehensiveCare()!= null )) {

		 policy=policyService.calculateTermPremium(policy);

		 }

		 else {
			 System.out.println("IN ELSE CONDITION....");
		 policy=policyService.calculatePremium(policy);
		 System.out.println("After METHOD....");
		 }
	 
	 policyService.savePolicy(policy);
	 if(policy.getPolicyType().equals("Term insurance Policy") && (policy.getAccidentDeathBenifit()==null || policy.getComprehensiveCare()== null )) {
		 return "termInsurance";
	 }

	 return "redirect:/users/addpolicy";

	 }
	 
		
		  @PostMapping("/savePolicy1")
		  
		  public String savePolicy1(@ModelAttribute("policy") Policy policy) {
				 User u=userRepo.findByEmail(policy.getEmail());
			  policy.setUser(u);
		  
		  policyService.savePolicy(policy);
		  
		  return "redirect:/users/admin/policy";
		  
		  }
		 

	 @GetMapping("/admin/policy")
	 public String viewHomePage1(Model model, Principal p) {
	 model.addAttribute("listpolicies", policyService.getAllPolicies());
	 return "AdminPolicy";
	 }




}
