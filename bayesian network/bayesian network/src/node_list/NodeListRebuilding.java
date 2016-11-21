package node_list;

import java.util.ArrayList;

public class NodeListRebuilding {

	private ArrayList<Integer> existnodelist;
	private ArrayList<Nodes> nodelist;

	public NodeListRebuilding(ArrayList<Integer> existnodelist, ArrayList<Nodes> nodelist){
		this.existnodelist = existnodelist;
		this.nodelist = nodelist;
	}
	public ArrayList<Nodes> Create(){
		ArrayList<Nodes> result = new ArrayList<Nodes>();
		NodeListSearch nls = new NodeListSearch(nodelist);

		for(int i=0; i<existnodelist.size(); i++){
			ArrayList<Nodes> temp = nls.ParentSearch(existnodelist.get(i));
			for(int j=0; j<temp.size(); j++){
				for(int k=0; k<existnodelist.size(); k++){
					if(temp.get(j).getChild_node() == existnodelist.get(k))
						result.add(temp.get(j));
				}
			}
		}

		return result;
	}
}
