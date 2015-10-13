package ejb3inaction.businessLogic;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import ejb3inaction.entities.BidEntity;
import ejb3inaction.entities.BidderEntity;
import ejb3inaction.entities.ItemEntity;
import ejb3inaction.entities.UserEntity;

@RunWith(Arquillian.class)
public class ItemServiceImplTest {

	@Inject
	private ItemServiceImpl itemService;

	@Deployment
	public static Archive<?> createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class, "test.jar");
		jar.addClasses(BidService.class, BidServiceImpl.class, ItemService.class, ItemServiceImpl.class, UserService.class, UserServiceImpl.class,
				BidderEntity.class, BidEntity.class, ItemEntity.class, UserEntity.class, ItemServiceImplTest.class);
		// jar.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		System.out.println(jar.toString(true));

		final EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "test.war").addAsLibrary(jar);
		return ear;
	}

	@Test
	@Ignore
	public void testGetItem() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

	@Test
	public void testCreateItem() {
		ItemEntity item = new ItemEntity("Apple IIGS", new Date(), new Date(), new BigDecimal(45));
		itemService.createItem(item);
		Assert.assertNotNull(item.getId());
		Assert.assertNotNull(itemService.getItem(item.getId()));
	}
}
