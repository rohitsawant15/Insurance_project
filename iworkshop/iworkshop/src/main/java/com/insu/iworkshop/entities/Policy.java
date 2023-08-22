package com.insu.iworkshop.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="policy_tbl")
public class Policy {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name="Policy_id", nullable=false)
	private long id;
	 
	 @Column(name="First_Name", nullable=false)
	private String firstName;
	 
	 @Column(name="Last_Name", nullable=false)
	private String lastName;
	 
	 @Column(name="Email_Id", nullable=false)
	private String email;
	 
	 @Column(name="DOB", nullable=false)
	private String dob;
	 
	 @Column(name="Gender", nullable=false )
	private String gender;
	 
	 @Column(name="PhoneNo", nullable=false, length=10 ) 
	private String phoneNo;
	 
	 @Column(name="Tobacco", nullable=false )
	private String tobacco;
	 
	 @Column(name="Life_Covered", nullable=false)
	private String lifeCover;
	 
	 @Column(name="Annual_Income", nullable=false)
	private int annualIncome;
	
	 @Column(name="Approval", nullable=false)
		private String status ="pending";
	
	 @Column(name="Policy_Type", nullable=false)
	private String policyType;
	 
	 @Column(name="Premium", nullable=false) 
	 private float premium;
	 
	 @Column(name="Payment_Mode", nullable=false)
	 private String paymentMode;
	
	 @Column(name="Payment_through", nullable=false)
	 private String paymentThrough;
	 
	 @Column(name="Accidental_Death")
	 private String accidentDeathBenifit;
	 
	 @Column(name="Comprehensive_Care")
	 private String comprehensiveCare;
	 
		/*
		 * @Column(name="Accidental_Cover" ) private String accidentCover value="25000";
		 * 
		 * @Column(name="Comprehensive Cover", nullable=false) private String
		 * comprehensiveCover value=200000f;
		 */
	 
	 
	 
	 
		/*
		 * public float getAccidentCover() { return accidentCover; } public void
		 * setAccidentCover(float accidentCover) { this.accidentCover = accidentCover; }
		 * public float getComprehensiveCover() { return comprehensiveCover; } public
		 * void setComprehensiveCover(float comprehensiveCover) {
		 * this.comprehensiveCover = comprehensiveCover;}
		 */
	
	public String getAccidentDeathBenifit() {
		return accidentDeathBenifit;
	}
	public void setAccidentDeathBenifit(String accidentDeathBenifit) {
		this.accidentDeathBenifit = accidentDeathBenifit;
	}
	public String getComprehensiveCare() {
		return comprehensiveCare;
	}
	public void setComprehensiveCare(String comprehensiveCare) {
		this.comprehensiveCare = comprehensiveCare;
	}
	public String getPaymentThrough() {
		return paymentThrough;
	}
	public void setPaymentThrough(String paymentThrough) {
		this.paymentThrough = paymentThrough;
	}
	@ManyToOne
	@JsonIgnore
	 private User user;
	
	 
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getLifeCover() {
		return lifeCover;
	}
	public void setLifeCover(String lifeCover) {
		this.lifeCover = lifeCover;
	}
	
	
	public int getAnnualIncome() {
		return annualIncome;
	}
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getTobacco() {
		return tobacco;
	}
	public void setTobacco(String tobacco) {
		this.tobacco = tobacco;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPolicyType() {
		return policyType;
	}
	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}
	public float getPremium() {
		return premium;
	}
	public void setPremium(float premium) {
		this.premium = premium;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return "Policy [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", gender=" + gender + ", phoneNo=" + phoneNo + ", tobacco=" + tobacco
				+ ", lifeCover=" + lifeCover + ", annualIncome=" + annualIncome + ", status=" + status + ", policyType="
				+ policyType + ", premium=" + premium + ", paymentMode=" + paymentMode + ", paymentThrough="
				+ paymentThrough + ", user=" + user + "]";
	}

	}

	