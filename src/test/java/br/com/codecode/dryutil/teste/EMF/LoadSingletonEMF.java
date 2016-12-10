package br.com.codecode.dryutil.teste.EMF;

import org.junit.Test;

import br.com.codecode.dryutil.factory.singleton.EMF;

public class LoadSingletonEMF {

    @Test
    public void test() {

	EMF.getInstance().getEntityManager().getProperties().values()
		.stream().forEach(System.out::println);

    }

}
