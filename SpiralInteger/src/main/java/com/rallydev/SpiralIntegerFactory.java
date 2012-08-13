package com.rallydev;

import java.awt.Point;

public class SpiralIntegerFactory {

	private static final int FILL_DOWN = 1, FILL_UP = -1, FILL_RIGHT = 1,
			FILL_LEFT = -1;
	private static final int FILL_FORWARD = 1, FILL_REVERSE = -1;

	private static final int LOWER_RIGHT_CORNER = 2;
	// private static final int LOWER_LEFT_CORNER = 4;
	private static final int UPPER_LEFT_CORNER = 6;

	// private static final int UPPER_RIGHT_CORNER = 8;

	// #####################################

	public static int countSequenceToValue(final int value,
			final boolean columns) {

		int increment = (columns ? 1 : 2); // columns or rows
		int count = 0;
		int total = 0;
		while (total <= value) {
			count++;
			total += increment;
			increment += 2;
		}
		return count;
	}

	public static int calculateColumns(final int maxValue) { // odd
		return countSequenceToValue(maxValue, true);
	}

	public static int calculateRows(final int maxValue) { // even
		return countSequenceToValue(maxValue, false);
	}

	public static int calculateValueAtCorner(final int offsetFromCenter,
			final int cornerSeed) {

		int value = 0;
		for (int x = 0; x < offsetFromCenter; x++) {
			value += cornerSeed + 8 * x;
		}
		return value;
	}

	public static Point calculateCenter(final int rowCount,
			final int columnCount) {
		int x, y;
		y = (int) Math.floor((rowCount - 1) / 2);
		x = (int) Math.floor((columnCount - 1) / 2);
		return new Point(x, y);
	}

	// -------------------------------------------------------

	public static IntegerMatrix createMatrix(final int maximumValue) {

		final int maxValue = Math.abs(maximumValue);
		final Point lowerLeft = new Point(calculateColumns(maxValue) - 1,
				calculateRows(maxValue) - 1);
		final Point center = calculateCenter(lowerLeft.y + 1, lowerLeft.x + 1);

		final IntegerMatrix matrix = IntegerMatrix.createMatrix(maxValue,
				center, lowerLeft);
		return fillMatrix(matrix);
	}

	public static IntegerMatrix fillMatrix(final IntegerMatrix matrix) {

		setOrigin(matrix);

		if (matrix.getRowCount() == 1) { // 0 or 1 columns
			
			Integer cornerValue = 0;
			fillRow(matrix, new Point(0, 0), new Point(
					matrix.getColumnCount() - 1, 0), cornerValue, FILL_RIGHT,
					FILL_FORWARD);
		} else {

			final Point matrixCenter = matrix.getMatrixCenter();
			int offsetFromCenter = 1;
			while (offsetFromCenter - 1 <= matrixCenter.x) {

				final Point point0 = new Point(matrixCenter.x
						- offsetFromCenter, matrixCenter.y - offsetFromCenter);
				final Integer cornerValue0 = calculateValueAtCorner(
						offsetFromCenter, UPPER_LEFT_CORNER);

				final Point point1 = new Point(matrixCenter.x
						+ offsetFromCenter, matrixCenter.y + offsetFromCenter);
				final Integer cornerValue1 = calculateValueAtCorner(
						offsetFromCenter, LOWER_RIGHT_CORNER);

				if (point0.x >= 0) {
					fillColumn(matrix, point0, point1, cornerValue0, FILL_DOWN,
							FILL_REVERSE);
				}
				if (point1.x < matrix.getColumnCount()) {
					fillColumn(matrix, point1, point0, cornerValue1, FILL_UP,
							FILL_REVERSE);
				}

				if (point0.y >= 0) { // skip top line above our bounding square
					fillRow(matrix, point0, point1, cornerValue0, FILL_RIGHT,
							FILL_FORWARD);
				}
				if (point1.y < matrix.getRowCount()) { // skip top line above
														// our bounding square
					fillRow(matrix, point1, point0, cornerValue1, FILL_LEFT,
							FILL_FORWARD);
				}
				offsetFromCenter++;
			}
		}

		return matrix;

	}

	// -------------------------------------------------------

	private static void setOrigin(final IntegerMatrix matrix) {
		matrix.setPointValue(matrix.getMatrixCenter(), 0);
	}

	private static void fillColumn(final IntegerMatrix matrix,
			final Point point0, final Point point1,
			final Integer startingValue, final int rowDelta,
			final int valueDelta) {

		if (point0.x < 0 || point0.x >= matrix.getColumnCount()) {
			return;
		}

		Integer cellValue = startingValue;
		int y = point0.y;

		for (; (rowDelta > 0 && y >= point0.y && y <= point1.y)
				|| (rowDelta < 0 && y <= point0.y && y >= point1.y); y += rowDelta, cellValue += valueDelta) {
			matrix.setPointValue(new Point(point0.x, y), cellValue);
		}
	}

	private static void fillRow(final IntegerMatrix matrix, final Point point0,
			final Point point1, final Integer startingValue,
			final int columnDelta, final int valueDelta) {

		if (point0.x < 0 || point0.x >= matrix.getColumnCount()) {
			return;
		}

		Integer cellValue = startingValue;
		int x = point0.x;

		for (; (columnDelta > 0 && x >= point0.x && x <= point1.x)
				|| (columnDelta < 0 && x <= point0.x && x >= point1.x); x += columnDelta, cellValue += valueDelta) {
			matrix.setPointValue(new Point(x, point0.y), cellValue);
		}
	}

}