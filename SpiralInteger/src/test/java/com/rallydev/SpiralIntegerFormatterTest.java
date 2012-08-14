package com.rallydev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpiralIntegerFormatterTest {

	private static final SpiralIntegerFactory factory = SpiralIntegerFactory.getInstance();

	private static IntegerMatrix matrix3;
	private SpiralIntegerFormatter formatter;
	
	@BeforeClass
	public static void setUpFixture() {
		matrix3 = factory.createMatrix(3);
	}
	
	@Before
	public void setUp() {
		formatter = new SpiralIntegerFormatter();
	}

	@Test
	public void checkPrime2To3IsTrue() {
		final String format = "%d should Be Prime";
		assertTrue(String.format(format,2), SpiralIntegerFormatter.checkPrime(2));
		assertTrue(String.format(format,2), SpiralIntegerFormatter.checkPrime(3));
	}
	@Test
	public void checkPrime4IsFalse() {
		assertFalse("4 should not be prime!",SpiralIntegerFormatter.checkPrime(4));
	}
	@Test
	public void checkPrime258To262IsFalse() {
		for (int i=258; i< 263; i++) {
			assertFalse(String.format("%d should not be Prime!",i),SpiralIntegerFormatter.checkPrime(i));
		}
	}
	@Test
	public void checkPrime263IsTrue() {
		assertTrue("263 should be prime!",SpiralIntegerFormatter.checkPrime(263));
	}
	

	@Test
	public void printMatrix_2_Prints2x3Matrix() {
				
		String results = formatter.print(factory.createMatrix(2));
				
		assertEquals("[ 0 1]\n[   2]\n",results);
	}

	@Test
	public void printMatrix_neg2_sameAs_pos2() {
				
		String results = formatter.print(factory.createMatrix(-2));
				
		assertEquals("[ 0 1]\n[   2]\n",results);
	}
	
	@Test
	public void printMatrix_3_withClockwiseFalse_Prints2x2MatrixReversed() {
				
		formatter.setPrintClockwise(false);
		String results = formatter.print(factory.createMatrix(3));
		
		assertEquals("[ 3 2]\n[ 0 1]\n",results);
	}

	@Test
	public void printMatrix_4_prints2x3MatrixWithNullSpace() {
				
		String results = formatter.print(factory.createMatrix(4));
		
		assertEquals("[   0 1]\n[ 4 3 2]\n",results);
	}

	@Test
	public void printMatrix_6_Prints3x3MatrixWithEmptyCells() {
				
		String results = formatter.print(factory.createMatrix(6));
		
		assertEquals("[ 6    ]\n[ 5 0 1]\n[ 4 3 2]\n",results);
	}

	@Test
	public void printMatrix_6_withShowPrimeNumbersTrue_Prints3x3MatrixWithOnly_2_3_5() {
				
		formatter.setShowPrimeNumbersOnly(true);
		String results = formatter.print(factory.createMatrix(6));
		
		assertEquals("[      ]\n[ 5    ]\n[   3 2]\n",results);
	}

	@Test
	public void printMatrix_6_withShowPrimeNumbersAndPrintStarsTrue_Prints3x3MatrixWithOnly_2_3_5_asStars() {
				
		formatter.setShowPrimeNumbersOnly(true).setPrintStars(true);
		String results = formatter.print(factory.createMatrix(6));
		
		assertEquals("[      ]\n[ *    ]\n[   * *]\n",results);
	}

	@Test
	public void printMatrix_6_withPrintStarsTrue_Prints3x3MatrixWithOnly_1_thru_6_asStars() {
				
		formatter.setPrintStars(true);
		String results = formatter.print(factory.createMatrix(6));
		
		assertEquals("[ *    ]\n[ * * *]\n[ * * *]\n",results);
	}
	
}
