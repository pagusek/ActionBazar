package ejb3inaction.web;

import javax.enterprise.inject.Produces;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb3inaction.businessLogic.BidServiceImpl;
import ejb3inaction.entities.BidEntity;
import ejb3inaction.entities.BidderEntity;
import ejb3inaction.entities.ItemEntity;

@Named
@RequestScoped
public class BidManager {

	@Inject
	private BidServiceImpl bidService;

	@Inject
	BidderEntity user;

	@Inject
	private ItemEntity item;
	private BidEntity bid = new BidEntity();

	@Produces
	@Named
	public BidEntity getBid() {
		return bid;
	}

	public String placeBid() {
		bid.setBidder(user);
		bid.setItem(item);
		// Incomplete bidService.addBid(bid);
		return "bid_confirm.xhtml";
	}
}
