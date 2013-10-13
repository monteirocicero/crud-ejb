package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NamedQuery(name = "User.findUserByEmail", query = "select u from User u where u.email = :email")
@SequenceGenerator(name = User.USER_SEQUENCE_NAME, sequenceName = User.USER_SEQUENCE_NAME, allocationSize = 53)
public class User {

	public static final String FIND_BY_EMAIL = "User.findUserByEmail";
	public static final String USER_SEQUENCE_NAME = "USER_SEQUENCE_NAME_ID";

	private Integer id;
	private String email;
	private String password;
	private String name;
	private String role;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = USER_SEQUENCE_NAME)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(unique = true)
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public int hashCode() {
		return getId();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			User user = (User) obj;
			return user.getEmail().equals(getEmail());
		}
		return false;
	}

}
