package com.rallydev;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


final public class SpiralIntTest 
{	
	//    |  0  1  2  3  4		center = 2,2  : colCount = 4, rowCount = 4
	//  --+-------------
	//  0 | 20 21 22 23 24
	//  1 | 19  6  7  8  9
	//  2 | 18  5  0  1 10
	//  3 | 17  4  3  2 11
	//  4 | 16 15 14 13 12
	private static final Integer[][] expectedMatrix = {{20, 21, 22, 23, 24},{ 19, 6, 7, 8, 9},{18, 5, 0, 1,10},{17, 4, 3, 2,11},{16,15,14,13,12}};
	
	@BeforeClass
	final public static void setupFixture() {
	}
	@Before
	final public void setup() {
	}
	@After
	final public void teardown() {
	}

	@Test
	final public void checkPrime2To3IsTrue() {
		assertTrue(SpiralInt.checkPrime(2));
		assertTrue(SpiralInt.checkPrime(3));
	}
	@Test
	final public void checkPrime4IsFalse() {
		assertFalse("4 should not be prime!",SpiralInt.checkPrime(4));
	}
	@Test
	final public void checkPrime259IsFalse() {
		assertFalse("259 should not be Prime!",SpiralInt.checkPrime(259));
	}
	@Test
	final public void checkPrime260Isfalse() {
		assertFalse("260 should not be prime!",SpiralInt.checkPrime(260));
	}
	@Test
	final public void checkPrime263IsTrue() {
		assertTrue("263 should be prime!",SpiralInt.checkPrime(263));
	}
	@Test
	final public void positiveValueMarkedForCounterClockwiseSpiral() {
		assertFalse(SpiralInt.create(-1).isClockwise());
	}
	
