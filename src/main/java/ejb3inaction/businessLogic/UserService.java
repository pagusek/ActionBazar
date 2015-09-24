package ejb3inaction.businessLogic;

import javax.ejb.Local;

import ejb3inaction.entities.BidderEntity;

@Local
public interface UserService {

	public BidderEntity getUser(Long userId);

	public void createUser(BidderEntity bidder);

}
