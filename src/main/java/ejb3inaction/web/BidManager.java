package ejb3inaction.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import ejb3inaction.businessLogic.BidService;
import ejb3inaction.entities.BidEntity;
import ejb3inaction.entities.BidderEntity;
import ejb3inaction.entities.ItemEntity;

@Named
public class BidManager {

	@EJB
	private BidService bidService;

	@Inject
	private BidderEntity user;

	@Inject
	private ItemEntity item;
	private BidEntity bid = new BidEntity();

	@Produces
	@Named
	@RequestScoped
	public BidEntity getBid() {
		return bid;
	}

	public String placeBid() {
		bid.setBidder(user);
		bid.setItem(item);
		// Incomplete bidService.addBid(bid);
		return "confirm.xhtml";
	}
}