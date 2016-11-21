package CPT;

import java.util.ArrayList;

public class SearchCPT {

	private ArrayList<CPT> cptlist;
	public SearchCPT(ArrayList<CPT> cptlist){
		this.cptlist = cptlist;
	}

	//親ノードを返す
	public ArrayList<Integer> ParentNode(int child_node){
		ArrayList<Integer> parent_node = new ArrayList<Integer>();

		for(int i=0; i<cptlist.size(); i++){
			if(child_node == cptlist.get(i).getChildNode()){
				for(int n=0; n<cptlist.get(i).getParentNodeLength(); n++)
				parent_node.add(cptlist.get(i).getParentNode()[n]);
			}
		}

		//System.out.println("child_node " + child_node);
		//System.out.println("parent_node " + parent_node);

		return parent_node;
	}

	public double[] Probability(int child_node){
		for(int i=0; i<cptlist.size(); i++){
			if(child_node == cptlist.get(i).getChildNode())
				return cptlist.get(i).getProbability();
		}

		return null;
	}
}
