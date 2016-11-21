package node_list;

import java.util.ArrayList;
import java.util.Arrays;


public class NodeCheck {

	private int[] nodeBranchCheck;
	private int[] nodeJunctionCheck;

	//コンストラクタ
	//iノード総数
	//j枝個数
	//k子個数
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

	public boolean countNodeBranchCheck(int i){
		if(nodeBranchCheck[i] != 0){
			nodeBranchCheck[i] = nodeBranchCheck[i] - 1;
			return true;
		}
		else{
			return false;
		}
	}

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
