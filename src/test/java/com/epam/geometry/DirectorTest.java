package com.epam.geometry;

import com.epam.geometry.model.Point;
import com.epam.geometry.model.Triangle;
import com.epam.geometry.data.DataException;
import com.epam.geometry.data.DataReader;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

// Write tests using Mockito to mock dependencies
public class DirectorTest {

	private DataReader mDataReader = Mockito.mock(DataReader.class);
	private Validator mValidator = Mockito.mock(Validator.class);
	private TriangleCreator mCreator = Mockito.mock(TriangleCreator.class);

	@Test
	public void testShouldReturnTrueWithTheValidInput() throws DataException {

		when(mDataReader.readLines(anyString())).thenReturn(
				Arrays.asList("1.0 2.0 3.0 6.0 9.0 2.0", "1.0 2.0 3.0 6.0 z9.0 2.0", "1.0 2m.0 3.0 6.0 9.n0 2.0"));

		when(mValidator.validate("1.0 2.0 3.0 6.0 9.0 2.0")).thenReturn(true);
		when(mValidator.validate("1.0 2.0 3.0 6.0 z9.0 2.0")).thenReturn(false);
		when(mValidator.validate("1.0 2m.0 3.0 6.0 9.n0 2.0")).thenReturn(false);

		when(mCreator.create(anyString()))
				.thenReturn(new Triangle(new Point(1.0, 2.0), new Point(3.0, 6.0), new Point(9.0, 2.0)));

		Director director = new Director(mDataReader, mValidator, mCreator);

		List<Triangle> result = director.process("");
		Point rPointA = new Point(1.0, 2.0);
		Point rPointB = new Point(3.0, 6.0);
		Point rPointC = new Point(9.0, 2.0);

		Assert.assertNotNull(result);
		Assert.assertEquals(result.size(), 1);
		Assert.assertEquals(result.get(0).getPointA(), rPointA);
		Assert.assertEquals(result.get(0).getPointB(), rPointB);
		Assert.assertEquals(result.get(0).getPointC(), rPointC);
	}
}
