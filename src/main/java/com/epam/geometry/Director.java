package com.epam.geometry;

import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;
import com.epam.geometry.model.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Director {

	// TODO: uncomment
	private final DataReader reader;
	private final Validator validator;
	private final TriangleCreator triangleCreator;

	public Director(DataReader reader, Validator validator, TriangleCreator triangleCreator) {
		// TODO: inject you dependencies here
		this.reader = reader;
		this.validator = validator;
		this.triangleCreator = triangleCreator;
	}

	public List<Triangle> process(String filename) throws DataException {
		List<String> lines = reader.readLines(filename);
		List<Triangle> result = new ArrayList<Triangle>(); 
		for (String line : lines) {
			if (validator.validate(line)) {
				result.add(triangleCreator.create(line));
			}
		}
		return result;
	}

}
