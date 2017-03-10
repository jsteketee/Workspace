public class MakeChangeGreedyEdit {

	// in sorted order from low to high
	public static int denoms[] = {1, 5, 10, 21, 25};
	public static int count = 0;
	public static int minCoins[] = new int[1000]; 
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
		int firstPart=0;
		int secondPart=0;
		
		//decision making, uses array or adds new values to array. 
		if (minCoins[counter]==0)
		{
			firstPart= numberOfCoinsR(counter);
			minCoins[counter]=firstPart;
		}
		else
			firstPart=minCoins[counter];
		
		if (minCoins[amountOfChange - counter]==0)
		{
			secondPart= numberOfCoinsR(amountOfChange - counter);
			minCoins[amountOfChange - counter] = secondPart;
		}
		else
			secondPart= minCoins[amountOfChange - counter];
		
		numCoins = firstPart +secondPart;
		//numCoins = numberOfCoinsR(counter) + numberOfCoinsR(amountOfChange - counter);
		counter++;
		
		while (counter <= amountOfChange/2)
		{
			//currNumCoins = numberOfCoinsR(counter) + numberOfCoinsR(amountOfChange - counter);
				if (minCoins[counter]==0)
				{
					firstPart= numberOfCoinsR(counter);
					minCoins[counter]=firstPart;
				}
				else
					firstPart=minCoins[counter];
				
				if (minCoins[amountOfChange - counter]==0)
				{
					secondPart= numberOfCoinsR(amountOfChange - counter);
					minCoins[amountOfChange - counter] = secondPart;
				}
				else
					secondPart= minCoins[amountOfChange - counter];
				
			currNumCoins = firstPart + secondPart;
			
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
	public static int greedyAlgorithm(int amountOfChange)
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
		int change = 943;
		long startNanoSeconds = System.nanoTime();
		numCoins = greedyAlgorithm(change);
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