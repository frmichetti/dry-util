package br.com.codecode.dryutil.teste.EMF;

import org.junit.Test;

import br.com.codecode.dryutil.factory.EMF;

public class LoadEMF {

    @Test
    public void test() {

	EMF emf = new EMF();

	emf.getEntityManager().getProperties().values()
		.stream().forEach(System.out::println);

    }

}
