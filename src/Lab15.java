import java.util.ArrayList;

public class Lab15 {

	public static void main(String args[])
	{
		int N = 48;
		double d [][] = TSP.ReadArrayFile("C://Users/Parth/Desktop/CS2004 TSP Data (2015-2016)/TSP_" + N + ".txt", " ");
		
		ArrayList<Integer> RandPerm = ScalesSolutions.RandPerm(N);
		ScalesSolutions.SetValue(RandPerm); 
		
		ScalesSolutions.Swap();
		ArrayList<Integer> T1 = ScalesSolutions.GetT();
		
		double x = ScalesSolutions.GetFitness(N, RandPerm, d);
		
		// 10000 for initial testing
		int iter = 10000;
		double OPT = OptimalSolution(N, d);
		System.out.println(OPT);
		
		// Simple Hill Climbing Algorithm
		double total = 0;
		for (int i = 0; i < 10; i++)
		{
			double f1 = SimpleHillClimbing.SimpleHillClimbing(N, RandPerm, d, iter);
			total = total + f1;
		}
		double Accuracy = (OPT/(total/10))*100;
		System.out.println(Accuracy);
		
		// Stochastic Hill Climbing Algorithm
		total = 0;
		for (int i = 0; i < 10; i++)
		{
			double f2 = StochasticHillClimber.StochasticHillClimbing(N, RandPerm, d, iter);
			total = total + f2;
		}
		Accuracy = (OPT/(total/10))*100;
		System.out.println(Accuracy);
		
		// Random Restart Climbing Algorithm
		total = 0;
		for (int i = 0; i < 10; i++)
		{
			double f3 = RandomRestartHillClimbing.RandomRestartClimbing(N, RandPerm, d, iter);
			total = total + f3;
		}
		Accuracy = (OPT/(total/10))*100;
		System.out.println(Accuracy);
		
		// Simulated Annealing Algorithm
		total = 0;
		for (int i = 0; i < 10; i++)
		{
			double f4 = SimulatedAnnealing.SimulatedAnnealing(N, RandPerm, d, iter);
			total = total + f4;
		}
		Accuracy = (OPT/(total/10))*100;
		System.out.println(Accuracy);
	}
	
	public static double OptimalSolution(int N, double d [][])
	{
		ArrayList<Integer> OPT = TSP.ReadIntegerFile("C://Users/Parth/Desktop/CS2004 TSP Data (2015-2016)/TSP_" + N + "_OPT.txt");
		double OPTDistance = ScalesSolutions.GetFitness(N, OPT, d);
		return OPTDistance;
	}
}
