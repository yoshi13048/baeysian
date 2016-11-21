package node_list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NodeExist {

	private ArrayList<Nodes> nodelist;

	public NodeExist(ArrayList<Nodes> nodelist){
		this.nodelist = nodelist;
	}
	public ArrayList<Integer> Exist(){
		ArrayList<Integer> existnodelist = new ArrayList<Integer>();

		for(int i=0; i<nodelist.size(); i++){
			existnodelist.add(nodelist.get(i).getParent_node());
			existnodelist.add(nodelist.get(i).getChild_node());
		}

		Set<Integer> set = new HashSet<>(existnodelist);
		ArrayList<Integer> exist = new ArrayList<>(set);
		return exist;
	}

}
