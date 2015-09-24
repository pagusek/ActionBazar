package ejb3inaction.businessLogic;

import javax.ejb.Local;

import ejb3inaction.entities.BidEntity;

@Local
public interface BidService {

	public void addBid(BidEntity bid);

}
