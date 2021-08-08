package ua.lviv.lgs.domain;

import java.util.Objects;

public class User {
	private Integer id;
	private String email;
	private String firstname;
	private String lastname;
	private String role;
	public User(String email, String firstname, String lastname, String role) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}
	public User(int id, String email, String firstname, String lastname, String role) {
		this.id = id;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", role="
				+ role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(role, other.role);
	}
	
	
}
