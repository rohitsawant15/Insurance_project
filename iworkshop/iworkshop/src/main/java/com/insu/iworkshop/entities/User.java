package com.insu.iworkshop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long uid;
	     
	    @Column(nullable = false, unique = true, length = 45)
	    private String email;
	     
	    @Column(nullable = false, length = 64)
	    private String password;
	     
	    @Column(name = "first_name", nullable = false, length = 20)
	    private String firstName;
	     
	    @Column(name = "last_name", nullable = false, length = 20)
	    private String lastName;

	    @Column(name = "role", nullable = false, length = 20)
	    private String role="CLIENT";
	    
		@OneToMany(cascade = CascadeType.MERGE,orphanRemoval = true)
	    private List<Policy> policy=new ArrayList<>();
		
		
		public List<Policy> getPolicy() {
			return policy;
		}

		public void setPolicy(List<Policy> policy) {
			this.policy = policy;
		}

		public Long getUid() {
			return uid;
		}

		public void setUid(Long uid) {
			this.uid = uid;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		

		
}
