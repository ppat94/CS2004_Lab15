import java.util.ArrayList;

public class ScalesSolutions {
	
	public static ArrayList<Integer> T;
	
	public static ArrayList<Integer> RandPerm(int n)
	{
		ArrayList<Integer> P = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			{
			 	P.add(i); // Add the values to the original list
			}
		
		// Shuffle the ArrayList to get a random permutation
		for (int i = 0; i < n; i++)
		{
			int rand1 = CS2004.UI(0, n-1);
			int rand2 = CS2004.UI(0, n-1);
			int temp1 = P.get(rand1);
			int temp2 = P.get(rand2);
			P.set(rand1, temp2);
			P.set(rand2, temp1);
		}
		return P;
	}

	public static double GetFitness (int N, ArrayList<Integer> T, double d [][])
	{
		double s = 0;
		for (int i = 0; i < N - 1; i++) 
		{
			int a = T.get(i);
			int b = T.get(i + 1);
			s = s + d[a][b];
		}
		int end_city = T.get(N-1);
		int start_city = T.get(0);
		
		s = s + d[end_city][start_city];
		
		return s;
	}
	
	public static void Swap()
	{
		int n = T.size();
		
		int rand1 = CS2004.UI(0, n-1); // This will find a random integer between 0 and n
		int rand2 = CS2004.UI(0, n-1);
		if (rand1 == rand2) // This is used for validation if rand1 and rand2 are the same
		{
			if (rand1 >= 0 && rand1 != n-1) 
			{
				rand1 = rand1 + 1;
			}
			else
			{
				rand1 = rand1 - 1;
			}
		}
		int temp1 = T.get(rand1);
		int temp2 = T.get(rand2);
		T.set(rand1, temp2);
		T.set(rand2, temp1);
	
	}
	
	public static void SetValue(ArrayList<Integer> x)
	{
		T = (ArrayList<Integer>) x.clone();
	}
	
	public static ArrayList<Integer> GetT()
	{
		ArrayList<Integer> x = (ArrayList<Integer>) T.clone();
		return x;
	}


}
