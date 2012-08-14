package com.rallydev;

import java.io.PrintStream;
import java.util.Arrays;

public final class SpiralInteger {
	public transient final String borderLine;


	private transient ISpiralIntegerFormatter formatter = null;
	private transient PrintStream printStream = null;

	public static SpiralInteger create() {
		final SpiralInteger spiralInteger = new SpiralInteger();
		spiralInteger.setPrinter(new SpiralIntegerFormatter());
		spiralInteger.setPrintStream(System.out);
		return spiralInteger;
	}

	public static void main(final String[] args) {
		SpiralInteger.create().processInput(args);
	}

	public void setPrinter(final ISpiralIntegerFormatter printer) {
		if (printer != null) {
			this.formatter = printer;
		}
	}

	public void setPrintStream(final PrintStream stream) {
		if (stream != null) {
			printStream = stream;
		}
	}

	private SpiralInteger() {
		final char[] border = new char[80];
		Arrays.fill(border, '-');
		borderLine = String.valueOf(border);
	}

	public void processInput(final String[] args) {

		boolean starPrimeNumbers = false;
		boolean showPrimeOnly = false;

		for (String arg : args) {
			if (arg.matches("[-]?[0-9]+")) {
				
				final Integer maxValue = Integer.valueOf(arg);
				printStream.printf("\n\n%s\nSpiralInteger [%d] (%sclockwise%s)\n%s\n",
						borderLine, maxValue, (maxValue < 0 ? "counter-" : ""),
						(showPrimeOnly ? " primes" : ""), borderLine);

				printSpiral(maxValue, showPrimeOnly, starPrimeNumbers);
				
				showPrimeOnly = false;
				starPrimeNumbers = false;
				
			} else {
				if (arg.compareToIgnoreCase("prime") == 0) {
					showPrimeOnly = true;
				} else if (arg.compareToIgnoreCase("star") == 0) {
					starPrimeNumbers = true;
				} else {
					printStream.printf("\n!!! Invalid user input '%s'\n", arg);
				}
			}
		}
	}

	public void printSpiral(final Integer maxValue,
			final boolean showPrimeNumbersOnly, final boolean starPrimeNumbers) {

		printStream.println(
				 formatter
				.setPrintClockwise(maxValue >= 0)
				.setShowPrimeNumbersOnly(showPrimeNumbersOnly)
				.setPrintStars(starPrimeNumbers)
				.print(SpiralIntegerFactory.getInstance().createMatrix(Math.abs(maxValue))));

	}

}
