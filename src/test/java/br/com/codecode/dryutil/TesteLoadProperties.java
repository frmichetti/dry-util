package br.com.codecode.dryutil;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import org.junit.Test;

import br.com.codecode.dryutil.LoadProperties;

public class TesteLoadProperties {

    @Test
    public void test() throws Exception {

	File file = new File("./src/main/resources/META-INF");

	System.out.println("File exists ? " + file.exists());

	if (file.exists()) {

	    file = new File(file.getCanonicalPath());

	} else {

	    throw new RuntimeException("File / Path not found", new IllegalArgumentException());
	}

	System.out.println(file.getParentFile().getCanonicalPath());

	Path dir = Paths.get(file.toURI());

	System.out.println();
	System.out.println("Listing * Files");
	Files.list(dir).forEach(System.out::println);

	System.out.println();
	System.out.println("Listing * .properties Files");
	Files.list(dir).filter((f) -> f.getFileName().toString().endsWith("properties")).forEach(System.out::println);

	System.out.println();
	
	Properties prop = LoadProperties.readProperties(new File("./src/main/resources/META-INF/properties.properties"));

	System.out.println("Read Property Senha " + prop.getProperty("senha"));

	System.out.println();
	prop.list(System.out);

    }

}
