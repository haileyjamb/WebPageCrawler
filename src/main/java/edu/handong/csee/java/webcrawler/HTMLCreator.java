package edu.handong.csee.java.webcrawler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLCreator {
	
	public void saveAsHTML(String dir, String siteURL) {
		
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(dir + "/index.html")));
			
			bw.write(siteURL);
			
			System.out.println("File created @ " + dir);
			bw.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}

	}
}
