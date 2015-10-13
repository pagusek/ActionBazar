package ejb3inaction.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;

public class UserEntity implements Serializable {

	private String firstName;

	private String lastName;

	private byte[] picture;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date birthDate;

	public UserEntity() {
		// do nothing
	}

	public UserEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
