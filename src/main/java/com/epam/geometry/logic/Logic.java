package com.epam.geometry.logic;

import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;

// TODO: make this name more specific (according to your task)
public class Logic {

	public double getTriangleSide(Point a, Point b) {
		double sideLength = Math
				.sqrt((b.getX() - a.getX()) * (b.getX() - a.getX()) + (b.getY() - a.getY()) * (b.getY() - a.getY()));
		return sideLength;
	}

	public double calculatePerimeter(Triangle triangle) {
		double perimeter = getTriangleSide(triangle.getPointA(), triangle.getPointB())
				+ getTriangleSide(triangle.getPointB(), triangle.getPointC())
				+ getTriangleSide(triangle.getPointA(), triangle.getPointC());
		return perimeter;
	}

	public double calculateArea(Triangle triangle) {
		double halfPerimeter = calculatePerimeter(triangle) / 2;
		double area = Math
				.sqrt(halfPerimeter * (halfPerimeter - getTriangleSide(triangle.getPointA(), triangle.getPointB()))
						* (halfPerimeter - getTriangleSide(triangle.getPointB(), triangle.getPointC()))
						* (halfPerimeter - getTriangleSide(triangle.getPointA(), triangle.getPointC())));
		return area;
	}

	public boolean isTriangle(Triangle triangle) {
		double side1 = getTriangleSide(triangle.getPointA(), triangle.getPointB());
		double side2 = getTriangleSide(triangle.getPointB(), triangle.getPointC());
		double side3 = getTriangleSide(triangle.getPointA(), triangle.getPointC());
		if (((side1 + side2) > side3) && ((side2 + side3) > side1) && ((side1 + side3) > side2)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isRectangular(Triangle triangle) {
		double side1 = getTriangleSide(triangle.getPointA(), triangle.getPointB());
		double side2 = getTriangleSide(triangle.getPointB(), triangle.getPointC());
		double side3 = getTriangleSide(triangle.getPointA(), triangle.getPointC());
		if ((Math.round(side1 * side1 + side2 * side2) == Math.round(side3 * side3))
				|| (Math.round(side1 * side1 + side3 * side3) == Math.round(side2 * side2))
				|| (Math.round(side2 * side2 + side3 * side3) == Math.round(side1 * side1))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isIsosceles(Triangle triangle) {
		double side1 = getTriangleSide(triangle.getPointA(), triangle.getPointB());
		double side2 = getTriangleSide(triangle.getPointB(), triangle.getPointC());
		double side3 = getTriangleSide(triangle.getPointA(), triangle.getPointC());
		if ((side1 == side2) || (side2 == side3) || (side1 == side3)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isEquilateral(Triangle triangle) {
		double side1 = Math.round(getTriangleSide(triangle.getPointA(), triangle.getPointB()));
		double side2 = Math.round(getTriangleSide(triangle.getPointB(), triangle.getPointC()));
		double side3 = Math.round(getTriangleSide(triangle.getPointA(), triangle.getPointC()));
		if ((side1 == side2) && (side2 == side3)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isAcute(Triangle triangle) {
		double side1 = Math.round(getTriangleSide(triangle.getPointA(), triangle.getPointB()));
		double side2 = Math.round(getTriangleSide(triangle.getPointB(), triangle.getPointC()));
		double side3 = Math.round(getTriangleSide(triangle.getPointA(), triangle.getPointC()));
		if ((side1 * side1 + side2 * side2 < side3 * side3) || (side2 * side2 + side3 * side3 < side1 * side1)
				|| (side1 * side1 + side3 * side3 < side2 * side2)) {
			return false;
		} else {
			return true;
		}
	}
}
