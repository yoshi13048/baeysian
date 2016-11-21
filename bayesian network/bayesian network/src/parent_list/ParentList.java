package parent_list;

import java.util.ArrayList;

public class ParentList {

	private int parent_node;
	private int[] child_node;

	ParentList(int parent_node){
		this.parent_node = parent_node;
	}

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
