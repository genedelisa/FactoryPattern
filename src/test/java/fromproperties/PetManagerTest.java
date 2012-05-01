package fromproperties;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import domain.Pet;

public class PetManagerTest {

	@Test
	public void testGetPet() {
		Pet fluffy = PetManager.getPet();
		assertNotNull(fluffy);
		System.out.println(fluffy);

		Pet momo = PetManager.getPet();
		assertNotNull(momo);
		assertNotSame(momo, fluffy);
		System.out.println(momo);
	}
}
