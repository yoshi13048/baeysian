package CPT;

public class SearchProbability {

	private double[] probability;

	public SearchProbability(double[] probability){
		this.probability = probability;
	}

	public double TargetProbability(int[] appearance){
		int num=0;
		for(int x=0; x<appearance.length; x++){
			num += appearance[x] * 2 * x;
		}

		return probability[num];
	}
}
