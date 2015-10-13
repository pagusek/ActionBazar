package ejb3inaction.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "ITEMS")
public class ItemEntity implements Serializable {

	@Id
	@GeneratedValue
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

	public ItemEntity() {
		// do nothing
	}

	public ItemEntity(Long id) {
		this.id = id;
	}

	public ItemEntity(String itemName, Date bidStartDate, Date creationDate, BigDecimal initialPrice) {
		this.itemName = itemName;
		this.bidStartDate = bidStartDate;
		this.createdDate = creationDate;
		this.initialPrice = initialPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public Date getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public BigDecimal getInitialPrice() {
		return initialPrice;
	}

	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}

	public List<BidEntity> getBids() {
		return bids;
	}

	public void setBids(List<BidEntity> bids) {
		this.bids = bids;
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
