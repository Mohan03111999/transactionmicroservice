package com.trainingapps.forex.transactionms.vo;

import java.time.LocalDate;

public class User {

	private Long userId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private String mobileNumber;
	private String country;
	private String address;
	private String state;
	private String city;
	private Long pincode;
	
	
	
	public User() {
		super();
	}



	public User(Long userId, String firstName, String lastName, LocalDate dob, String mobileNumber, String country,
			String address, String state, String city, Long pincode) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.country = country;
		this.address = address;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
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



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getMobileNumber() {
		return mobileNumber;
	}



	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public Long getPincode() {
		return pincode;
	}



	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", mobileNumber=" + mobileNumber + ", country=" + country + ", address=" + address + ", state="
				+ state + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
