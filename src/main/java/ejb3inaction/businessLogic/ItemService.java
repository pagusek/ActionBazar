package ejb3inaction.businessLogic;

import javax.ejb.Local;

import ejb3inaction.entities.ItemEntity;

@Local
public interface ItemService {

	public ItemEntity getItem(Long itemId);

	public void createItem(ItemEntity item);

}
