package sampling;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import child_list.ChildList;
import community.Community;
import community.CommunitySearch;
import community.Dependence;
import community.MakeDependenceList;
import community.SearchDependenceList;
import node_list.Nodes;

public class SamplingSchedule {

	private ArrayList<ChildList> childlist;
	private ArrayList<Community> communitylist;
	private ArrayList<Dependence> dependencelist;
	//そのコミュニティがsampling可能かどうか判定するリスト
	private ArrayList<Boolean> checklist;

	public SamplingSchedule(ArrayList<ChildList> childlist,  ArrayList<Community> communitylist, Integer total_community_num){
		this.childlist = childlist;
		this.communitylist = communitylist;
		MakeDependenceList mdl = new MakeDependenceList(total_community_num);
		this.dependencelist = mdl.Set();
	}

	public void DependentCheck(){
		CommunitySearch cs = new CommunitySearch(communitylist);
		SearchDependenceList sdl = new SearchDependenceList(dependencelist);

		for(int i=0; i<childlist.size(); i++){
			int nodeB = childlist.get(i).getChildNode();
			int communityB = communitylist.get(cs.NodeIndexSearch(nodeB)).getCommnuity();
			int[] temp = childlist.get(i).getParentNode();
			for(int j=0; j<temp.length; j++){
				int nodeA = temp[j];
				int communityA = communitylist.get(cs.NodeIndexSearch(nodeA)).getCommnuity();
				if(communityA != communityB){
					Nodes node = new Nodes(nodeA, nodeB);
					ArrayList<Integer> temp_community = dependencelist.get(sdl.CommunityIndexSearch(communitylist.get(cs.NodeIndexSearch(nodeB)).getCommnuity())).getDependentCommunity();

					if(temp_community.contains(communityA) != true)
						dependencelist.get(sdl.CommunityIndexSearch(communityB)).addDependentCommunity(communityA);
					dependencelist.get(sdl.CommunityIndexSearch(communityB)).addDependentNode(node);
				}
			}
		}

		for(int i=0; i<dependencelist.size(); i++){
			checklist.add(false);
		}

	}

	public void Print(){
		for(int i=0; i<dependencelist.size(); i++){
			System.out.println("--コミュニティ " + dependencelist.get(i).getCommunityNum() + "--");
			System.out.print("依存コミュニティ");
			for(int k=0; k<dependencelist.get(i).getDependentCommunity().size(); k++){
				System.out.print(" " + dependencelist.get(i).getDependentCommunity().get(k) + " ");
			}
			System.out.println();
			for(int j=0; j<dependencelist.get(i).getDependentNode().size(); j++){
				System.out.print(" " + dependencelist.get(i).getDependentNode().get(j).getParent_node() + " -> " + dependencelist.get(i).getDependentNode().get(j).getChild_node() + " ");
			}
			System.out.println();
		}
	}

	//
	public void setCheck(int community_num){
		ArrayList<Integer> temp = dependencelist.get(community_num-1).getDependentCommunity();
		for(int i=0; i<temp.size(); i++){
			checklist.set(temp.get(i), true);
		}
	}

	public boolean CommunityCheck(int community_num){
		boolean flag = false;
		List<ArrayList<Integer>> temp = dependencelist.stream().filter(d -> d.getCommunityNum() == community_num).map(d -> d.getDependentCommunity()).collect(Collectors.toList());
		return flag;
	}

	public ArrayList<Dependence> getDependenceList(){
		return this.dependencelist;
	}
}
