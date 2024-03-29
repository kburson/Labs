package com.rallydev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralIntegerFormatter implements ISpiralIntegerFormatter {
	
	private boolean printClockwise = true;
	private boolean showPrimeNumbersOnly = false;
	private boolean printStars = false;

	// ############################################

	public static boolean checkPrime(final int number) {
		
		final List<Integer> primes55 = new ArrayList<Integer>(Arrays.asList( 
					2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 
					101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 
					197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257 ));

		final int prime = Math.abs(number);
		boolean results = true;
		
		if (primes55.contains(Integer.valueOf(prime))) {
			results = true;
		} else if (prime <= 257 || prime % 2 == 0) {
			results = false;
		} else {
			// seek from 2 - sqrt(number)
		    for(int index = 3; index * index <= prime; index += 2 ) {
		        if(prime % index == 0) {
		            results=false;
		            break;
		        }
		    }
		}
		
	    return results;
	}

	// --------------------------------------------
	// ############################################
	
	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#setShowPrimeNumbersOnly(boolean)
	 */
	@Override
	public ISpiralIntegerFormatter setShowPrimeNumbersOnly(final boolean showPrimeNumbersOnly) {
		this.showPrimeNumbersOnly = showPrimeNumbersOnly;
		return this;
	}

	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#setPrintStars(boolean)
	 */
	@Override
	public ISpiralIntegerFormatter setPrintStars(final boolean starPrimeNumbers) {
		this.printStars = starPrimeNumbers;
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#setPrintClockwise(boolean)
	 */
	@Override
	public ISpiralIntegerFormatter setPrintClockwise(final boolean printClockwise) {
		this.printClockwise = printClockwise;	
		return this;
	}

	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#willPrintStars()
	 */
	@Override
	public boolean willPrintStars() {
		return printStars;
	}

	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#willShowPrimeNumbersOnly()
	 */
	@Override
	public boolean willShowPrimeNumbersOnly() {
		return showPrimeNumbersOnly;
	}

	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#willPrintClockwise()
	 */
	@Override
	public boolean willPrintClockwise() {
		return printClockwise;
	}
	
	// -------------------------------------------
	
	/* (non-Javadoc)
	 * @see com.rallydev.ISpiralIntegerPrinter#print(com.rallydev.IntegerMatrix)
	 */
	@Override
	public String print(final IntegerMatrix matrix) {

		final List<ArrayList<Integer>> data = matrix.getMatrixCopy();
		if (!printClockwise) {
			reverseColumnarValues(data);
		}
		final int padding = String.valueOf(matrix.getMaxValue()).length() + (matrix.getMaxValue() == 0 ? 0 : 1);
		final String formatString = "%" + padding + "s";
		
		return formatMatrix(data, formatString);
	}

	
	private String formatMatrix(final List<ArrayList<Integer>> data,
			final String formatString) {

		final StringBuilder builder = new StringBuilder();

		for (int y = 0; y < data.size(); y++) {
			builder.append("[");
			for (int x = 0; x < data.get(0).size(); x++) {
				builder.append(String.format(formatString, formatValue(data.get(y).get(x))));
			}
			builder.append("]\n");
		}
		
		return builder.toString();
	}

	// ############################################

	private String formatValue(final Integer cellValue) {
		Integer value = null;
		if (cellValue != null && (!showPrimeNumbersOnly || checkPrime(cellValue))) {
			value = cellValue;
		}
		return (value == null ? "" : ( printStars ? "*" : String.valueOf(value)));
	}

		
	private void reverseColumnarValues(final List<ArrayList<Integer>> data) {
		Integer tmp;
		// reverse the data in columns
		for (int x = 0; x < data.get(0).size(); x++) {
			for (int y = 0; y < data.size() / 2; y++) {
				tmp = data.get(y).get(x);
				data.get(y).set(x, data.get(data.size() - 1 - y).get(x));
				data.get(data.size() - 1 - y).set(x, tmp);
			}
		}
	}

	

	// ############################################

}
