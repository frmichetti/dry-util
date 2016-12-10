package br.com.codecode.dryutil;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TesteFile {

    @Test
    public void test() {

	File f = new File(".");

	try {

	    System.out.println(f.getPath());

	    System.out.println("Caminho existe ? : " + f.exists());

	    System.out.println("É um diretório ? : " + f.isDirectory());

	    System.out.println("Está oculto ? : " + f.isHidden());

	    System.out.println("Caminho Absoluto : " + f.getAbsolutePath());

	    System.out.println("Caminho Canonico : " + f.getCanonicalPath());

	    System.out.println("Permissôes");

	    System.out.println("Execução : " + f.canExecute());

	    System.out.println("Leitura : " + f.canRead());

	    System.out.println("Escrita : " + f.canWrite());

	    if (f.isDirectory()) {

		System.out.println("Conteúdo da Pasta");

		for (String file : f.list()) {

		    System.out.println(file);

		}

	    }

	} catch (IOException e) {

	    throw new RuntimeException(e);

	}

    }

}
