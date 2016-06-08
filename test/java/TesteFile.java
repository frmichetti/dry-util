/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */

import java.io.File;
import java.io.IOException;


public class TesteFile {

	public static void main(String ... args) {

		File f = new File("./src/resources/META-INF");				

		try {

			System.out.println(f.getPath());

			System.out.println("Caminho existe ? : " + f.exists());

			System.out.println("É um diretório ? : " + f.isDirectory());

			System.out.println("Está oculto ? : "+ f.isHidden());

			System.out.println("Caminho Absoluto : " + f.getAbsolutePath());

			System.out.println("Caminho Canonico : " + f.getCanonicalPath());

			System.out.println("Permissôes");

			System.out.println("Execução : " + f.canExecute());

			System.out.println("Leitura : " + f.canRead());

			System.out.println("Escrita : " + f.canWrite());


			if(f.isDirectory()){

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
