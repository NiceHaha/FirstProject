package dao.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PathPropertiesUtil {
	public static String getPath(String key) throws IOException {
		Properties properties = new Properties();
		String filePath = PropertiesUtil.class.getResource("/path.properties").getPath();
		InputStream in = new FileInputStream(filePath);
		properties.load(in);// 读取
		String value = properties.getProperty(key).trim();
		return value;
	}
}
