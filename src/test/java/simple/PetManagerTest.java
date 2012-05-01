package simple;

import domain.Pet;
import junit.framework.TestCase;

public class PetManagerTest extends TestCase {

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
