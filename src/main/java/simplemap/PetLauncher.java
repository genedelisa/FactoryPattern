package simplemap;

import domain.Pet;

/**
 * To show what drivermanager does
 * 
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 * 
 */
public class PetLauncher {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			Class.forName("domain.Dog");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Pet p = PetManager.getPet("fluffy");
		System.out.println(p);

		p = PetManager.getPet("fido");
		System.out.println(p);
	}

}
