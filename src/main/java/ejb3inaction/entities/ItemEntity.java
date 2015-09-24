package ejb3inaction.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.joda.time.LocalDate;

@Entity
@Table(name = "ITEMS")
public class ItemEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ITEM_ID")
	private Long id;

	private String itemName;

	private LocalDate bidEndDate;

	private LocalDate bidStartDate;

	private LocalDate createdDate;

	private BigDecimal initialPrice;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<BidEntity> bids;

	public ItemEntity() {
		// do nothing
	}

	public ItemEntity(Long id) {
		this.id = id;
	}

	public ItemEntity(String itemName, LocalDate bidStartDate, LocalDate creationDate, BigDecimal initialPrice) {
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

	public LocalDate getBidEndDate() {
		return bidEndDate;
	}

	public void setBidEndDate(LocalDate bidEndDate) {
		this.bidEndDate = bidEndDate;
	}

	public LocalDate getBidStartDate() {
		return bidStartDate;
	}

	public void setBidStartDate(LocalDate bidStartDate) {
		this.bidStartDate = bidStartDate;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
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
