package community;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import node_list.NodeListSearch;
import node_list.Nodes;

public class CommunityDependence {

	private ArrayList<Community> communitylist;
	private ArrayList<Nodes> nodelist;
	private Integer community_number;

	public CommunityDependence(ArrayList<Community> communitylist, ArrayList<Nodes> nodelist, Integer community_number){
		this.communitylist = communitylist;
		this.nodelist = nodelist;
		this.community_number = community_number;
	}

	public ArrayList<ArrayList<Integer>> DependCommunity(){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int total_community = community_number;

		CommunitySearch cs = new CommunitySearch(communitylist);
		NodeListSearch ns = new NodeListSearch(nodelist);

		for(int i=1; i<=total_community; i++){
			ArrayList<Integer> community = new ArrayList<Integer>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			//コミュニティiのノードをtempに格納
			temp = cs.NodeNumberSearch(i);
			//親ノードがコミュニティiと違うかどうか判定
			for(int j=0; j<temp.size(); j++){
				ArrayList<Nodes> node = new ArrayList<Nodes>();
				node = ns.ChildSearch(temp.get(j));
				if(node == null){
					continue;
				}else{
					for(int k=0; k<node.size(); k++){
							if(cs.CommunityNumberSearch(node.get(k).getParent_node()) != i){
								//System.out.println("親ノード " + node.get(k).getParent_node() + " 子ノード " + node.get(k).getChild_node() +
								//		" 親ノードコミュ " + cs.CommunityNumberSearch(node.get(k).getParent_node()) + " 子ノードコミュ " + cs.CommunityNumberSearch(node.get(k).getChild_node()));
								community.add(cs.CommunityNumberSearch(node.get(k).getParent_node()));
							}
					}
				}
			}
			Set<Integer> set = new HashSet<>(community);
			ArrayList<Integer> tmp = new ArrayList<>(set);
			result.add(tmp);
		}

		return result;
	}

	public ArrayList<ArrayList<Nodes>> DependNode(){
		ArrayList<ArrayList<Nodes>> result = new ArrayList<ArrayList<Nodes>>();
		int total_community = community_number;

		CommunitySearch cs = new CommunitySearch(communitylist);
		NodeListSearch ns = new NodeListSearch(nodelist);

		for(int i=1; i<=total_community; i++){
			ArrayList<Nodes> community = new ArrayList<Nodes>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			//コミュニティiのノードをtempに格納
			temp = cs.NodeNumberSearch(i);
			//親ノードがコミュニティiと違うかどうか判定
			for(int j=0; j<temp.size(); j++){
				ArrayList<Nodes> node = new ArrayList<Nodes>();
				node = ns.ChildSearch(temp.get(j));
				if(node == null){
					continue;
				}else{
					for(int k=0; k<node.size(); k++){
							if(cs.CommunityNumberSearch(node.get(k).getParent_node()) != i){
								//System.out.println("親ノード " + node.get(k).getParent_node() + " 子ノード " + node.get(k).getChild_node() +
								//		" 親ノードコミュ " + cs.CommunityNumberSearch(node.get(k).getParent_node()) + " 子ノードコミュ " + cs.CommunityNumberSearch(node.get(k).getChild_node()));
								community.add(node.get(k));
							}
					}
				}
			}

			result.add(community);
		}

		return result;
	}
}
