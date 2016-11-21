package test;

import java.util.ArrayList;

import CPT.CPT;
import CPT.CPTAllDisplay;
import CPT.CPTReader;
import child_list.ChildList;
import child_list.ChildListAllDisplay;
import child_list.MakeChildList;
import community.AnnealingOptimize;
import community.Community;
import community.CommunityAllDisplay;
import community.CommunitySetting;
import node_list.NodeListAllDisplay;
import node_list.NodeListReader;
import node_list.NodeListSearch;
import node_list.Nodes;
import parent_list.MakeParentList;
import parent_list.ParentList;
import parent_list.ParentListAllDisplay;

public class CommunityTest {

	public static void main(String[] args){

		int total_node_num = 5000;

		//csvから読み込み
		NodeListReader nlr = new NodeListReader("community_node5000.csv");
		ArrayList<Nodes> nodelist = nlr.read();

		//csvから読み込み
		CPTReader cptr = new CPTReader("community_CPT5000.csv");
		ArrayList<CPT> cptlist = cptr.read();

		//親子リスト作成
		MakeParentList mpl = new MakeParentList(total_node_num, nodelist);
		ArrayList<ParentList> pl = mpl.getParentList();

		MakeChildList mcl = new MakeChildList(total_node_num, nodelist);
		ArrayList<ChildList> cl = mcl.getChildList();

		//親子リスト表示
		ParentListAllDisplay plad = new ParentListAllDisplay(pl);
		plad.display();

		ChildListAllDisplay clad = new ChildListAllDisplay(cl);
		clad.display();

		//CPT表示
		CPTAllDisplay cptad = new CPTAllDisplay(cptlist);
		cptad.display();

		/*
		//経路探索

		//Evidence target
		int evidence_node = 9;
		int target_node = 25;

		SearchRoute sr = new SearchRoute(pl, cl, total_node_num, evidence_node, target_node);
		ArrayList<Integer> routelist = sr.dfs();

		//経路探索後のノードリスト
		int new_total_node_num = routelist.size();
		NodeListRebuilding nlrd = new NodeListRebuilding(routelist, nodelist);
		ArrayList<Nodes> new_nodelist = nlrd.Create();
		NodeListAllDisplay nlad = new NodeListAllDisplay(new_nodelist);
		nlad.display();

		//経路探索後のCPT
		CPTRebuilding cptrd = new CPTRebuilding(cptlist, routelist);
		ArrayList<CPT> new_cptlist = cptrd.Create();
		CPTAllDisplay ncptad = new CPTAllDisplay(new_cptlist);
		ncptad.display();
		*/


		//経路探索なし
		ArrayList<Integer> routelist = new ArrayList<Integer>();
		for(int i=1; i<total_node_num; i++){
			routelist.add(i);
		}

		ArrayList<Integer> first_half_list = new ArrayList<Integer>();
		ArrayList<Integer> last_half_list = new ArrayList<Integer>();
		for(int i=0; i<routelist.size(); i++){
			if(routelist.get(i) <= total_node_num/2)
				first_half_list.add(routelist.get(i));
			else
				last_half_list.add(routelist.get(i));
		}

		NodeListSearch nls = new NodeListSearch(nodelist);
		ArrayList<Nodes> first_list = new ArrayList<Nodes>();
		for(int i=0; i<first_half_list.size(); i++){
			ArrayList<Integer> index = nls.ParentIndexSearch(first_half_list.get(i));
			for(int j=0; j<index.size(); j++){
				first_list.add(nodelist.get(index.get(j)));
			}
		}

		ArrayList<Nodes> last_list = new ArrayList<Nodes>();
		for(int i=0; i<last_half_list.size(); i++){
			ArrayList<Integer> index = nls.ParentIndexSearch(last_half_list.get(i));
			for(int j=0; j<index.size(); j++){
				last_list.add(nodelist.get(index.get(j)));
			}
		}

		NodeListAllDisplay nlad1 = new NodeListAllDisplay(first_list);
		nlad1.display();
		NodeListAllDisplay nlad2 = new NodeListAllDisplay(last_list);
		nlad2.display();
		//コミュニティ検出

		//初期設定
		CommunitySetting cs = new CommunitySetting(routelist);
		CommunitySetting cs1 = new CommunitySetting(first_half_list);
		CommunitySetting cs2 = new CommunitySetting(last_half_list);
		ArrayList<Community> all_communitylist = cs.Setting(4);
		ArrayList<Community> communitylist1 = cs1.InitialSetting();
		ArrayList<Community> communitylist2 = cs2.InitialSetting();

		CommunityAllDisplay calldd = new CommunityAllDisplay(all_communitylist);
		calldd.CommuunityPrint();

		//焼きなまし法


		//設定
		double T = 1000;
		double cool = 0.99;
		Integer community_from_num1= 1;
		Integer community_to_num1 = 3;
		Integer community_from_num2 = 4;
		Integer community_to_num2 = 3;
		Integer community_total_num = 4;

		//計算
		AnnealingOptimize ao = new AnnealingOptimize(T, cool, 1, 4, routelist, nodelist, all_communitylist);
		ao.action();
		/*
		AnnealingOptimize ao1 = new AnnealingOptimize(T, cool, community_from_num1, community_to_num1, first_half_list, first_list, communitylist1);
		ao1.action();
		AnnealingOptimize ao2 = new AnnealingOptimize(T, cool, community_from_num2, community_to_num2, last_half_list, last_list, communitylist2);
		ao2.action();
		*/
		//ao.Sort(community_total_num);

		/*
		BigDecimal T = new BigDecimal(1000);
		BigDecimal cool = new BigDecimal(0.999);
		BigDecimalAnnealingOptimize bdao = new BigDecimalAnnealingOptimize(T, cool, community_total_num, routelist, nodelist, communitylist);
		bdao.action();
		*/
		//ArrayList<Community> result = new ArrayList<Community>(communitylist);
		//CommunitySort coms = new CommunitySort(result);
		//coms.Sort(community_total_num);

		/*
		ArrayList<Community> communitylist = new ArrayList<Community>();
		communitylist.addAll(communitylist1);
		communitylist.addAll(communitylist2);
		*/
		//表示
		CommunityAllDisplay calld = new CommunityAllDisplay(all_communitylist);
		calld.CommuunityPrint();

		//CommunityAllDisplay calld2 = new CommunityAllDisplay(result);
		//calld2.CommuunityPrint();
	}
}
