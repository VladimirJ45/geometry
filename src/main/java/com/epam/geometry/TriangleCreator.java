package com.epam.geometry;

import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;

// TODO: make this name more specific (according to your task)
public class TriangleCreator {

	public Triangle create(String line) {

		String[] coordinates = line.split(" ");

		Point pointA = new Point(Double.parseDouble(coordinates[0]), Double.parseDouble(coordinates[1]));
		Point pointB = new Point(Double.parseDouble(coordinates[2]), Double.parseDouble(coordinates[3]));
		Point pointC = new Point(Double.parseDouble(coordinates[4]), Double.parseDouble(coordinates[5]));
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		
		return triangle;
	}
}
