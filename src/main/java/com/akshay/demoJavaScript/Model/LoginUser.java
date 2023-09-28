package com.akshay.demoJavaScript.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table
/*(uniqueConstraints = {
        @UniqueConstraint( name = "username", columnNames = "username")  
}) */
// @UniqueConstraint( name = "email", columnNames = "email")
public class LoginUser {
	
	

		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		@Column(name = "lu_Id")
		private int luId;
		
		@Column(name="username",unique = true)
		private String username;
		
		@Column(name="firstname")
		private String firstname;
		
		@Column(name="lastname")
		private String lastname;
		
		@Column(name="role")
		private String role;
		
		@Column(name="status")
		private String status;
		
		@Column(name="email",unique = true)
		private String email;
		
		@Column(name="entity")
		private String entity;
		
		@Column(name="department")
		private String department;
		
		@Column(name="designation")
		private String designation;

		public int getLuId() {
			return luId;
		}

		public void setLuId(int luid) {
			this.luId = luid;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getEntity() {
			return entity;
		}

		public void setEntity(String entity) {
			this.entity = entity;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		
		
		
		
	}

