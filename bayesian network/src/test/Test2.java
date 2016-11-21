package test;

import java.util.ArrayList;

import child_list.ChildList;
import child_list.MakeChildList;
import community.Community;
import community.CommunityAllDisplay;
import community.CommunityReader;
import community.CommunitySort;
import node_list.NodeExist;
import node_list.NodeListReader;
import node_list.Nodes;
import sampling.SamplingSchedule;

public class Test2 {

	public static void main(String[] args){

		NodeListReader nlr = new NodeListReader("community_node10000.csv");
		ArrayList<Nodes> nodelist = nlr.read();

		NodeListReader nlr1 = new NodeListReader("first_community_node10000.csv");
		ArrayList<Nodes> first_nodelist = nlr1.read();
		NodeListReader nlr2 = new NodeListReader("last_community_node10000.csv");
		ArrayList<Nodes> last_nodelist = nlr2.read();

		NodeExist ne = new NodeExist(nodelist);
		ArrayList<Integer> routelist = ne.Exist();
		CommunityReader cr = new CommunityReader("community_node10000.txt");
		ArrayList<Community>  communitylist = cr.ReadCommunity(routelist);

		MakeChildList mcl = new MakeChildList(routelist.size(), nodelist);
		ArrayList<ChildList> childlist = mcl.getChildList();

		NodeExist ne1 = new NodeExist(first_nodelist);
		ArrayList<Integer> first_routelist = ne1.Exist();
		CommunityReader cr1 = new CommunityReader("first_community_node10000.txt");
		ArrayList<Community> first_communitylist = cr1.ReadCommunity(first_routelist);
		NodeExist ne2 = new NodeExist(last_nodelist);
		ArrayList<Integer> last_routelist = ne2.Exist();
		CommunityReader cr2 = new CommunityReader("last_community_node10000.txt");
		ArrayList<Community> last_communitylist = cr2.ReadCommunity(last_routelist);
		for(int i=0; i<last_communitylist.size(); i++){
			last_communitylist.get(i).setCommnuity(last_communitylist.get(i).getCommnuity() + 60);
		}

		ArrayList<Community> all_communitylist = new ArrayList<Community>();
		all_communitylist.addAll(first_communitylist);
		all_communitylist.addAll(last_communitylist);

		/*int community_number = communitylist.get(0).getCommnuity();
		for(int i=0; i<communitylist.size(); i++){
			if(community_number < communitylist.get(i).getCommnuity())
				community_number = communitylist.get(i).getCommnuity();
		}
		System.out.println("コミュニティ数" + community_number);*/

		int all_community_number = all_communitylist.get(0).getCommnuity();
		for(int i=0; i<all_communitylist.size(); i++){
			if(all_community_number < all_communitylist.get(i).getCommnuity())
				all_community_number = all_communitylist.get(i).getCommnuity();
		}
		System.out.println("コミュニティ数" + all_community_number);

		CommunitySort cs = new CommunitySort(all_communitylist, all_community_number);
		ArrayList<Community> sortlist = cs.NumberSort();
		CommunityAllDisplay calld = new CommunityAllDisplay(sortlist);
		calld.CommuunityPrint();

		SamplingSchedule ss = new SamplingSchedule(childlist, sortlist, all_community_number);
		ss.DependentCheck();
		ss.Print();

		/*CommunityPrintWriter cpw = new CommunityPrintWriter("communitylist10000.txt");
		cpw.print(sortlist);*/

		/*
		CommunitySearch cse = new CommunitySearch(sortlist);
		int index = cse.NodeIndexSearch(71);
		sortlist.get(index).setCommnuity(1);
		index = cse.NodeIndexSearch(69);
		sortlist.get(index).setCommnuity(1);
		*/

		/*CommunityDependence cd = new CommunityDependence(sortlist, nodelist, all_community_number);
		ArrayList<ArrayList<Integer>> dependence = cd.DependCommunity();
		ArrayList<ArrayList<Nodes>> dependenceNode = cd.DependNode();
		for(int i=0; i<dependence.size(); i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp = dependence.get(i);

			ArrayList<Nodes> node = new ArrayList<Nodes>();
			node = dependenceNode.get(i);
			System.out.print("コミュニティ " + (i+1) + " ");
			for(int j=0; j<temp.size(); j++){
				System.out.print(" " + temp.get(j) + " ");
			}
			System.out.print(" 依存コミュティ数 " + temp.size() + " ");
			for(int k=0; k<node.size(); k++){
				System.out.print(" " + node.get(k).getParent_node() + " -> " + node.get(k).getChild_node() + " ");
			}
			System.out.print(" 依存数 " + node.size() + " ");
			System.out.println("");
		}*/
	}
}
