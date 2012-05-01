package domain;

import fromproperties.PetManager;

/**
 *
 * @author <a href="mailto:gene@rockhoppertech.com">Gene De Lisa</a>
 *
 */
public class Cat implements Pet {
    
    static {
        PetManager.register("fluffy", Cat.class);
    }

}
