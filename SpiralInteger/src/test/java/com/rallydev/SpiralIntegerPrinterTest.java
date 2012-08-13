package com.rallydev;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SpiralIntegerPrinterTest {

	@Test
	public void checkPrime2To3IsTrue() {
		final String format = "%d should Be Prime";
		assertTrue(String.format(format,2), SpiralIntegerPrinter.checkPrime(2));
		assertTrue(String.format(format,2), SpiralIntegerPrinter.checkPrime(3));
	}
	@Test
	public void checkPrime4IsFalse() {
		assertFalse("4 should not be prime!",SpiralIntegerPrinter.checkPrime(4));
	}
	@Test
	public void checkPrime258To262IsFalse() {
		for (int i=258; i< 263; i++) {
			assertFalse(String.format("%d should not be Prime!",i),SpiralIntegerPrinter.checkPrime(i));
		}
	}
	@Test
	public void checkPrime263IsTrue() {
		assertTrue("263 should be prime!",SpiralIntegerPrinter.checkPrime(263));
	}
	
}
