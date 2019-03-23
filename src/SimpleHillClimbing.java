import java.util.ArrayList;

public class SimpleHillClimbing {
	
	public static double SimpleHillClimbing(int N, ArrayList<Integer> T, double d [][], int iter)
	{
		double OriginalFitness; double NewFitness;
		ArrayList<Integer> OriginalList; 
		ArrayList<Integer> NewList;
		ArrayList<Integer> RandPerm = ScalesSolutions.RandPerm(N);
		ScalesSolutions.SetValue(RandPerm);
	
		for (int i = 1; i <= iter; i++)
		{
			OriginalList = ScalesSolutions.GetT();
			OriginalFitness = ScalesSolutions.GetFitness(N, OriginalList, d);
			
			ScalesSolutions.Swap();
			
			NewList = ScalesSolutions.GetT();
			NewFitness = ScalesSolutions.GetFitness(N, NewList, d);
			
			if (NewFitness > OriginalFitness)
			{
				ScalesSolutions.SetValue(OriginalList);
			} 
		}
		
		return(ScalesSolutions.GetFitness(N, ScalesSolutions.GetT(), d));
	}	
}
