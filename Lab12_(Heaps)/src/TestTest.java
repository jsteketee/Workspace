
public class TestTest {

	public static int meth7(int x)
	{
		int y=0;
		for (int i=1;i<=x;i++)
		{
			if (i%2==1)
				y+=i*5;
			else
				y+=i;
		}
		return y;
	}
	public static int meth8(int x)
	{
		return meth8(x,0);
	}
	public static int meth8(int x, int y)
	{
		if (x==0)
			return y;
		else
		{
			if (x%2==1)
				y+=x*5;
			else
				y+=x;
		}		
		x--;
		return meth8(x,y);
	}
	public static void main(String[] args) {
		
		
		for (int i = 0; i<=10;i++)
		{
			System.out.println(meth7(i));
			System.out.println(meth8(i));
			System.out.println("******");
		}
		
	}	

}
