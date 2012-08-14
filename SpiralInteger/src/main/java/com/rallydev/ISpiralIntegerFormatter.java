package com.rallydev;

public interface ISpiralIntegerFormatter {

	ISpiralIntegerFormatter setShowPrimeNumbersOnly(
			final boolean showPrimeNumbersOnly);

	ISpiralIntegerFormatter setPrintStars(
			final boolean starPrimeNumbers);

	ISpiralIntegerFormatter setPrintClockwise(
			final boolean printClockwise);

	boolean willPrintStars();

	boolean willShowPrimeNumbersOnly();

	boolean willPrintClockwise();

	String print(final IntegerMatrix matrix);

}