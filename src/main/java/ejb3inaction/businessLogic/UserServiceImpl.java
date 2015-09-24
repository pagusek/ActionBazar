package ejb3inaction.businessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb3inaction.entities.BidderEntity;

@Stateless
public class UserServiceImpl implements UserService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public BidderEntity getUser(Long userId) {
		return entityManager.find(BidderEntity.class, userId);
	}

	@Override
	public void createUser(BidderEntity bidder) {
		entityManager.persist(bidder);
	}
}
