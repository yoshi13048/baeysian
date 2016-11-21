package child_list;

import java.util.ArrayList;

/**
 * @author al13048
 *ノードxが持つ親ノードを集めたリスト
 */
public class ChildList {

	private int[] parent_node;
	private int child_node;

	public ChildList(int child_node){
		this.child_node = child_node;
	}

	/**
	 * @param parent_node 指定した子ノードを設定する
	 */
	public void setChildList(ArrayList<Integer> parent_node){
		this.parent_node = new int[parent_node.size()];
		for(int x=0; x<parent_node.size(); x++){
			this.parent_node[x] = parent_node.get(x);
		}
	}

	public int getChildNode(){
		return child_node;
	}

	public int[] getParentNode(){
		return parent_node;
	}

	public int getParentNodeLength(){
		return parent_node.length;
	}
}
