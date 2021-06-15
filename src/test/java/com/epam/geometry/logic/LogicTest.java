package com.epam.geometry.logic;

import org.junit.Assert;
import org.junit.Test;

import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;

public class LogicTest {

	private Logic logic = new Logic();
	private Point pointA = new Point(1.0, 2.0);
	private Point pointB = new Point(3.0, 6.0);
	private Point pointC = new Point(9.0, 2.0);
	private double epsilon = 0.01d;

	@Test
	public void testShouldCalculateTriangleSideLength() {
		double expected = 4.47;
		double result = logic.getTriangleSide(pointA, pointB);

		Assert.assertEquals(result, expected, epsilon);
	}

	@Test
	public void testShouldCalculateTrianglePerimeter() {
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double expected = 19.68;

		double result = logic.calculatePerimeter(triangle);

		Assert.assertEquals(result, expected, epsilon);
	}

	@Test
	public void testShouldCalculateTriangleArea() {
		Triangle triangle = new Triangle(pointA, pointB, pointC);
		double expected = 16;

		double result = logic.calculateArea(triangle);

		Assert.assertEquals(result, expected, epsilon);
	}

	@Test
	public void testShouldDefineIfThisTriangleIsTriangle() {
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertTrue(logic.isTriangle(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsNotTriangle() {
		Point pointA = new Point(-1, 5);
		Point pointB = new Point(-1, -2);
		Point pointC = new Point(-1, 8);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertFalse(logic.isTriangle(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsRectangular() {
		Point pointA = new Point(-1, 5);
		Point pointB = new Point(-1, -1);
		Point pointC = new Point(2, -1);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertTrue(logic.isRectangular(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsNotRectangular() {
		Point pointA = new Point(-2, 5);
		Point pointB = new Point(-1, -1);
		Point pointC = new Point(2, -1);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertFalse(logic.isRectangular(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsIsosceles() {
		Point pointA = new Point(-2, -1);
		Point pointB = new Point(-2, -1);
		Point pointC = new Point(0, 5);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertTrue(logic.isIsosceles(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsNotIsosceles() {
		Point pointA = new Point(-2, 1);
		Point pointB = new Point(-2, -1);
		Point pointC = new Point(0, 10);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertFalse(logic.isIsosceles(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsEquilateral() {
		Point pointA = new Point(5.19, 3.46);
		Point pointB = new Point(2, -3);
		Point pointC = new Point(-2, 3);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertTrue(logic.isEquilateral(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsNotEquilateral() {
		Point pointA = new Point(-1, 5);
		Point pointB = new Point(-1, -2);
		Point pointC = new Point(-1, 8);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertFalse(logic.isEquilateral(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsAcute() {
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertTrue(logic.isAcute(triangle));
	}

	@Test
	public void testShouldDefineIfThisTriangleIsObtuse() {
		Point pointA = new Point(0, 0);
		Point pointB = new Point(0, 5);
		Point pointC = new Point(3, -2);
		Triangle triangle = new Triangle(pointA, pointB, pointC);

		Assert.assertFalse(logic.isAcute(triangle));
	}

}
