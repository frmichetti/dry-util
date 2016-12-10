package br.com.codecode.dryutil.teste.EMF;

import br.com.codecode.dryutil.factory.singleton.EMF;

public class LoadSingletonEMF {

    public static void main(String... args) {

	EMF.getInstance().getEntityManager().getProperties().values().stream().forEach(System.out::println);

    }

}
