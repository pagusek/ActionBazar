package ejb3inaction.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ITEMS")
@Getter
@Setter
@NoArgsConstructor
public class ItemEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ITEM_ID")
	private Long id;

	private String itemName;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date bidEndDate;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date bidStartDate;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createdDate;

	private BigDecimal initialPrice;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<BidEntity> bids;

	public ItemEntity(Long id) {
		this.id = id;
	}

	public ItemEntity(String itemName, Date bidStartDate, Date creationDate, BigDecimal initialPrice) {
		this.itemName = itemName;
		this.bidStartDate = bidStartDate;
		this.createdDate = creationDate;
		this.initialPrice = initialPrice;
	}

	public BidEntity addBid(BidEntity bid) {
		bids.add(bid);
		return bid;
	}

	public BidEntity removeBid(BidEntity bid) {
		bids.remove(bid);
		return bid;
	}

}
