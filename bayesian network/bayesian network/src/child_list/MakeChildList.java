package child_list;

import java.util.ArrayList;

import node_list.Nodes;

public class MakeChildList {
	private ArrayList<ChildList> childlist;

	public MakeChildList(int total_node, ArrayList<Nodes> nodelist){
		childlist = new ArrayList<ChildList>();
		for(int m=1; m<=total_node; m++){
			ArrayList<Integer> list = new ArrayList<Integer>();

			for(int n=0; n<nodelist.size(); n++){
				if(m == nodelist.get(n).getChild_node()){
					list.add(nodelist.get(n).getParent_node());
				}
			}
			ChildList tmp = new ChildList(m);
			tmp.setChildList(list);
			childlist.add(tmp);
		}
	}

	public ArrayList<ChildList> getChildList(){
		return childlist;
	}
}
