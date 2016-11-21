package parent_list;

import java.util.ArrayList;

/**
 * @author al13048
 *ノードxが持つ子ノードを集めたリスト
 */
public class ParentList {

	private int parent_node;
	private int[] child_node;

	public ParentList(int parent_node){
		this.parent_node = parent_node;
	}

	/**
	 * @param child_node 指定した子ノードを設定する
	 */
	public void setParentList(ArrayList<Integer> child_node){
		this.child_node = new int[child_node.size()];
		for(int x=0; x<child_node.size(); x++){
			this.child_node[x] = child_node.get(x);
		}
	}

	public int getParentNode(){
		return parent_node;
	}

	public int[] getChildNode(){
		return child_node;
	}

	public int getChildNodeLength(){
		return child_node.length;
	}
}
