package ejb3inaction.businessLogic;

import java.math.BigDecimal;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.joda.time.LocalDate;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import ejb3inaction.entities.BidderEntity;
import ejb3inaction.entities.ItemEntity;

@RunWith(Arquillian.class)
public class ItemServiceImplTest {

	@Inject
	private ItemServiceImpl itemService;

	@Deployment
	public static Archive<?> createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.war");
		jar.addClasses(ItemService.class, ItemServiceImpl.class, BidderEntity.class, BidderEntity.class, ItemEntity.class);
		jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));
		return jar;
	}

	@Test
	@Ignore
	public void testGetItem() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testCreateItem() {
		ItemEntity item = new ItemEntity("Apple IIGS", new LocalDate(), new LocalDate(), new BigDecimal(45));
		itemService.createItem(item);
		Assert.assertNotNull(item.getId());
		Assert.assertNotNull(itemService.getItem(item.getId()));
	}
}
