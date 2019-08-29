package dao.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesUtil {
	public static String getValue(String key) throws IOException {
		Properties prop = new Properties();
		String filePath = PropertiesUtil.class.getResource("/db.properties").getPath();// jdbc.properties属�?�文件的名称
		InputStream in = new FileInputStream(filePath);
		prop.load(in);// 读取
		String value = prop.getProperty(key).trim();
		return value;// 返回value
	}
}
