package domain;

import fromproperties.PetManager;

/**
 *
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 *
 */
public class Bird implements Pet {
    static {
        PetManager.register("tweety", Bird.class);
    }
}
