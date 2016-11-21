package test;

import java.util.ArrayList;
import java.util.Map;

import CPT.CPT;
import CPT.CPTAllDisplay;
import CPT.CPTReader;
import community.Community;
import community.CommunityReader;
import community.MakeCommunityCPT;
import community.MakeCommunityNodeList;
import node_list.NodeExist;
import node_list.NodeListReader;
import node_list.Nodes;

public class MainTest {

	public static void main(String[] args){
		NodeListReader nlr = new NodeListReader("community_node10000.csv");
		ArrayList<Nodes> nodelist = nlr.read();

		CPTReader cptr = new CPTReader("community_CPT10000.csv");
		ArrayList<CPT> cptlist = cptr.read();

		NodeExist ne = new NodeExist(nodelist);
		ArrayList<Integer> existlist = ne.Exist();
		int total_node_num = existlist.size();

		CommunityReader cr = new CommunityReader("communitylist10000.txt");
		ArrayList<Community> communitylist = cr.ReadCommunity(existlist);

		MakeCommunityNodeList mcnl = new MakeCommunityNodeList(nodelist, communitylist);
		Map<Integer, ArrayList<Integer>> communitynodelist = mcnl.getCommunityNodeList();
		for(int i=0; i<communitynodelist.get(5).size(); i++){
			System.out.println(" " + communitynodelist.get(5).get(i) + " ");
		}

		MakeCommunityCPT mccpt = new MakeCommunityCPT(cptlist, communitynodelist, communitylist);
		Map<Integer, ArrayList<CPT>> communitycptlist = mccpt.getCommunityCPTList();

		CPTAllDisplay cptad = new CPTAllDisplay(communitycptlist.get(5));
		cptad.display();


	}
}
