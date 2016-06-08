/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.dry.factory.singleton;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import frmichetti.com.dry.LoadProperties;

public final class EMF {

	private static EMF instance;

	private EntityManager entityManager;

	private static String persistenceUnity;

	private Properties properties;

	public static EMF getInstance() {

		if (instance == null) {

			instance = new EMF();

		}

		return instance;
	}

	private EMF() {
		
		try {
			
			properties = LoadProperties.readProperties(new File("./src/resources/META-INF/properties.properties"));

			persistenceUnity = properties.getProperty("persistenceUnity");


		} catch (IOException e) {

			throw new RuntimeException("File properties Not Found ", e);
		}

		entityManager = getEntityManager();
	}


	public EntityManager getEntityManager() {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(persistenceUnity);

		if (entityManager == null) {

			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}
}
