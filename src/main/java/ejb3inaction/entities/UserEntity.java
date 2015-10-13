package ejb3inaction.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserEntity implements Serializable {

	private String firstName;

	private String lastName;

	private byte[] picture;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date birthDate;

	public UserEntity(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
