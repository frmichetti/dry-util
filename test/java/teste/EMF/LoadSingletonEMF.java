package teste.EMF;

import frmichetti.com.dry.factory.singleton.EMF;

public class LoadSingletonEMF {

	public static void main(String ... args) {
		EMF.getInstance().getEntityManager().getProperties().values().stream().forEach(System.out::println);

	}

}
