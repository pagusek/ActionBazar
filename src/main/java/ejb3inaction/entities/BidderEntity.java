package ejb3inaction.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BIDDER")
@NoArgsConstructor
public class BidderEntity extends UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	@Getter
	private Long id;

	@Getter
	@Setter
	private Long creditRating;

	public BidderEntity(String firstName, String lastName, Long creditRating) {
		super(firstName, lastName);
		this.creditRating = creditRating;
	}

	public BidderEntity(Long creditRating) {
		this.creditRating = creditRating;
	}
}
