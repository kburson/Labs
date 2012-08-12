package com.rallydev;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralInt {

	private static final int FILL_DOWN=1, FILL_UP=-1, FILL_RIGHT=1, FILL_LEFT=-1;
	private static final int FILL_FORWARD=1, FILL_REVERSE=-1;

	private static final int LOWER_RIGHT_CORNER = 2;
	//private static final int LOWER_LEFT_CORNER = 4;
	private static final int UPPER_LEFT_CORNER = 6;
	//private static final int UPPER_RIGHT_CORNER = 8;

	// ############################################

	private final int maxValue;
	private final boolean clockwise;
	private final List<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

	private final int rowCount;
	private final int columnCount;

	private final Point matrixCenter = new Point();
	
	// ############################################
	
	private boolean showPrimeNumbersOnly;
	private boolean starPrimeNumbers;

	// ############################################

	public static boolean checkPrime(final int number) {
		
		final List<Integer> primes55 = new ArrayList<Integer>(Arrays.asList( 
					2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 
					101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 
					197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257 ));

		if (primes55.contains(Integer.valueOf(number))) {
			return true;
		}
		if (number <= 257) {
			return false;
		}
	    for(int index = 3; index * index <= number; index += 2 ) {
	        if(number % index == 0) {
	            return false;
	        }
	    }
	    return true;
	}

	public static SpiralInt create(final int value) {
		return new SpiralInt(value);
	}

	public static int countSequenceToValue(final int value, final boolean columns) {

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

	public static int calculateValueAtCorner(final int offsetFromCenter, final int cornerSeed) {

		int value = 0;
		for (int x = 0; x < offsetFromCenter; x++) {
			value += cornerSeed + 8 * x;
		}
		return value;
	}

	public SpiralInt(final int value) {
		maxValue = (value < 0 ? -value : value);
		clockwise = (value >= 0);
		rowCount = calculateRows();
		columnCount = calculateColumns();
		calculateCenter();
		buildMatrix();
	}
	
	
	public List<ArrayList<Integer>> getMatrix() {
		return new ArrayList<ArrayList<Integer>>(matrix);
	}

	public int getMaxValue() {
		return maxValue;
	}

	
	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Point getMatrixCenter() {
		return new Point(matrixCenter);
	}

	public boolean isClockwise() {
		return clockwise;
	}

	// ############################################
	
	public SpiralInt setShowPrimeNumbersOnly(final boolean showPrimeNumbersOnly) {
		this.showPrimeNumbersOnly = showPrimeNumbersOnly;
		return this;
	}

	public SpiralInt setStarPrimeNumbers(final boolean starPrimeNumbers) {
		this.starPrimeNumbers = starPrimeNumbers;
		return this;
	}
	
	public Integer getValue(final int x, final int y) {
		
		if ( x < 0 || x >=columnCount || y < 0 || y >= rowCount ) {
			return null;
		}
		return matrix.get(y).get(x);
	}
	
	
	public String printSpiral() {

		final List<ArrayList<Integer>> data = matrix;
		if (!isClockwise()) {
			reverseColumnarValues(data);
		}
		final int padding = String.valueOf(maxValue).length() + (maxValue == 0 ? 0 : 1);

		final String formatString = "%" + padding + "s";
		final StringBuilder builder = new StringBuilder();

		for (int y = 0; y < rowCount; y++) {
			builder.append("[");
			for (int x = 0; x < columnCount; x++) {
				Integer value = data.get(y).get(x);
				if (value != null && (showPrimeNumbersOnly && !checkPrime(value))) {
					value = null;
				}
				final String val = (value == null ? "" : (showPrimeNumbersOnly && starPrimeNumbers ? "*" : String.valueOf(value)));
				builder.append(String.format(formatString, val));
			}
			builder.append("]\n");
		}
		return builder.toString();
	}

	// ############################################
	
	
	private void reverseColumnarValues(final List<ArrayList<Integer>> data) {
		Integer tmp;
		// reverse the data in columns
		for (int x = 0; x < columnCount; x++) {
			for (int y = 0; y < rowCount / 2; y++) {
				tmp = data.get(y).get(x);
				data.get(y).set(x, data.get(rowCount - 1 - y).get(x));
				data.get(rowCount - 1 - y).set(x, tmp);
			}
		}
	}

	// ############################################

	private void calculateCenter() {

		matrixCenter.y = (int) Math.floor((rowCount - 1) / 2);
		matrixCenter.x = (int) Math.floor((columnCount - 1) / 2);
	}

	private int calculateColumns() { // odd
		return countSequenceToValue(maxValue, true);
	}

	private int calculateRows() { // even
		return countSequenceToValue(maxValue, false);
	}

	private void buildMatrix() {

		for (int y = 0; y < rowCount; y++) {
			final ArrayList<Integer> row = new ArrayList<Integer>();
			for (int x = 0; x < columnCount; x++) {
				row.add(null);
			}
			matrix.add(row);
		}
		setOrigin();
		fillMatrix();
	}

	private void setOrigin() {
		matrix.get(matrixCenter.y).set(matrixCenter.x, 0);
	}

	private void fillMatrix() {
				
		if (rowCount == 1) { // 0 or 1 columns
			final Integer cornerValue=0;
			fillRow(new Point(0,0),new Point(columnCount-1,0),cornerValue,FILL_RIGHT,FILL_FORWARD);
			return;
		}
		
		int offsetFromCenter = 1;
		while ( offsetFromCenter - 1 <= matrixCenter.x ) {

			final Point point0 = new Point(matrixCenter.x - offsetFromCenter,matrixCenter.y - offsetFromCenter);
			final Integer cornerValue0 = calculateValueAtCorner(offsetFromCenter, UPPER_LEFT_CORNER);
						
			final Point point1 = new Point(matrixCenter.x + offsetFromCenter,matrixCenter.y + offsetFromCenter);
			final Integer cornerValue1 = calculateValueAtCorner(offsetFromCenter, LOWER_RIGHT_CORNER);

			if (point0.x >= 0 ) {
				fillColumn(point0, point1, cornerValue0, FILL_DOWN, FILL_REVERSE);
			}
			if (point1.x < columnCount) {
				fillColumn(point1, point0, cornerValue1, FILL_UP, FILL_REVERSE);
			}
			if ( point0.y >= 0) { // skip top line above our bounding square
				fillRow(   point0, point1, cornerValue0, FILL_RIGHT, FILL_FORWARD);
			}
			if ( point1.y < rowCount) { // skip top line above our bounding square
				fillRow(   point1, point0, cornerValue1, FILL_LEFT, FILL_FORWARD);
			}
			offsetFromCenter++;
		}

	}

	private void fillColumn(final Point point0, final Point point1, final Integer startingValue, final int rowDelta, final int valueDelta) {
		
		if (point0.x < 0 || point0.x >= columnCount ) {
			return;
		}
		
		Integer cellValue = startingValue;
		final int x = point0.x;
		int y = point0.y;
		
		for (; (rowDelta > 0 && y >= point0.y && y <= point1.y) || (rowDelta < 0 && y <= point0.y && y >= point1.y)
			 ; y += rowDelta, cellValue += valueDelta) {
			setPoint(x, y, cellValue);
		}
	}

	private void fillRow(final Point p0, final Point p1, final Integer startingValue, final int columnDelta, final int valueDelta) {
		
		if (p0.x < 0 || p0.x >= columnCount ) {
			return;
		}
		
		Integer cellValue = startingValue;
		int x = p0.x;
		final int y = p0.y;
		
		for ( ;  (columnDelta > 0 && x >= p0.x && x <= p1.x) || (columnDelta < 0 && x <= p0.x && x >= p1.x)
			 ; x += columnDelta, cellValue += valueDelta) {
			setPoint(x, y, cellValue); 
		}
	}

	private void setPoint(final int x, final int y, final Integer value) {
		if ( y >= 0 && y < rowCount && x >= 0 && x < columnCount) {
			matrix.get(y).set(x, (value > maxValue || value < 0 ? null : value));
		}
	}

	public void showPrimesOnly(final boolean showPrimesOnly) {
		this.setShowPrimeNumbersOnly(showPrimesOnly);
	}

	public void starPrimeNumbers(final boolean starPrimeNumbers) {
		this.setStarPrimeNumbers(starPrimeNumbers);
	}
}
