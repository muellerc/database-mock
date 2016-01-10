package org.apache.cmueller.mock.database;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@Stateless
public class Index implements Serializable {

    @Inject
    DatabaseInitializer initializer;

    public Object reset() {
        initializer.init();
        return null;
    }
}
