package ejb3inaction.entities;

import java.io.Serializable;

import org.joda.time.LocalDate;

public class UserEntity implements Serializable {

	private String firstName;

	private String lastName;

	private byte[] picture;

	private LocalDate birthDate;

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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
