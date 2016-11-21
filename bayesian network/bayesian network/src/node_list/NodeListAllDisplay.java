package node_list;

import java.util.ArrayList;

public class NodeListAllDisplay {

	private ArrayList<Nodes> nodelist;

	public NodeListAllDisplay(ArrayList<Nodes> nodelist){
		this.nodelist = nodelist;
	}

	public void display(){

		System.out.println("----nodelist----");
		for(int i=0; i<nodelist.size(); i++){
			System.out.println("parent node " + nodelist.get(i).getParent_node() + " child node " + nodelist.get(i).getChild_node());;
		}
		System.out.println("----nodelist----");
	}
}
