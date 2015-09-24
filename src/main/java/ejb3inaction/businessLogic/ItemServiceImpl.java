package ejb3inaction.businessLogic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ejb3inaction.entities.ItemEntity;

@Stateless
public class ItemServiceImpl implements ItemService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ItemEntity getItem(Long itemId) {
		return entityManager.find(ItemEntity.class, itemId);
	}

	@Override
	public void createItem(ItemEntity item) {
		entityManager.persist(item);
	}
}
