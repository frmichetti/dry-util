package br.com.codecode.dryutil.factory.singleton;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.codecode.dryutil.LoadProperties;

public final class EMF {

    private static EMF instance;

    private static String persistenceUnity;

    private EntityManager entityManager;

    private Properties properties;

    private EMF() {

	try {

	    properties = LoadProperties.readProperties(new File("./src/resources/META-INF/properties.properties"));

	    persistenceUnity = properties.getProperty("persistenceUnity");

	} catch (IOException e) {

	    throw new RuntimeException("File properties Not Found ", e);
	}

	entityManager = getEntityManager();
    }

    public static synchronized EMF getInstance() {

	if (instance == null) {

	    instance = new EMF();

	}

	return instance;
    }

    public EntityManager getEntityManager() {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnity);

	if (entityManager == null) {

	    entityManager = factory.createEntityManager();
	}

	return entityManager;
    }
}
