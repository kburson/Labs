package com.rallydev;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SpiralIntegerFactoryCalculationsTest {

	final int UPPER_RIGHT = 8, LOWER_RIGHT=2, UPPER_LEFT=6, LOWER_LEFT=4;

	private static final SpiralIntegerFactory factory = SpiralIntegerFactory.getInstance();

	
	// ########################
	@Test
	public void topLeftCornerAtOffset_0_is_0() {
		final int cornerOffset = 0;
		final int expectedValue = 0;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	public void topLeftCornerAtOffset_1_is_6() {
		final int cornerOffset = 1;
		final int expectedValue = 6;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	public void topLeftCornerAtOffset_2_is_20() {
		final int cornerOffset = 2;
		final int expectedValue = 20;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	public void topLeftCornerAtOffset_3_is_42() {
		final int cornerOffset = 3;
		final int expectedValue = 42;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	@Test
	public void topLeftCornerAtOffset_4_is_72() {
		final int cornerOffset = 4;
		final int expectedValue = 72;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,UPPER_LEFT));
	}
	
	// -----------------
	
	@Test
	public void bottomRightCornerAtOffset_0_is_0() {
		final int cornerOffset = 0;
		final int expectedValue = 0;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,LOWER_RIGHT));
	}
	@Test
	public void bottomRightCornerAtOffset_1_is_2() {
		final int cornerOffset = 1;
		final int expectedValue = 2;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,LOWER_RIGHT));
	}
	@Test
	public void bottomRightCornerAtOffset_2_is_12() {
		final int cornerOffset = 2;
		final int expectedValue = 12;
		
		assertEquals(expectedValue,factory.calculateValueAtCorner(cornerOffset,LOWER_RIGHT));
	}

}
