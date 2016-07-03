package teste.EMF;

import br.com.frmichetti.dryutil.factory.singleton.EMF;

public class LoadSingletonEMF {

	public static void main(String ... args) {
		EMF.getInstance().getEntityManager().getProperties().values().stream().forEach(System.out::println);

	}

}
