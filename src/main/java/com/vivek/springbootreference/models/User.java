package com.vivek.springbootreference.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	private String Id;
	
    public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@NotNull
    @NotEmpty
    private String firstName;
     
    @NotNull
    @NotEmpty
    private String lastName;
     
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
     
    @NotNull
    @NotEmpty
    private String email;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
     
    
}