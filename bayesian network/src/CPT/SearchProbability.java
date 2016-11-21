package CPT;

/**
 * @author al13048
 *指定された条件付き確率を検索するクラス
 */
public class SearchProbability {

	private double[] probability;

	public SearchProbability(double[] probability){
		this.probability = probability;
	}

	/**
	 * @param appearance 出現条件
	 * @return 条件付き確率
	 * 出現条件に対応した条件付き確率を返す
	 */
	public double TargetProbability(int[] appearance){
		int num=0;
		for(int x=0; x<appearance.length; x++){
			num += appearance[x] * 2 * (x+1);
		}
		return probability[num];
	}
}
