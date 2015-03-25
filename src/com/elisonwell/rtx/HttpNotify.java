package com.elisonwell.rtx;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class HttpNotify {

	public static void main(String[] args) {
		int iRetCode = 0;
		String szEncodeResult;
		String szResult;
		URLDecoder urld = new URLDecoder();
		String szMessage = URLEncoder
				.encode("[测试联接|http://127.0.0.1/test.html]");
		try {
			java.net.URL url = new URL(
					"http://192.168.1.51:8012/sendnotify.cgi?receiver=nardo,wwjs&msg="
							+ szMessage);
			HttpURLConnection httpConnection = (HttpURLConnection) url
					.openConnection();
			iRetCode = Integer.parseInt(httpConnection.getHeaderField(3));
			szEncodeResult = httpConnection.getHeaderField(4);
			szResult = URLDecoder.decode(szEncodeResult);
			System.out.println("Code:" + String.valueOf(iRetCode));
			System.out.println("Info:" + szResult);
		} catch (Exception e) {
			System.out.println("系统出错" + e);
		}
	}

}
