package node_list;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author al13048<br>
 * グラフ内でのノードがどのような構造になっているかを調べるためのクラス
 */

public class NodeCheck {

	private int[] nodeBranchCheck;
	private int[] nodeJunctionCheck;

	//コンストラクタ
	//iノード総数
	//j枝個数
	//k子個数
	/**
	 * @param i グラフのノード総数
	 * @param j ノードが持てる子ノードの最大個数
	 * @param k ノードが持てる親ノードの最大個数
	 */
	public NodeCheck(int i, int j, int k){
		this.nodeBranchCheck = new int[i];
		this.nodeJunctionCheck = new int[i];
		Arrays.fill(nodeBranchCheck, j);
		Arrays.fill(nodeJunctionCheck, k);
	}



	public int getNodeBranchCheck(int i){
		return nodeBranchCheck[i];
	}

	public int getNodeJunctionCheck(int i){
		return nodeJunctionCheck[i];
	}

	/**
	 * @param i ノード番号<br>
	 * ノード番号iのノードが持てる子ノードの最大個数を超えていないかを調べるメソッド<br>
	 * @return 超えていなければtrue 超えていればfalseを返す
	 */
	public boolean countNodeBranchCheck(int i){
		if(nodeBranchCheck[i] != 0){
			nodeBranchCheck[i] = nodeBranchCheck[i] - 1;
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * @param nodelist
	 * @param parent_node
	 * @param child_node
	 * <br>指定されたparent_nodeが既に指定されたchild_nodeを子ノードに持っているかどうかを判定するメソッド<br>
	 * @return 既に持っている場合true 持っていない場合falseを返す
	 */
	public boolean overlapChildCheck(ArrayList<Nodes> nodelist, int parent_node, int child_node){
		int tmp = 0;
		for(int i=0; i<nodelist.size(); i++){
			if(parent_node == nodelist.get(i).getParent_node()){
				tmp = nodelist.get(i).getChild_node();
				break;
			}
		}

		if(tmp == child_node)
			return true;
		else
			return false;
	}

	/**
	 * @param j ノード番号
	 * <br>ノード番号jのノードが持てる親ノードの最大個数を超えていないかどうかを調べるメソッド<br>
	 * @return 超えていなければtrue 超えていればfalseを返す
	 */
	public boolean countNodeJunctionCheck(int j){
		if(nodeJunctionCheck[j] != 0){
			nodeJunctionCheck[j] = nodeJunctionCheck[j] - 1;
			return true;
		}
		else{
			return false;
		}
	}
}
