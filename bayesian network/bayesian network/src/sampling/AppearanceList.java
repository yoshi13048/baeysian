package sampling;

public class AppearanceList {

	private int node_num;
	private int appearance;

	public AppearanceList(int node_num, int appearance){
		this.node_num = node_num;
		this.appearance = appearance;
	}

	public AppearanceList(){

	}

	public int getNodeNum(){
		return node_num;
	}

	public int getAppearance(){
		return appearance;
	}

	public void setAppearance(int node_num, int appearance){
		this.node_num = node_num;
		this.appearance = appearance;
	}
}
