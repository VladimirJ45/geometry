package com.epam.geometry.data;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class DataReaderTest {
	@Test
	public void testShouldReadTheData() throws DataException {

		DataReader reader = new DataReader();
		List<String> result = new ArrayList<String>();
		result = reader.readLines("data.txt");

		String firstLine = result.get(0);
		String lastLine = result.get(9);
		int size = result.size();

		// Comparing first line, last line and the size
		Assert.assertEquals("1.0 2.0 3.0 6.0 9.0 2.0", firstLine);
		Assert.assertEquals("-1.0 -1.0 4.0 8.66 9.0 -1.0", lastLine);
		Assert.assertEquals(size, 10);
	}

}
