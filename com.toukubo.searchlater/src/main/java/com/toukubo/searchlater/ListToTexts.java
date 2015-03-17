package com.toukubo.searchlater;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListToTexts {
	String filename = "urls.txt";
	public ListToTexts(List<String> lines){
		FileWriter writer;
		try {
			writer = new FileWriter(new File(this.filename),true);
			for (String line : lines) {
				writer.write(line + "\r\n");
			}
			writer.flush();
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}