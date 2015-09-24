package ejb3inaction.businessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb3inaction.entities.BidEntity;

@Stateless
public class BidServiceImpl implements BidService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addBid(BidEntity bid) {
		entityManager.persist(bid);
	}

}
