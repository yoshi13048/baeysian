package parent_list;

import java.util.ArrayList;

import node_list.Nodes;


public class MakeParentList {

	private ArrayList<ParentList> parentlist;

	public MakeParentList(int total_node, ArrayList<Nodes> nodelist){
		parentlist = new ArrayList<ParentList>();
		for(int m=1; m<=total_node; m++){
			ArrayList<Integer> list = new ArrayList<Integer>();

			for(int n=0; n<nodelist.size(); n++){
				if(m == nodelist.get(n).getParent_node()){
					list.add(nodelist.get(n).getChild_node());
				}
			}
			ParentList tmp = new ParentList(m);
			tmp.setParentList(list);
			parentlist.add(tmp);
		}
	}

	public ArrayList<ParentList> getParentList(){
		return parentlist;
	}
}
