/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import br.com.frmichetti.dryutil.LoadProperties;

public class TesteLoadProperties {

	public static void main(String ... args) throws Exception  {			

		File file = new File("./src/resources/META-INF");

		System.out.println("File exists ? " + file.exists());
		
		if(file.exists()){
			
			file = new File(file.getCanonicalPath());
			
		}else{
			
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
		Properties prop = LoadProperties.readProperties(new File("C:\\Users\\Felipe\\git\\frmichetti\\com\\dry-util\\src\\resources\\META-INF\\properties.properties"));
		
		System.out.println("Read Property Senha " + prop.getProperty("senha"));
		
		System.out.println();
		prop.list(System.out);
		
		
		
		

	}

}
