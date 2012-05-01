package domain;

// watch out in this example
// we have a bunch of managers!
// never a good thing to have a bunch of managers
import simplemap.PetManager;

/**
 *
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 *
 */
public class Dog implements Pet {
    
    static {
        PetManager.register("fido", Dog.class);
    }

}
