package simple;

import domain.Pet;

/**
 * The pet class is hardcoded. Not very flexible. Nothing is cached either.
 * 
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 * 
 */
public class PetManager {
	private static String petClassName = "domain.Cat";

	public static Pet getPet() {
		Pet p = null;
		try {
			Class<?> c = Class.forName(petClassName);
			p = (Pet) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return p;
	}
}
