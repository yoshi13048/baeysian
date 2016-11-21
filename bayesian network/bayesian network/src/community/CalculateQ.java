package community;

import java.util.ArrayList;

import node_list.NodeListSearch;
import node_list.Nodes;

public class CalculateQ {

	private ArrayList<Nodes> nodelist;
	private ArrayList<Community> communitylist;

	public CalculateQ(ArrayList<Nodes> nodelist, ArrayList<Community> communitylist){
		this.nodelist = nodelist;
		this.communitylist = communitylist;
	}

	//Q値の計算
	public double Calculate(){
		double temp = 0;
		double result = 0;

		NodeListSearch nls = new NodeListSearch(nodelist);
		ArrayList<Integer> existnodelist = nls.ExistNode();
		SameCommunityDecision scd = new SameCommunityDecision(communitylist);
		double edge = nodelist.size();


		for(int i=0; i<existnodelist.size(); i++){
			for(int j = 0; j<existnodelist.size(); j++){
				if(i == j)
					continue;
				int node1 = existnodelist.get(i);
				int node2 = existnodelist.get(j);

				double A = nls.Adjacent(node1, node2);
				double k1 = nls.degree(node1);
				double k2 = nls.degree(node2);
				//System.out.println("(" + A + " - (" + k1 + "*" + k2 + ")" + "/(2.0*" + edge + "))*" + scd.judge(node1,node2));
				temp = (A - (k1*k2)/(2.0*edge)) * scd.judge(node1, node2);
				result += temp;
				//System.out.println("temp " + temp + " result " + result);
			}
		}
		result = result / (2.0*edge);
		return result;
	}
}
