package teste.EMF;

import br.com.frmichetti.dryutil.factory.EMF;

public class LoadEMF {

	public static void main(String ... args) {
		
		EMF emf = new EMF();
		
		emf.getEntityManager().getProperties().values().stream().forEach(System.out::println);

	}

}
