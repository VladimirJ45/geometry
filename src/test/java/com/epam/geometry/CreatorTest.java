package com.epam.geometry;

import org.junit.Assert;
import org.junit.Test;

import com.epam.geometry.model.Triangle;
import com.epam.geometry.model.Point;

public class CreatorTest {
	
	@Test
	public void testShouldReturnTrueWithTheValidInput() {

		TriangleCreator creator = new TriangleCreator();
		Triangle triangle = creator.create("1.0 2.0 3.0 6.0 9.0 2.0");
		
		Point pointA = new Point(1.0, 2.0);
		Point pointB = new Point(3.0, 6.0);
		Point pointC = new Point(9.0, 2.0);
		Triangle expectedTriangle = new Triangle(pointA, pointB, pointC);
		
		Assert.assertEquals(triangle, expectedTriangle);
	}
	
}
