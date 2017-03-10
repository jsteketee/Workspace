
public class PowerCode {

static int count=0;

	public static double powerCode(double b, int p)
	{
		count++;
		
		if (p==0)
			return 1;
		if (p>0)
			return b*powerCode(b, p-1);
		else
			return (1/b)*powerCode(b, p+1);
			
		
	}
	
	public static double powerFast(double b, int p)
	{
		count++;
		
		if (p==0)
			return 1;
		if (p>0)
		{
			if (p==1)
				return b;
			if (p==2)
				return b*b;
			//if even
			if (p%2==0)
			{
				//System.out.println("Getting here with b = " + b + " and p = " + p);
				return powerFast(powerFast(b,p/2),2);
			}
			//if odd
			else//if (p%2!=0)
			{
				return b*powerFast(b,p-1);
			}
		}
		else
		{
			if (p==-1)
				return 1/b;
			if (p==-2)
				return (1/b)*(1/b);
			//if even
			if (p%2==0)
			{
				//System.out.println("Getting here with b = " + b + " and p = " + p);
				return powerFast(powerFast(b,p/2),2);
			}
			//if odd
			else//if (p%2!=0)
			{
				return (1/b)*powerFast(b,p+1);
			}
		
		}
			
		
		
		
	}
	public static void main(String[] args) {
		
		int base=2;
		int power=20;
		long startNanoSeconds = System.nanoTime();
		double powerSlow = powerCode(base, power);
		long endNanoSeconds = System.nanoTime();
		System.out.println("The powerCode for base "+ base+ " raised to the power of "+ power+ " is: "+ powerSlow);
		System.out.println("The powerCode algorithm took " + (endNanoSeconds - startNanoSeconds)/(double)Math.pow(10, 9) + "seconds.");
		System.out.println(count);
		
		count=0;
		startNanoSeconds = System.nanoTime();
		double powerFast = powerFast(base,power);
		endNanoSeconds = System.nanoTime();
		System.out.println("The powerFast for base "+ base+ " raised to the power of "+ power+ " is: "+ powerFast);
		System.out.println("The powerFast algorithm took " + (endNanoSeconds - startNanoSeconds)/(double)Math.pow(10, 9) + "seconds.");
		System.out.println(count);
		
	}

}
