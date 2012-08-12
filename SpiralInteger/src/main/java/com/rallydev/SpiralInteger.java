package com.rallydev;

import java.util.Arrays;

public class SpiralInteger 
{
	private transient final String borderLine;

	public static void main( final String[] args ) 
    {    
		final SpiralInteger obj = new SpiralInteger();
		obj.processInput(args);
    }

	public SpiralInteger() {
		final char[] border = new char[80];
    	Arrays.fill(border,'-');
    	borderLine = String.valueOf(border);				
	}
	
	private void processInput (final String[] args) {
		
		boolean starPrimeNumbers = false;
		boolean showPrimeOnly = false;
		
        for (String arg : args) {
        	if (arg.matches("[-]?[0-9]+")) {
        		printSpiral(Integer.valueOf(arg), showPrimeOnly, starPrimeNumbers);
        		showPrimeOnly=false;
        		starPrimeNumbers=false;
        	} else {
        		if (arg.compareToIgnoreCase("primes") == 0) {
        			showPrimeOnly = true;
        		} else if (arg.compareToIgnoreCase("stars") == 0) {
        			starPrimeNumbers =  true;
        		} else {
        			System.out.printf("\n!!! Invalid user input '%s'\n", arg); 
        		}
        	}
        }
    }

	private void printSpiral(final Integer arg, final boolean showPrimeNumbersOnly, final boolean starPrimeNumbers) {
		
		final Integer val=Integer.valueOf(arg);
		
		System.out.printf("\n%s\nSpiralInteger [%d] (%sclockwise%s)\n%s\n",  
						borderLine , val, (val < 0 ? "counter-" : ""),(showPrimeNumbersOnly ? " primes":""), borderLine);
		
		System.out.println(
						SpiralInt.create(Integer.valueOf(arg))
						.setShowPrimeNumbersOnly(showPrimeNumbersOnly)
						.setStarPrimeNumbers(starPrimeNumbers).printSpiral()
						);

	}
	
	
}
