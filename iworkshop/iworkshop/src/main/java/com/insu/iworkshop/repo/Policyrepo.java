package com.insu.iworkshop.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.insu.iworkshop.entities.Policy;

@Repository
public interface Policyrepo extends JpaRepository<Policy, Long> {
		
	/*
	 * @Query("from Policy as p where p.user.id =:userId") public List<Policy>
	 * findPolicyByUser(@Param("userId") Long userId);
	 */
	
	@Query("SELECT p FROM Policy p WHERE p.user.id = ?1")

	List<Policy> findPolicyByUser(Long id);
	
	
//	public setStatusCancelled(Long id);
}
