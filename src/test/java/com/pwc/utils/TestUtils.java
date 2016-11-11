package com.pwc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

	private static Properties prop = null;
	private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);

	public static Properties getProperties() {
		if (prop == null) {
			prop = new Properties();
			InputStream stream = TestUtils.class.getResourceAsStream("/env.properties");
			try {
				prop.load(stream);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return prop;

	}

}
