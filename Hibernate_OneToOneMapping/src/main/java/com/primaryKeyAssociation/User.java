package com.primaryKeyAssociation;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	private String user_name;

	@OneToOne(mappedBy = "user", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Address user_address;

	public User() {}

	public User(String user_name) {
		this.user_name = user_name;
	}

	public int getId() {
		return user_id;
	}

	public void setId(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return user_name;
	}

	public void setName(String user_name) {
		this.user_name = user_name;
	}

	public Address getAddress() {
		return user_address;
	}

	public void setAddress(Address user_address) {
		this.user_address = user_address;
	}

}
