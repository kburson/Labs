package com.rallydev;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

final public class SpiralIntegerFactoryTest {
	
	private static final SpiralIntegerFactory factory = SpiralIntegerFactory.getInstance();

	// | 0 1 2 3 4 center = 2,2 : colCount = 4, rowCount = 4
	// --+-------------
	// 0 | 20 21 22 23 24
	// 1 | 19 6 7 8 9
	// 2 | 18 5 0 1 10
	// 3 | 17 4 3 2 11
	// 4 | 16 15 14 13 12
	private static final Integer[][] EXPECTED_MATRIX = {
			{ 20, 21, 22, 23, 24 }, { 19, 6, 7, 8, 9 }, { 18, 5, 0, 1, 10 },
			{ 17, 4, 3, 2, 11 }, { 16, 15, 14, 13, 12 } };

	@Test
	public void getValueReturnsCorrectValue() {
		final String format = "%d should not be clockwise";
		
		assertEquals(String.format(format, 0), 0, factory
				.createMatrix(0).getMaxValue());
		
		assertEquals(String.format(format, 1), 1, factory
				.createMatrix(1).getMaxValue());
		
		assertEquals(String.format(format, 99), 99, factory
				.createMatrix(99).getMaxValue());
	}

	
	@Test
	public void matrixForValue_1_is_1_by_2() {
		final int value = 1;
		final int expectedRows = 1;
		final int expectedCols = 2;
		
		final IntegerMatrix matrix = factory.createMatrix(value);
		
		assertEquals(String.format("value[%d] does not have %d rows!",value,expectedRows),expectedRows,matrix.getRowCount());
		assertEquals(String.format("value[%d] does not have %d rows!",value,expectedRows),expectedRows,matrix.getMatrixCopy().size());

		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,matrix.getColumnCount());		
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,matrix.getMatrixCopy().get(0).size());		
	}
	
	@Test
	public void matrixForValue_8_is_3_by_3() {
		final int value = 8;
		final int expectedRows = 3;
		final int expectedCols = 3;
		
		final IntegerMatrix matrix = factory.createMatrix(value);
		
		assertEquals(String.format("value[%d] does not have %d rows!",value,expectedRows),expectedRows,matrix.getRowCount());
		assertEquals(String.format("value[%d] does not have %d rows!",value,expectedRows),expectedRows,matrix.getMatrixCopy().size());
		
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,matrix.getColumnCount());
		assertEquals(String.format("value[%d] does not have %d columns!",value,expectedCols),expectedCols,matrix.getMatrixCopy().get(0).size());
	}
	
	// ------------------------------------
	
	@Test
	public void getColumnCount_is_1_forValue_0 () {

		final int expectedRows = 1;
		final int expectedCols = 1;
		final int value = 0;
		final IntegerMatrix matrix = factory
				.createMatrix(value);
		final String format = "value[%d] does not have %d columns!";
		assertEquals(String.format(format, value, expectedRows), expectedRows,
				matrix.getRowCount());
		assertEquals(String.format(format, value, expectedCols), expectedCols,
				matrix.getColumnCount());
	}

	@Test
	public void getColumnCount_is_2_forValues_1_to_3 () {
		final int expectedColumnCount = 2;
		for (int value = 1; value <= 3; value++) {
			assertEquals(String.format("value[%d] does not have %d columns!",
					value, expectedColumnCount), expectedColumnCount, factory
					.createMatrix(value).getColumnCount());
		}
	}

	@Test
	public void getColumnCount_is_3_forValues_4_to_8 () {
		final int expectedColumnCount = 3;
		for (int Values = 4; Values <= 8; Values++) {
			assertEquals(String.format("value[%d] does not have %d columns!",
					Values, expectedColumnCount), expectedColumnCount, factory
					.createMatrix(Values).getColumnCount());
		}
	}

	@Test
	public void getColumnCount_is_4_forValues_9_to_15 () {
		final int expectedColumnCount = 4;
		for (int i = 9; i <= 15; i++) {
			assertEquals(String.format("value[%d] does not have %d columns!",
					i, expectedColumnCount), expectedColumnCount, factory
					.createMatrix(i).getColumnCount());
		}
	}

	@Test
	public void getColumnCount_is_5_forValues_16_to_24 () {
		final int expectedColumnCount = 5;
		for (int i = 16; i <= 24; i++) {
			assertEquals(String.format("value[%d] does not have %d columns!",
					i, expectedColumnCount), expectedColumnCount, factory
					.createMatrix(i).getColumnCount());
		}
	}

	// ------------------------------------

	@Test
	public void getRowCount_is_1_forValues_0_to_1 () {
		final int expectedRowCount = 1;
		for (int i = 0; i <= 1; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!", i,
					expectedRowCount), expectedRowCount, factory.createMatrix(i)
					.getRowCount());
		}
	}

	@Test
	public void getRowCount_is_2_forValues_2_to_5 () {
		final int expectedRowCount = 2;
		for (int i = 2; i <= 5; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!", i,
					expectedRowCount), expectedRowCount, factory.createMatrix(i)
					.getRowCount());
		}
	}

	@Test
	public void getRowCount_is_3_forValues_6_to_11 () {
		final int expectedRowCount = 3;
		for (int i = 6; i <= 11; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!", i,
					expectedRowCount), expectedRowCount, factory.createMatrix(i)
					.getRowCount());
		}
	}

	@Test
	public void getRowCount_is_4_forValues_12_to_19 () {
		final int expectedRowCount = 4;
		for (int i = 12; i <= 19; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!", i,
					expectedRowCount), expectedRowCount, factory.createMatrix(i)
					.getRowCount());
		}
	}

	@Test
	public void getRowCount_is_5_forValues_20_to_29 () {
		final int expectedRowCount = 5;
		for (int i = 20; i <= 29; i++) {
			assertEquals(String.format("value[%d] does not have %d rows!", i,
					expectedRowCount), expectedRowCount, factory.createMatrix(i)
					.getRowCount());
		}
	}

	// ####################################

	@Test
	public void createMatrix_0_is_1x1 () {
		int value = 0;
		int expectedRows = 1;
		int expectedCols = 1;
		
		final IntegerMatrix matrix = factory.createMatrix(value);

		assertEquals(expectedRows, matrix.getMatrixCopy().size());
		assertEquals(expectedCols, matrix.getMatrixCopy().get(0).size());
	}

	@Test
	public void createMatrix_1_is_1x2 () {
		int expectedRows = 1;
		int expectedCols = 2;
		
		final IntegerMatrix matrix = factory.createMatrix(1);

		assertEquals(expectedRows, matrix.getMatrixCopy().size());
		assertEquals(expectedCols, matrix.getMatrixCopy().get(0).size());
	}

	@Test
	public void createMatrix_2_is_2x2 () {
		int value = 2;
		int expectedRows = 2;
		int expectedCols = 2;
		
		final IntegerMatrix matrix = factory.createMatrix(value);

		assertEquals(expectedRows, matrix.getMatrixCopy().size());
		assertEquals(expectedCols, matrix.getMatrixCopy().get(0).size());
	}

	@Test
	public void createMatrix_4_is_2x3 () {
		int value = 4;
		int expectedRows = 2;
		int expectedCols = 3;
		
		final IntegerMatrix matrix = factory.createMatrix(value);

		assertEquals(expectedRows, matrix.getMatrixCopy().size());
		assertEquals(expectedCols, matrix.getMatrixCopy().get(0).size());
	}

	@Test
	public void createMatrix_6_is_3x3 () {
		int value = 6;
		int expectedRows = 3;
		int expectedCols = 3;
		
		final IntegerMatrix matrix = factory.createMatrix(value);

		assertEquals(expectedRows, matrix.getMatrixCopy().size());
		assertEquals(expectedCols, matrix.getMatrixCopy().get(0).size());
	}

	// ####################################

	@Test
	public void matrix10_at_0_3_is_8() {
		final int value = 10;
		final int row = 0;
		final int col = 3;
		final Integer expected = Integer.valueOf(9);

		final IntegerMatrix matrix = factory.createMatrix(value);

		assertEquals(expected, matrix.getValue(col, row));
	}

	@Test
	public void matrix1_at_0_1_is_1() {
		final int value = 1;
		final int row = 0;
		final int col = 1;
		final Integer expected = Integer.valueOf(1);

		final IntegerMatrix matrix = factory.createMatrix(value);

		assertEquals(expected, matrix.getValue(col, row));

	}

	// ------------------------------------
	
	@Test	// happy path 1x1, make sure 'origin' is represented correctly
	public void matrixForValue_0_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(0);

		assertEquals(1, matrix.getRowCount());
		assertEquals(1, matrix.getColumnCount());

		assertEquals(Integer.valueOf(0), matrix.getValue(0, 0));
	}

	@Test	// 1x2 special case
	public void matrixForValue_1_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(1);

		assertEquals(1, matrix.getRowCount());
		assertEquals(2, matrix.getColumnCount());

		assertEquals(Integer.valueOf(0), matrix.getValue(0, 0));
		assertEquals(Integer.valueOf(1), matrix.getValue(1, 0));
	}

	@Test	// 2x2 with null value
	public void matrixForValue_2_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(2);

		assertEquals(2, matrix.getRowCount());
		assertEquals(2, matrix.getColumnCount());

		assertEquals(Integer.valueOf(0), matrix.getValue(0, 0));
		assertEquals(Integer.valueOf(1), matrix.getValue(1, 0));
		assertEquals(null, matrix.getValue(0, 1));
		assertEquals(Integer.valueOf(2), matrix.getValue(1, 1));
	}

	@Test	// happy path 2x2
	public void matrixForValue_3_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(3);

		assertEquals(2, matrix.getRowCount());
		assertEquals(2, matrix.getColumnCount());

		for (int x = 0; x < 2; x++) {
			for (int y = 0; y < 2; y++) {
				assertEquals(EXPECTED_MATRIX[y + 2][x + 2],
						matrix.getValue(x, y));
			}
		}
	}

	@Test
	// 2x3 skip top row and null value in 1st column
	public void matrixForValue_4_isValid() {

		final IntegerMatrix matrix = factory.createMatrix(4);

		assertEquals(2, matrix.getRowCount());
		assertEquals(3, matrix.getColumnCount());

		assertEquals(null, matrix.getValue(0, 0));
		assertEquals(Integer.valueOf(4), matrix.getValue(0, 1));

		for (int x = 1; x < 3; x++) {
			for (int y = 0; y < 2; y++) {
				assertEquals(EXPECTED_MATRIX[y + 2][x + 1],
						matrix.getValue(x, y));
			}
		}
	}

	@Test
	// 2x3 requires skip top row of bounding square
	public void matrixForValue_5_isValid() {

		final IntegerMatrix matrix = factory.createMatrix(5);

		assertEquals(2, matrix.getRowCount());
		assertEquals(3, matrix.getColumnCount());

		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 3; x++) {
				assertEquals(EXPECTED_MATRIX[y + 2][x + 1],
						matrix.getValue(x, y));
			}
		}
	}

	@Test
	// Happy path for 3x3
	public void matrixForValue_6_isValid() {

		final IntegerMatrix matrix = factory.createMatrix(6);

		assertEquals(3, matrix.getRowCount());
		assertEquals(3, matrix.getColumnCount());

		assertEquals("[0,0]", Integer.valueOf(6), matrix.getValue(0, 0));
		assertEquals("[1,0]", null, matrix.getValue(1, 0));
		assertEquals("[2,0]", null, matrix.getValue(2, 0));

		for (int y = 1; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				assertEquals(EXPECTED_MATRIX[y + 1][x + 1],
						matrix.getValue(x, y));
			}
		}
	}

	@Test
	public void matrixForValue_7_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(7);

		assertEquals(3, matrix.getRowCount());
		assertEquals(3, matrix.getColumnCount());

		assertEquals(Integer.valueOf(6), matrix.getValue(0, 0));
		assertEquals(Integer.valueOf(7), matrix.getValue(1, 0));
		assertEquals(null, matrix.getValue(2, 0));

		for (int y = 1; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				assertEquals(EXPECTED_MATRIX[y + 1][x + 1],
						matrix.getValue(x, y));
			}
		}
	}

	@Test
	public void matrixForValue_8_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(8);

		assertEquals(3, matrix.getRowCount());
		assertEquals(3, matrix.getColumnCount());

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				assertEquals(EXPECTED_MATRIX[y + 1][x + 1],
						matrix.getValue(x, y));
			}
		}
	}

	@Test
	public void matrixForValue_9_isValid() {
		
		final IntegerMatrix matrix = factory.createMatrix(9);

		assertEquals(3, matrix.getRowCount());
		assertEquals(4, matrix.getColumnCount());

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				assertEquals(EXPECTED_MATRIX[y + 1][x + 1],
						matrix.getValue(x, y));
			}
		}
		assertEquals(Integer.valueOf(9), matrix.getValue(3, 0));
		assertEquals(null, matrix.getValue(3, 1));
		assertEquals(null, matrix.getValue(3, 1));

	}

	// ############################
}
