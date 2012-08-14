package com.rallydev;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class SpiralIntegerTest {

	ISpiralIntegerFormatter printFormat;
	SpiralInteger spiralInteger;
	OutputStream output;
	
	@Before
	public void setUp() {
		printFormat = new SpiralIntegerFormatter();
		output = new ByteArrayOutputStream();
		spiralInteger = SpiralInteger.create();
		spiralInteger.setPrinter(printFormat);
		spiralInteger.setPrintStream(new PrintStream(output));		
	}
	
	@Test
	public void printSpiralWithValue_3_Prints2x2Matrix() {
		
		boolean showPrimeNumbersOnly = false;
		boolean starPrimeNumbers = false;
		int maxValue = 3;
		
		spiralInteger.printSpiral(maxValue, showPrimeNumbersOnly , starPrimeNumbers );
		
		String results = output.toString();
		assertEquals(String.format("printed spiral integer %d not have 15 char", maxValue),15,results.length());
		assertEquals("[ 0 1]\n[ 3 2]\n\n",results);
	}

	@Test
	public void printSpiralWithValue_Neg3_Prints2x2MatrixReversed() {
		
		boolean showPrimeNumbersOnly = false;
		boolean starPrimeNumbers = false;
		int maxValue = -3;
		
		spiralInteger.printSpiral(maxValue, showPrimeNumbersOnly , starPrimeNumbers );
		
		String results = output.toString();
		assertEquals(String.format("printed spiral integer %d not have 15 char", maxValue),15,results.length());
		assertEquals("[ 3 2]\n[ 0 1]\n\n",results);
	}

	@Test
	public void printSpiralWithValue_4_Prints2x3MatrixWithNullSpace() {
		
		boolean showPrimeNumbersOnly = false;
		boolean starPrimeNumbers = false;
		int maxValue = 4;
		
		spiralInteger.printSpiral(maxValue, showPrimeNumbersOnly , starPrimeNumbers );
		
		String results = output.toString();
		assertEquals(String.format("printed spiral integer %d not have 19 char", maxValue),19,results.length());
		assertEquals("[   0 1]\n[ 4 3 2]\n\n",results);
	}
	
	
	@Test
	public void processInputWithInvalidArgPrintsError() {
		
		String invalidInput = "three";
		
		spiralInteger.processInput(new String[] {invalidInput});

		String expected = String.format(
				"\n!!! Invalid user input '%s'\n",invalidInput );
				
		assertEquals(expected,output.toString());

	}
	
	
	@Test
	public void processInputWithValue_3_PrintsHeaderWithClockwiseThen2x2Matrix() {

		String maxValue = "3";
		
		spiralInteger.processInput(new String[] {maxValue});
		
		String expected = String.format(
				"\n\n%s\nSpiralInteger [%s] (clockwise)\n%s\n[ 0 1]\n[ 3 2]\n\n",
				spiralInteger.borderLine, 
				maxValue, 
				spiralInteger.borderLine );
				
		assertEquals(expected,output.toString());

	}

	@Test
	public void processInputWithValue_neg3_PrintsHeaderWithCounterClockwiseThen2x2MAtrix() {

		String maxValue = "-3";
		
		spiralInteger.processInput(new String[] {maxValue});
		
		String msg = String.format(
				"\n\n%s\nSpiralInteger [%s] (counter-clockwise)\n%s\n[ 3 2]\n[ 0 1]\n\n",
				spiralInteger.borderLine, 
				maxValue, 
				spiralInteger.borderLine );
				
		assertEquals(msg,output.toString());

	}

	@Test
	public void processInputWithValues_prime_3_PrintsHeaderWithClockwisePrimesThen2x2WithNullRow() {

		String maxValue = "3";
		
		spiralInteger.processInput(new String[] {"prime", maxValue});
		
		String msg = String.format(
				"\n\n%s\nSpiralInteger [%s] (clockwise primes)\n%s\n[    ]\n[ 3 2]\n\n",
				spiralInteger.borderLine, 
				maxValue, 
				spiralInteger.borderLine );
				
		assertEquals(msg,output.toString());

	}
	

	@Test
	public void processInputWithValues_star_prime_3_PrintsHeaderWithClockwisePrimesThen2x2WithNullRowAndStars() {

		String maxValue = "3";
		
		spiralInteger.processInput(new String[] {"star","prime", maxValue});
		
		String msg = String.format(
				"\n\n%s\nSpiralInteger [%s] (clockwise primes)\n%s\n[    ]\n[ * *]\n\n",
				spiralInteger.borderLine, 
				maxValue, 
				spiralInteger.borderLine );
				
		assertEquals(msg,output.toString());

	}

	@Test
	public void processInputWithValues_star_prime_neg3_PrintsHeaderWithCounterClockwisePrimesThen2x2WithNullRowAndStars() {

		String maxValue = "-3";
		
		spiralInteger.processInput(new String[] {"star","prime", maxValue});
		
		String msg = String.format(
				"\n\n%s\nSpiralInteger [%s] (counter-clockwise primes)\n%s\n[ * *]\n[    ]\n\n",
				spiralInteger.borderLine, 
				maxValue, 
				spiralInteger.borderLine );
				
		assertEquals(msg,output.toString());

	}

}
