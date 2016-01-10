package org.apache.cmueller.mock.database;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Logger;

@Singleton
@Startup
public class DatabaseInitializer {

    private Logger log = Logger.getLogger(this.getClass().getName());

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    @PostConstruct
    public void init() {
        log.info("resetting the database...");

        try (Scanner s = new Scanner(DatabaseInitializer.class.getResourceAsStream("/init.sql"));) {
            s.useDelimiter(";");

            while (s.hasNext()) {
                em.createNativeQuery(s.next()).executeUpdate();
            }
        }

        log.info("database reset");
    }
}