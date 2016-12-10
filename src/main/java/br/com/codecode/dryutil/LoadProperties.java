package br.com.codecode.dryutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

    public static Properties readProperties(File file) throws IOException {

	Properties properties = new Properties();
	properties.load(new FileInputStream(file));
	return properties;
    }
    
    public static Properties readProperties(InputStream inputStream) throws IOException {
	Properties properties = new Properties();
	properties.load(inputStream);
	return properties;
    }

}
