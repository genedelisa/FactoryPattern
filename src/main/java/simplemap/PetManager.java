package simplemap;

import java.util.HashMap;
import java.util.Map;

import domain.Pet;

/**
 * To show what drivermanager does
 * 
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 * 
 */
public class PetManager {
	static Map<String, Class<?>> handlers = new HashMap<String, Class<?>>();

	static {
		try {
			register("fluffy", Class.forName("domain.Cat"));
			register("tweety", Class.forName("domain.Bird"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void register(String key, Class<?> c) {
		handlers.put(key, c);
		System.out.println("registered " + key);
	}

	public static Pet getPet(String key) {
		Pet p = null;
		try {
			Class<?> c = handlers.get(key);
			if (c == null) {
				System.err.println("No handler for " + key);
				return null;
			}
			p = (Pet) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return p;
	}
}
