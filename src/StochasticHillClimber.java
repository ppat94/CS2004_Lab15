import java.util.ArrayList;

public class StochasticHillClimber {
	
	public static double StochasticHillClimbing(int N, ArrayList<Integer> T, double d [][], int iter)
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
			
			double Pr = 1/(1 + Math.exp((NewFitness - OriginalFitness)/25));
			
			if (Pr <= 0.9)
			{
				ScalesSolutions.SetValue(OriginalList);
			} 
		}
		
		return(ScalesSolutions.GetFitness(N, ScalesSolutions.GetT(), d));
	}	

}
