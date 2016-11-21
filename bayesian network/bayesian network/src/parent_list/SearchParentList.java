package parent_list;

import java.util.ArrayList;

public class SearchParentList {

	private ArrayList<ParentList> parentlist;

	public SearchParentList(ArrayList<ParentList> parentlist){
		this.parentlist = parentlist;
	}

	public ArrayList<Integer> ChildNode(int parent_node){
		ArrayList<Integer> child_node = new ArrayList<Integer>();
		for(int i=0; i<parentlist.size(); i++){
			if(parent_node == parentlist.get(i).getParentNode()){
				for(int n=0; n<parentlist.get(i).getChildNodeLength(); n++)
				child_node.add(parentlist.get(i).getChildNode()[n]);
			}
		}

		return child_node;
	}
}