	@Test
	final public void positiveValueMarkedForClockwiseSpiral() {
		assertTrue(SpiralInt.create(0).isClockwise());
		assertTrue(SpiralInt.create(1).isClockwise());
	}
		
	
	@Test
	final public void getValueReturnsCorrectValue() {
		assertEquals(0,SpiralInt.create(0).getMaxValue());
		assertEquals(1,SpiralInt.create(1).getMaxValue());
		assertEquals(99,SpiralInt.create(99).getMaxValue());
	}

	
	@Test  
	final public void columnValues_0_has_1_() {
		final int value=0;
		final int expectedRows = 1;
		final int expectedCols = 1;
		final SpiralInt spiralInt = SpiralInt.create(value);
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedRows),expectedRows,spiralInt.getRowCount());
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,spiralInt.getColumnCount());
	}
	
	@Test
	final public void columnValues_1_to_3_has_2_columns() {
		final int expectedCols = 2;
		for(int value = 1; value <= 3; value++) {
			assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),
							expectedCols, SpiralInt.create(value).getColumnCount());
		}
	}
	
	@Test   
	final public void columnValues_4_to_8_has_3_columns() {
		final int expectedCols = 3;
		for(int Values = 4; Values <= 8; Values++) {
			assertEquals(String.format("value[%d] does not have %d columns!",Values,expectedCols),
							expectedCols,SpiralInt.create(Values).getColumnCount());
		}
	}
	
	@Test
	final public void columnValues_9_to_15_has_4_columns() {
		final int expectedCols = 4;
		for(int i = 9; i <= 15; i++) {
			assertEquals(String.format("value[%d] does not have %d columns!",i,expectedCols),expectedCols,SpiralInt.create(i).getColumnCount());
		}
	}
	
	@Test
	final public void columnValues_16_to_24_has_5_columns() {
		final int expectedCols = 5;
		for(int i = 16; i <= 24; i++) {
			assertEquals(String.format("value[%d] does not have %d columns!",i,expectedCols),expectedCols,SpiralInt.create(i).getColumnCount());
		}
	}
	
	@Test
	final public void rowValues_0_to_1_has_1_row() {
		final int expectedRows = 1;
		for(int i = 0; i <= 1; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!",i,expectedRows),expectedRows,SpiralInt.create(i).getRowCount());
		}
	}

	@Test
	final public void rowValues_2_to_5_has_2_rows() {
		final int expectedRows = 2;
		for(int i = 2; i <= 5; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!",i,expectedRows),expectedRows,SpiralInt.create(i).getRowCount());
		}
	}

	@Test
	final public void rowValues_6_to_11_has_3_rows() {
		final int expectedRows = 3;
		for(int i = 6; i <= 11; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!",i,expectedRows),expectedRows,SpiralInt.create(i).getRowCount());
		}
	}

	@Test
	final public void rowValues_12_to_19_has_4_rows() {
		final int expectedRows = 4;
		for(int i = 12; i <= 19; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!",i,expectedRows),expectedRows,SpiralInt.create(i).getRowCount());
		}
	}

	@Test  
	final public void rowValues_20_to_29_has_5_rows() {
		final int expectedRows = 5;
		for(int i = 20; i <= 29; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!",i,expectedRows),expectedRows,SpiralInt.create(i).getRowCount());
		}
	}
	
	// #########################

	@Test
	final public void matrixForValue_1_is_1_by_2() {
		final int value = 1;
		final int expectedRows = 1;
		final int expectedCols = 2;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(String.format("value[%d] does not have %d rows!",value,expectedRows),expectedRows,spiralInt.getMatrix().size());
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,spiralInt.getMatrix().get(0).size());		
	}
	
	@Test
	final public void matrixForValue_8_is_3_by_3() {
		final int value = 8;
		final int expectedRows = 3;
		final int expectedCols = 3;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(String.format("value[%d] does not have %d rows!",value,expectedRows),expectedRows,spiralInt.getMatrix().size());
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,spiralInt.getMatrix().get(0).size());
	}
	
	// ########################
	final int UPPER_RIGHT = 8, LOWER_RIGHT=2, UPPER_LEFT=6, LOWER_LEFT=4;
	@Test
	final public void topLeftCornerAtOffset_0_is_0() {
		final int cornerOffset = 0;
		final int expectedValue = 0;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	final public void topLeftCornerAtOffset_1_is_6() {
		final int cornerOffset = 1;
		final int expectedValue = 6;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	final public void topLeftCornerAtOffset_2_is_20() {
		final int cornerOffset = 2;
		final int expectedValue = 20;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	final public void topLeftCornerAtOffset_3_is_42() {
		final int cornerOffset = 3;
		final int expectedValue = 42;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	final public void topLeftCornerAtOffset_4_is_72() {
		final int cornerOffset = 4;
		final int expectedValue = 72;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	
	// -----------------
	
	@Test
	final public void bottomRightCornerAtOffset_0_is_0() {
		final int cornerOffset = 0;
		final int expectedValue = 0;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,LOWER_RIGHT));
	}
	@Test
	final public void bottomRightCornerAtOffset_1_is_2() {
		final int cornerOffset = 1;
		final int expectedValue = 2;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,LOWER_RIGHT));
	}
	@Test
	final public void bottomRightCornerAtOffset_2_is_12() {
		final int cornerOffset = 2;
		final int expectedValue = 12;
		
		assertEquals(expectedValue,SpiralInt.calculateValueAtCorner(cornerOffset,LOWER_RIGHT));
	}
	
	// ################
	
	@Test
	final public void value_0_has1Row1Col() {
		int value=0;
		int expectedRows=1;
		int expectedCols=1;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expectedRows,spiralInt.getMatrix().size());
		assertEquals(expectedCols,spiralInt.getMatrix().get(0).size());
	}
	@Test
	final public void value_1_has1Row2Col() {
		int value=1;
		int expectedRows=1;
		int expectedCols=2;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expectedRows,spiralInt.getMatrix().size());
		assertEquals(expectedCols,spiralInt.getMatrix().get(0).size());
	}
	@Test
	final public void value_2_has2Row2Col() {
		int value=2;
		int expectedRows=2;
		int expectedCols=2;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expectedRows,spiralInt.getMatrix().size());
		assertEquals(expectedCols,spiralInt.getMatrix().get(0).size());		
	}
	@Test
	final public void value_4_has2Row3Col() {
		int value=4;
		int expectedRows=2;
		int expectedCols=3;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expectedRows,spiralInt.getMatrix().size());
		assertEquals(expectedCols,spiralInt.getMatrix().get(0).size());		
	}
	@Test
	final public void value_6_has3Row3Col() {
		int value=6;
		int expectedRows=3;
		int expectedCols=3;
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expectedRows,spiralInt.getMatrix().size());
		assertEquals(expectedCols,spiralInt.getMatrix().get(0).size());
	}
	
	// ############################
	
	@Test
	final public void matrix10_at_0_3_is_8() {
		final int value=10;
		final int row=0;
		final int col=3;
		final Integer expected = Integer.valueOf(9);
		
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expected,spiralInt.getValue(col, row));
	}
	
	@Test
	final public void matrix1_at_0_1_is_1() {
		final int value=1;
		final int row=0;
		final int col=1;
		final Integer expected = Integer.valueOf(1);
		
		final SpiralInt spiralInt = new SpiralInt(value);
		
		assertEquals(expected,spiralInt.getValue(col, row));
				
	}
	@Test // happy path 1x1, make sure 'origin' is represented correctly
	final public void matrixForValue_0_isValid() {
		final SpiralInt spiralInt = new SpiralInt(0);
		
		assertEquals(1,spiralInt.getRowCount());
		assertEquals(1,spiralInt.getColumnCount());
		
		assertEquals(Integer.valueOf(0),spiralInt.getValue(0,0));		
	}

	@Test // 1x2  special case 
	final public void matrixForValue_1_isValid() {
		final SpiralInt spiralInt = new SpiralInt(1);
		
		assertEquals(1,spiralInt.getRowCount());
		assertEquals(2,spiralInt.getColumnCount());
		
		assertEquals(Integer.valueOf(0),spiralInt.getValue(0,0));
		assertEquals(Integer.valueOf(1),spiralInt.getValue(1,0));
	}
	
	@Test // 2x2 with null value
	final public void matrixForValue_2_isValid() {
		final SpiralInt spiralInt = new SpiralInt(2);
		
		assertEquals(2,spiralInt.getRowCount());
		assertEquals(2,spiralInt.getColumnCount());

		assertEquals(Integer.valueOf(0),spiralInt.getValue(0,0));
		assertEquals(Integer.valueOf(1),spiralInt.getValue(1,0));
		assertEquals(null              ,spiralInt.getValue(0,1));
		assertEquals(Integer.valueOf(2),spiralInt.getValue(1,1));
	}
	
	@Test // happy path 2x2
	final public void matrixForValue_3_isValid() {
		final SpiralInt spiralInt = new SpiralInt(3);
		
		assertEquals(2,spiralInt.getRowCount());
		assertEquals(2,spiralInt.getColumnCount());
		
		for(int x=0; x < 2; x++) {
			for (int y=0; y<2; y++) {
				assertEquals(expectedMatrix[y+2][x+2],spiralInt.getValue(x,y));
			}
		}
	}
	
	@Test	// 2x3 skip top row and null value in 1st column
	final public void matrixForValue_4_isValid() {
		
		final SpiralInt spiralInt = new SpiralInt(4);
		
		assertEquals(2,spiralInt.getRowCount());
		assertEquals(3,spiralInt.getColumnCount());

		assertEquals(null              ,spiralInt.getValue(0,0));
		assertEquals(Integer.valueOf(4),spiralInt.getValue(0,1));

		for(int x=1; x < 3; x++) {
			for (int y=0; y<2; y++) {
				assertEquals(expectedMatrix[y+2][x+1],spiralInt.getValue(x,y));
			}
		}
	}

	@Test   // 2x3 requires skip top row of bounding square
	final public void matrixForValue_5_isValid() {
		
		final SpiralInt spiralInt = new SpiralInt(5);
		
		assertEquals(2,spiralInt.getRowCount());
		assertEquals(3,spiralInt.getColumnCount());

		for (int y = 0; y < 2; y++){
			for (int x = 0; x < 3; x++) {
				assertEquals(expectedMatrix[y+2][x+1],spiralInt.getValue(x, y));
			}
		}
	}

	@Test // Happy path for 3x3
	final public void matrixForValue_6_isValid() {
		
		final SpiralInt spiralInt = new SpiralInt(6);
		
		assertEquals(3,spiralInt.getRowCount());
		assertEquals(3,spiralInt.getColumnCount());

		assertEquals("[0,0]",Integer.valueOf(6),spiralInt.getValue(0,0));
		assertEquals("[1,0]",null              ,spiralInt.getValue(1,0));
		assertEquals("[2,0]",null              ,spiralInt.getValue(2,0));

		for (int y = 1; y < 3; y++){
			for (int x = 0; x < 3; x++) {
				assertEquals(expectedMatrix[y+1][x+1],spiralInt.getValue(x, y));
			}
		}
	}
	@Test
	final public void matrixForValue_7_isValid() {
		final SpiralInt spiralInt = new SpiralInt(7);
		
		assertEquals(3,spiralInt.getRowCount());
		assertEquals(3,spiralInt.getColumnCount());

		assertEquals(Integer.valueOf(6),spiralInt.getValue(0,0));
		assertEquals(Integer.valueOf(7),spiralInt.getValue(1,0));
		assertEquals(null              ,spiralInt.getValue(2,0));

		for (int y = 1; y < 3; y++){
			for (int x = 0; x < 3; x++) {
				assertEquals(expectedMatrix[y+1][x+1],spiralInt.getValue(x, y));
			}
		}
	}
	@Test
	final public void matrixForValue_8_isValid() {
		final SpiralInt spiralInt = new SpiralInt(8);
		
		assertEquals(3,spiralInt.getRowCount());
		assertEquals(3,spiralInt.getColumnCount());

		for (int y = 0; y < 3; y++){
			for (int x = 0; x < 3; x++) {
				assertEquals(expectedMatrix[y+1][x+1],spiralInt.getValue(x, y));
			}
		}		
	}
	@Test
	final public void matrixForValue_9_isValid() {
		final SpiralInt spiralInt = new SpiralInt(9);
		
		assertEquals(3,spiralInt.getRowCount());
		assertEquals(4,spiralInt.getColumnCount());

		for (int y = 0; y < 3; y++){
			for (int x = 0; x < 3; x++) {
				assertEquals(expectedMatrix[y+1][x+1],spiralInt.getValue(x, y));
			}
		}		
		assertEquals(Integer.valueOf(9),spiralInt.getValue(3,0));
		assertEquals(null              ,spiralInt.getValue(3,1));
		assertEquals(null              ,spiralInt.getValue(3,1));
		
	}


	// ############################
}
