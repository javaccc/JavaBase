package com.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HtmlRequestUtil {

	public static byte[] readInputStream(InputStream inputStream)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len = 0;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		while ((len = inputStream.read(buffer)) != -1) {
			bos.write(buffer, 0, len);
		}
		bos.close();
		return bos.toByteArray();
	}
	
	public static String getHtml(String website) {
		String data = null;
		try {
			URL url = new URL(website);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			InputStream inputStream = conn.getInputStream(); // 通过输入流获得网站数据
			byte[] getData = readInputStream(inputStream); // 获得网站的二进制数据
			data = new String(getData, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public static void main(String[] args) {
		String website = "https://api.douban.com/v2/book/isbn/9787533941611";
		String data = getHtml(website);
		System.out.println(data);
	}

}