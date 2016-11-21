package create_bayesian_network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import CPT.CPT;
import CPT.MakeCPT;
import child_list.ChildList;
import child_list.ChildListAllDisplay;
import child_list.MakeChildList;
import node_list.NodeListPrintWriter;
import parent_list.MakeParentList;
import parent_list.ParentList;
import parent_list.ParentListAllDisplay;

public class Test2 {

	public static void main(String[] args) throws IOException{
		MakeBayesianNetwork mbn = new MakeBayesianNetwork(30, 2, 3);
		mbn.InitialSetting();
		mbn.SetNode();

		MakeCPT mcpt = new MakeCPT(mbn.getTotal_node(), mbn.getNodelist());

		ArrayList<CPT> cptlist = mcpt.getCPTList();

		MakeParentList mp = new MakeParentList(30, mbn.getNodelist());
		MakeChildList mc = new MakeChildList(30, mbn.getNodelist());

		ArrayList<ParentList> pl = mp.getParentList();
		ArrayList<ChildList> cl = mc.getChildList();

		ParentListAllDisplay plad = new ParentListAllDisplay(pl);
		ChildListAllDisplay clad = new ChildListAllDisplay(cl);
		plad.display();
		clad.display();

		/*
		System.out.println("～～～～ParentList～～～～～");
		for(int i=0; i<pl.size(); i++){
			System.out.println("Parent Node " + pl.get(i).getParentNode());
			System.out.print("ChildNode");
			for(int m=0; m<pl.get(i).getChildNodeLength(); m++)
			System.out.print(" " + pl.get(i).getChildNode()[m]);
			System.out.println("");
		}


		System.out.println("～～～～ChildList～～～～～");
		for(int i=0; i<cl.size(); i++){
			System.out.print("Parent Node ");
			for(int m=0; m<cl.get(i).getParentNodeLength(); m++)
			System.out.print(" " + cl.get(i).getParentNode()[m]);
			System.out.println("");
			System.out.println("Child Node" + cl.get(i).getChildNode());
		}
		*/


		SearchRoute sr = new SearchRoute(pl, cl, 30, 15, 28);
		sr.dfs();

		NodeListPrintWriter nlp = new NodeListPrintWriter("nodelist");
		nlp.print(mbn.getNodelist());

		//CPTをcsvに出力
		try{
			FileWriter fw = new FileWriter("CPT.csv", false);
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

			for(int i=0; i<cptlist.size(); i++){
				for(int a=0; a<cptlist.get(i).getParentNodeLength(); a++){
					pw.print(cptlist.get(i).getParentNode()[a]);
					pw.print(",");
				}
				pw.println();

				pw.print(cptlist.get(i).getChildNode());
				pw.println(",");

				for(int b=0; b<cptlist.get(i).getProbabilityLength(); b++){
					pw.print(cptlist.get(i).getProbability()[b]);
					pw.print(",");
				}
				pw.println();

			}
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
