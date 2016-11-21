package node_list;

import java.util.Comparator;

public class NodeComparator implements Comparator<Nodes>{

	public int compare(Nodes n1, Nodes n2){
		if(n1.getParent_node() == n2.getParent_node()){
			return n1.getChild_node() < n2.getChild_node() ? -1 : 1;
		}
		else{
			return n1.getParent_node() < n2.getParent_node() ? -1 : 1;
		}
	}
}
