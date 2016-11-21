package community;

import java.util.ArrayList;

import node_list.Nodes;

public class Dependence {

	private int community_num;
	private ArrayList<Integer> dependent_communitylist;
	private ArrayList<Nodes> dependent_nodelist;

	public Dependence(int community_num){
		this.community_num = community_num;
		this.dependent_communitylist = new ArrayList<Integer>();
		this.dependent_nodelist = new ArrayList<Nodes>();
		}

	public int getCommunityNum(){
		return this.community_num;
	}

	public ArrayList<Integer> getDependentCommunity(){
		return this.dependent_communitylist;
	}

	public ArrayList<Nodes> getDependentNode(){
		return this.dependent_nodelist;
	}



	public void addDependentCommunity(Integer community_num){
		this.dependent_communitylist.add(community_num);
	}

	public void addDependentNode(Nodes node){
		this.dependent_nodelist.add(node);
	}



}
