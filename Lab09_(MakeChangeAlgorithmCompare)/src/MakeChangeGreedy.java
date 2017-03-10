public class MakeChangeGreedy {

	// in sorted order from low to high
	public static int denoms[] = {1, 5, 10, 21, 25};
	public static int count = 0;
	public static int minCoins[] = new int[100]; 
	// index is amount of change, value of element is 
	// fewest number of coins for that amount of change
	
	// fewest number of coins to make amountOfChange
	public static int numberOfCoinsR(int amountOfChange)
	{
		//count++;
		//System.out.println(count);
		int numCoins, currNumCoins;
		
		// base case(s)
		for (int i=0; i<denoms.length; i++)
		{
			if (amountOfChange == denoms[i])
			{
				// ok just stop now, we're done
				return 1;
			}
		}
		
		// recursive step(s)
		
		int counter = 1;
		
		numCoins = numberOfCoinsR(counter) + numberOfCoinsR(amountOfChange - counter);
		counter++;
		
		while (counter <= amountOfChange/2)
		{
			currNumCoins = numberOfCoinsR(counter) + numberOfCoinsR(amountOfChange - counter);
			if (currNumCoins < numCoins)
			{
				numCoins = currNumCoins;
			}
			counter++;
		}
		
		
		return numCoins;
	}
	
	
	// GREEDY ALGORITHM TO MAKE CHANGE (works for US Denoms, but not all)
	// amountOfChange will come in multiplied by 100 already
	public static int numberOfCoins(int amountOfChange)
	{
		int numCoins = 0;
		
		for (int i=denoms.length-1; i>=0; i--)
		{
			
			while (amountOfChange >= denoms[i])
			{
				numCoins++;
				amountOfChange = amountOfChange - denoms[i];
			}
			
		}
		
		return numCoins;
	}
	
	public static void main(String[] args) 
	{
		int numCoins;
		int change = 28;
		long startNanoSeconds = System.nanoTime();
		numCoins = numberOfCoins(change);
		long endNanoSeconds = System.nanoTime();
		System.out.println("The greedy algorithm answer for number of coins to make " + change + " cents is " + numCoins);
		System.out.println("The greedy algorithm took " + (endNanoSeconds - startNanoSeconds)/(double)Math.pow(10, 9) + "seconds.");

		startNanoSeconds = System.nanoTime();
		numCoins = numberOfCoinsR(change);
		endNanoSeconds = System.nanoTime();
		System.out.println("The fewest number of coins to make " + change + " cents is " + numCoins);

		
		System.out.println("The terrible algorithm took " + (endNanoSeconds - startNanoSeconds)/(double)Math.pow(10, 9) + "seconds.");
		
	}

}