package sampling;

/**
 * @author al13048
 *ノードxが出現したかどうかという情報を保持するリスト構造
 */
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
