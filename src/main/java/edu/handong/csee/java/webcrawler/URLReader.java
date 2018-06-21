package edu.handong.csee.java.webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;

public class URLReader {

	public String merger(String url) {

		BufferedReader in = null;
		String mergedLines = null;

		try {

			URL page = new URL(url); 
			HttpURLConnection connection = (HttpURLConnection) page.openConnection();

			connection.setRequestMethod("GET");

			in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

			String lines;
			while ((lines = in.readLine()) != null) {
				mergedLines += (lines + "\n");

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return mergedLines;
	}
}//https://docs.oracle.com/javase/tutorial/networking/urls/connecting.html
