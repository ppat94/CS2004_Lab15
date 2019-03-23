import java.util.ArrayList;

public class RandomRestartHillClimbing {
	
	public static double RandomRestartClimbing(int N, ArrayList<Integer> T, double d [][], int iter)
	{
		double OriginalFitness; double NewFitness;
		ArrayList<Integer> OriginalList; 
		ArrayList<Integer> NewList;
		ArrayList<Integer> RandPerm = ScalesSolutions.RandPerm(N); // Random Permutation
		ScalesSolutions.SetValue(RandPerm);
		
		int RestartTime = iter/10; double BestFitness = ScalesSolutions.GetFitness(N, ScalesSolutions.GetT(), d); 
	
		for (int i = 1; i <= iter; i++)
		{
			if (i % RestartTime == 0)
			{
				double CurrentFitness = ScalesSolutions.GetFitness(N, ScalesSolutions.GetT(), d);
				if (CurrentFitness < BestFitness) 
				{
					BestFitness = CurrentFitness;
				}
				ArrayList<Integer> NewRandPerm = ScalesSolutions.RandPerm(N);
				ScalesSolutions.SetValue(RandPerm);
			}
			OriginalList = ScalesSolutions.GetT();
			OriginalFitness = ScalesSolutions.GetFitness(N, OriginalList, d);
			
			ScalesSolutions.Swap();
			
			NewList = ScalesSolutions.GetT(); // This will apply the small change to the original solution
			NewFitness = ScalesSolutions.GetFitness(N, NewList, d); // Find the fitness of the new solution
			
			if (NewFitness > OriginalFitness) // This is to check if the new fitness is better than the old fitness
			{
				ScalesSolutions.SetValue(OriginalList);
			} 
		}
		return(BestFitness);
	}	

}
