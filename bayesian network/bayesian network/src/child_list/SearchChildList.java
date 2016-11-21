package child_list;

import java.util.ArrayList;

public class SearchChildList {
	private ArrayList<ChildList> childlist;

	public SearchChildList(ArrayList<ChildList> childlist){
		this.childlist = childlist;
	}

	public ArrayList<Integer> ParentNode(int child_node){
		ArrayList<Integer> parent_node = new ArrayList<Integer>();
		for(int i=0; i<childlist.size(); i++){
			if(child_node == childlist.get(i).getChildNode()){
				for(int n=0; n<childlist.get(i).getParentNodeLength(); n++)
				parent_node.add(childlist.get(i).getParentNode()[n]);
			}
		}

		return parent_node;
	}
}
