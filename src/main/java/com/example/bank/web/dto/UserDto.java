package com.example.bank.web.dto;

public class UserDto {
	
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String adress;
	
	private String city;
	
	// String je jer negde pocinje ima i slova u ovom zipcodu
	private String zipCode;
	
	// String je a ne int ili long zbog + (tj pozivnog broja)
	private String phone;
	
	private String email;

	public UserDto(Long id, String firstName, String lastName, String adress, String city, String zipCode, String phone,
			String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.city = city;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
	}

	public UserDto() {
		super();
	}

	//getteri i setteri
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
