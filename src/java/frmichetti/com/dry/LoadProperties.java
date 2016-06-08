/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package frmichetti.com.dry;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	public static Properties readProperties(File file) throws IOException {
		Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(file);
		properties.load(fis);
		return properties;
	}
	

}
