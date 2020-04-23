package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    public static final boolean DEBUG = true;

    private static final PersistenceUtil pu= new PersistenceUtil();

    protected EntityManagerFactory emf;

    public static PersistenceUtil getInstance() {

        return pu;
    }

    private PersistenceUtil() {
    }

    public EntityManagerFactory getEntityManagerFactory() {

        if (emf == null)
            createEntityManagerFactory();
        return emf;
    }

    public void closeEntityManagerFactory() {

        if (emf != null) {
            emf.close();
            emf = null;
            if (DEBUG)
                System.out.println("n*** Persistence finished at " + new java.util.Date());
        }
    }

    protected void createEntityManagerFactory() {

        this.emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        if (DEBUG)
            System.out.println("n*** Persistence started at " + new java.util.Date());
    }
}