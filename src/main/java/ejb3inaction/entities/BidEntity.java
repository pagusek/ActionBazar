package ejb3inaction.entities;

import java.math.BigDecimal;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;

@Named
@RequestScoped
@Entity
@Table(name = "BIDS")
public class BidEntity {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	private LocalDateTime bidDate;

	private BigDecimal bidPrice;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	private ItemEntity item;

	@ManyToOne
	@JoinColumn(name = "BIDDER_ID", referencedColumnName = "USER_ID")
	private BidderEntity bidder;

	public BidEntity() {
		// do nothing
	}

	public BidEntity(BidderEntity bidder, ItemEntity item, BigDecimal bidPrice) {
		this.item = item;
		this.bidder = bidder;
		this.bidPrice = bidPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getBidDate() {
		return bidDate;
	}

	public void setBidDate(LocalDateTime bidDate) {
		this.bidDate = bidDate;
	}

	public BigDecimal getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}

	public ItemEntity getItem() {
		return item;
	}

	public void setItem(ItemEntity item) {
		this.item = item;
	}

	public BidderEntity getBidder() {
		return bidder;
	}

	public void setBidder(BidderEntity bidder) {
		this.bidder = bidder;
	}

}
