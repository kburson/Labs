package com.rallydev;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public final class IntegerMatrix {

	private final int maxValue;
	private final Point matrixCenter;

	private final List<ArrayList<Integer>> matrix;

	// #######################################################
	
	public static IntegerMatrix createMatrix(final int value, final Point center, final Point lowerRight) {
		return new IntegerMatrix(value,center,lowerRight);
	}

	// ----------------------------------------------

	private IntegerMatrix(final int value, final Point center, final Point lowerRight) {
		maxValue = (value < 0 ? -value : value);
		matrixCenter = center;
		matrix = new ArrayList<ArrayList<Integer>>();
		
		for (int y = 0; y <= lowerRight.y; y++) {
			final ArrayList<Integer> row = new ArrayList<Integer>();
			for (int x = 0; x <= lowerRight.x; x++) {
				row.add(null);
			}
			matrix.add(row);
		}
	}

	// ----------------------------------------------

	public Point getMatrixCenter() {
		return matrixCenter;
	}

	public int getColumnCount() {
		return matrix.get(0).size();
	}

	public int getRowCount() {
		return matrix.size();
	}

	
	public void setPointValue(final Point point, final int value) {
		setPointValue(point,Integer.valueOf(value));
	}

	public void setPointValue(final Point point, final Integer value) {
		if (point.y >= 0 && point.y < matrix.size() && point.x >= 0 && point.x < matrix.get(0).size()) {
			Integer val = null;
			if (value <= maxValue) {
				val = value;
			}
			matrix.get(point.y).set(point.x, val);
		}
	}

	public Integer getValue(final Point point) {
		return getValue(point.x,point.y);
	}

	public Integer getValue(final int x, final int y) {

		Integer results = null;
		if (x >=0 && y >= 0 && x < getColumnCount() && y < getRowCount()) {
			results = matrix.get(y).get(x);
		}
		return results; 
	}
	
	public int getMaxValue() {
		return maxValue;
	}


	public List<ArrayList<Integer>> getMatrixCopy() {
		return new ArrayList<ArrayList<Integer>>(matrix);
	}


}