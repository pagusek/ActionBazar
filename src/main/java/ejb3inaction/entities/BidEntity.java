package ejb3inaction.entities;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Named
@RequestScoped
@Entity
@Table(name = "BIDS")
@Getter
@Setter
@NoArgsConstructor
public class BidEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Temporal(javax.persistence.TemporalType.DATE)
	private Date bidDate;

	private Double bidPrice;

	@ManyToOne
	@JoinColumn(name = "ITEM_ID", referencedColumnName = "ITEM_ID")
	private ItemEntity item;

	@ManyToOne
	@JoinColumn(name = "BIDDER_ID", referencedColumnName = "USER_ID")
	private BidderEntity bidder;

	public BidEntity(BidderEntity bidder, ItemEntity item, Double bidPrice) {
		this.item = item;
		this.bidder = bidder;
		this.bidPrice = bidPrice;
	}

}
