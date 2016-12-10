package br.com.codecode.dryutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    public static Properties readProperties(File file) throws IOException {

	Properties properties = new Properties();
	properties.load(new FileInputStream(file));
	return properties;
    }

}
