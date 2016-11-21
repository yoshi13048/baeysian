package create_bayesian_network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import CPT.CPT;
import CPT.CPTAllDisplay;
import CPT.SearchCPT;
import CPT.SearchProbability;
import child_list.ChildList;
import child_list.ChildListAllDisplay;
import child_list.MakeChildList;
import node_list.NodeListAllDisplay;
import node_list.Nodes;
import parent_list.MakeParentList;
import parent_list.ParentList;
import parent_list.ParentListAllDisplay;
import parent_list.SearchParentList;
import sampling.CountSampling;
import sampling.Sampling;

public class TestCPT {

	public static void main(String[] args){
		ArrayList<Nodes> nodelist = new ArrayList<Nodes>();
		ArrayList<CPT> cpt = new ArrayList<CPT>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		CPT tmp = new CPT();

		Nodes node1 = new Nodes(1,2);
		nodelist.add(node1);

		Nodes node2 = new Nodes(1,8);
		nodelist.add(node2);

		Nodes node3 = new Nodes(2,3);
		nodelist.add(node3);

		Nodes node4 = new Nodes(2,4);
		nodelist.add(node4);

		Nodes node5 = new Nodes(3,4);
		nodelist.add(node5);

		Nodes node6 = new Nodes(3,6);
		nodelist.add(node6);

		Nodes node7 = new Nodes(5,6);
		nodelist.add(node7);

		Nodes node8 = new Nodes(7,8);
		nodelist.add(node8);

		Nodes node9 = new Nodes(8, 9);
		nodelist.add(node9);

		Nodes node10 = new Nodes(9, 10);
		nodelist.add(node10);

		Nodes node11 = new Nodes(9,12);
		nodelist.add(node11);

		Nodes node12 = new Nodes(11, 12);
		nodelist.add(node12);

		MakeParentList mp = new MakeParentList(12, nodelist);
		MakeChildList mc = new MakeChildList(12, nodelist);

		ArrayList<ParentList> pl = mp.getParentList();
		ArrayList<ChildList> cl = mc.getChildList();

		tmp = new CPT(1);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(2);
		list.add(1);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(3);
		list.clear();
		list.add(2);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(4);
		list.clear();
		list.add(2);
		list.add(3);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(5);
		list.clear();
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(6);
		list.clear();
		list.add(3);
		list.add(5);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(7);
		list.clear();
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(8);
		list.clear();
		list.add(1);
		list.add(7);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(9);
		list.clear();
		list.add(8);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(10);
		list.clear();
		list.add(9);
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(11);
		list.clear();
		tmp.setCPT(list);
		cpt.add(tmp);

		tmp = new CPT(12);
		list.clear();
		list.add(9);
		list.add(11);
		tmp.setCPT(list);
		cpt.add(tmp);


		SearchCPT scpt = new SearchCPT(cpt);
		scpt.ParentNode(8);
		//CPTをcsvに出力
		try{
			FileWriter fw = new FileWriter("CPT2.csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			for(int i=0; i<cpt.size(); i++){
				for(int a=0; a<cpt.get(i).getParentNodeLength(); a++){
					pw.print(cpt.get(i).getParentNode()[a]);
					pw.print(",");
				}
				pw.println();

				pw.print(cpt.get(i).getChildNode());
				pw.println(",");

				for(int b=0; b<cpt.get(i).getProbabilityLength(); b++){
					pw.print(cpt.get(i).getProbability()[b]);
					pw.print(",");
				}
				pw.println();

			}
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

		CPTAllDisplay CPTad = new CPTAllDisplay(cpt);
		CPTad.display();

		SearchProbability sp = new SearchProbability(scpt.Probability(4));
		int[] appearance = new int[2];
		appearance[0] = 0;
		appearance[1] = 0;
		System.out.println("2が出現しない かつ 3が出現しない時の4が出現しない確率は" + sp.TargetProbability(appearance));

		ArrayList<Integer> routelist = new ArrayList<Integer>();
		routelist.add(1);
		routelist.add(2);
		routelist.add(3);
		routelist.add(4);
		Sampling s = new Sampling(cpt, routelist);
		s.createSample(1000);
		//SamplingAllDisplay sad = new SamplingAllDisplay(s.getSamplingList());
		//sad.display();

		NodeListAllDisplay nad = new NodeListAllDisplay(nodelist);
		nad.display();
		ChildListAllDisplay cad = new ChildListAllDisplay(cl);
		cad.display();
		ParentListAllDisplay pad = new ParentListAllDisplay(pl);
		pad.display();

		SearchParentList searchpl = new SearchParentList(pl);
		System.out.println("5の子ノード" + searchpl.ChildNode(5));

		CountSampling cs = new CountSampling(s.getSamplingList());
		System.out.println("1の出現する確率は" + cs.SingleProbability(1, 1));
		System.out.println("2が出現して3が出現する確率は" + cs.DoubleProbability(2, 1, 3, 1));

		SearchRoute sr = new SearchRoute(pl, cl, 12, 5, 12);
		sr.dfs();
		SearchRoute sr2 = new SearchRoute(pl, cl, 12, 8, 11);
		sr2.dfs();
	}


}
