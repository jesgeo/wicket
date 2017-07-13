package my.wicket.app.hello;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@SuppressWarnings("serial")
public class Customer implements Serializable, Cloneable {

	private Long id;

	private String firstName = "";

	private String lastName = "";

	private LocalDate registerDate;

	private Status status;

	private String email = "";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the value of email
	 *
	 * @return the value of email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the value of email
	 *
	 * @param email
	 *            new value of email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get the value of status
	 *
	 * @return the value of status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Set the value of status
	 *
	 * @param status
	 *            new value of status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * Get the value of birthDate
	 *
	 * @return the value of birthDate
	 */
	public LocalDate getRegisterDate() {
		return registerDate;
	}

	/**
	 * Set the value of birthDate
	 *
	 * @param birthDate
	 *            new value of birthDate
	 */
	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	/**
	 * Get the value of lastName
	 *
	 * @return the value of lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set the value of lastName
	 *
	 * @param lastName
	 *            new value of lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get the value of firstName
	 *
	 * @return the value of firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set the value of firstName
	 *
	 * @param firstName
	 *            new value of firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean isPersisted() {
		return id != null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (this.id == null) {
			return false;
		}

		if (obj instanceof Customer && obj.getClass().equals(getClass())) {
			return this.id.equals(((Customer) obj).id);
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 43 * hash + (id == null ? 0 : id.hashCode());
		return hash;
	}

	@Override
	public Customer clone() throws CloneNotSupportedException {
		return (Customer) super.clone();
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}