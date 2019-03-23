import java.util.ArrayList;

public class SimulatedAnnealing {
	
	public static double SimulatedAnnealing(int N, ArrayList<Integer> T, double d [][], int iter)
	{
		double OriginalFitness; double NewFitness;
		ArrayList<Integer> OriginalList; 
		ArrayList<Integer> NewList;
		ArrayList<Integer> RandPerm = ScalesSolutions.RandPerm(N);
		ScalesSolutions.SetValue(RandPerm);
		
		double Temperature = 0.95;
		double TemperatureIter = 0.001;
		double CoolingRate = iter*(Math.sqrt(TemperatureIter/Temperature));
		
		double TemperatureI [] = new double [iter+1];
		TemperatureI[1] = Temperature;
		
		for (int i = 1; i < iter; i++) 
		{
			OriginalList = ScalesSolutions.GetT();
			OriginalFitness = ScalesSolutions.GetFitness(N, OriginalList, d);
			
			ScalesSolutions.Swap();
			
			NewList = ScalesSolutions.GetT();
			NewFitness = ScalesSolutions.GetFitness(N, NewList, d);
			
			if (NewFitness > OriginalFitness) 
			{
				double p = PR(NewFitness, OriginalFitness, TemperatureI [i]);
				if (p < CS2004.UR(0, 1)) 
				{
					ScalesSolutions.SetValue(OriginalList);
				}
				else
				{
					// Do not change/Keep the change
				}
				
			}
			else
			{
				// Keep the new fitness
			}
			TemperatureI[i + 1] = CoolingRate * TemperatureI[i];
		}
		return ScalesSolutions.GetFitness(N, ScalesSolutions.GetT(), d);
	}
	
	public static double PR (double newFitness, double oldFitness, double TemperatureI)
	{
		double f = oldFitness - newFitness;
		double p = Math.exp(-f/TemperatureI);
		return p;	
	}
	
}
