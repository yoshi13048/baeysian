package community;

import java.math.BigDecimal;
import java.util.ArrayList;

import node_list.NodeExist;
import node_list.NodeListSearch;
import node_list.Nodes;

public class BigDecimalCalculateQ {
	private ArrayList<Nodes> nodelist;
	private ArrayList<Community> communitylist;

	public BigDecimalCalculateQ(ArrayList<Nodes> nodelist, ArrayList<Community> communitylist){
		this.nodelist = nodelist;
		this.communitylist = communitylist;
	}

	//Q値の計算
	public BigDecimal Calculate(){
		BigDecimal temp = new BigDecimal("0.0");
		BigDecimal result = new BigDecimal("0.0");

		NodeExist ne = new NodeExist(nodelist);
		ArrayList<Integer> existnodelist = ne.Exist();
		SameCommunityDecision scd = new SameCommunityDecision(communitylist);
		BigDecimal edge = new BigDecimal(nodelist.size()*2);

		NodeListSearch nls = new NodeListSearch(nodelist);

		for(int i=0; i<existnodelist.size(); i++){
			for(int j = 0; j<existnodelist.size(); j++){
				if(i == j)
					continue;
				int node1 = existnodelist.get(i);
				int node2 = existnodelist.get(j);

				BigDecimal A = new BigDecimal(nls.Adjacent(node1, node2));
				BigDecimal k1 = new BigDecimal(nls.degree(node1));
				BigDecimal k2 = new BigDecimal(nls.degree(node2));
				BigDecimal cal = new BigDecimal(scd.judge(node1, node2));
				//System.out.println("(" + A + " - (" + k1 + "*" + k2 + ")" + "/(2.0*" + edge + "))*" + scd.judge(node1,node2));
				BigDecimal a = k1.multiply(k2);
				BigDecimal b = a.divide(edge, 5, BigDecimal.ROUND_HALF_UP);
				BigDecimal x = A.subtract(b);
				temp = x.multiply(cal);
				result = result.add(temp);
				//System.out.println("temp " + temp + " result " + result);
			}
		}
		result = result.divide(edge, 5, BigDecimal.ROUND_HALF_UP);
		return result;
	}
}
