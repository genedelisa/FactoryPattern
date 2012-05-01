
package fromproperties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import domain.Pet;

/**
 * To show what drivermanager does
 * 
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 * 
 */
public class PetManager {

	static Map<String, Class<?>> handlers = new HashMap<String, Class<?>>();

	public static void register(String key, Class<?> c) {
		handlers.put(key, c);
	}

	public static Pet getPet() {
		Pet p = null;
		try {
			Class<?> c = determinePetClass("fluffy");
			p = (Pet) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return p;
	}

	/**
	 * like getConnection(url);
	 * 
	 * @param key
	 * @return
	 */
	public static Pet getPet(String key) {
		Pet p = null;
		Class<?> c = null;
		try {
			if (handlers.containsKey(key)) {
				c = handlers.get(key);
			} else {
				c = determinePetClass(key);
				handlers.put(key, c);
			}
			p = (Pet) c.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return p;
	}

	private static Class<?> determinePetClass(String key) {
		Class<?> c = null;
		// in case its specified via -D
		Properties p = new Properties(System.getProperties());
		try {
			// look on the classpath with the packagename as a path
			URL url = ClassLoader
					.getSystemResource("fromproperties/petconfig.properties");
			if (url != null) {
				p.load(url.openStream());
				System.out.println("loaded from classpath");
			}
			// and/or
			p.load(PetManager.class.getClassLoader().getResourceAsStream(
					"fromproperties/petconfig.properties"));

			String petClassName = p.getProperty(key);
			if (petClassName == null) {
				throw new IllegalArgumentException(key + " unknown");
			}
			c = Class.forName(petClassName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return c;
	}
}
