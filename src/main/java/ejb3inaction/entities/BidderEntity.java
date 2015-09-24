package ejb3inaction.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BidderEntity extends UserEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	private Long creditRating;

	public BidderEntity() {
		// do nothing
	}

	public BidderEntity(String firstName, String lastName, Long creditRating) {
		super(firstName, lastName);
		this.creditRating = creditRating;
	}

	public BidderEntity(Long creditRating) {
		this.creditRating = creditRating;
	}

	public Long getId() {
		return id;
	}

	public Long getCreditRating() {
		return creditRating;
	}

	public void setCreditRating(Long creditRating) {
		this.creditRating = creditRating;
	}

}
