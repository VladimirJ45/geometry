package com.epam.geometry.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

	// TODO: implement this method using BufferedReader, do not throw original
	// IOException, wrap it with your own
	public List<String> readLines(String filename) throws DataException {
		
		List<String> lines = new ArrayList<String>();
		
		try {
			String line = null;
			FileReader fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			
			while ((line = br.readLine()) != null) {
                lines.add(line);
            }
			br.close();
			fr.close();
		} catch (Exception e) {
			throw new DataException(e.getMessage(), e.getCause());
		}
		return lines;
	}
}
