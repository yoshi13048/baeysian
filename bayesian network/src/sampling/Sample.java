package sampling;

/**
 * @author al13048
 *サンプルの構造
 */
public class Sample {

	private int appearance;
	private int node_num;
	private int count;

	public Sample(int node_num){
		this.node_num = node_num;
	}

	public void setAppearance(int x, int y){
		appearance = x;
		count = y;
	}

	public int getNodenum(){
		return this.node_num;
	}

	public int getAppearance(){
		return this.appearance;
	}

	public int getCount(){
		return this.count;
	}
}

