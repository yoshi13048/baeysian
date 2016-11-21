package test;

import java.util.ArrayList;

import child_list.ChildList;
import child_list.ChildListAllDisplay;
import child_list.MakeChildList;
import node_list.NodeListReader;
import node_list.Nodes;

public class FromNodeListCreateCPT {

	public static void main(String[] args){
		int total_node_num = 10000;

		NodeListReader nlr = new NodeListReader("ba10000.txt");
		ArrayList<Nodes> nodelist = nlr.read();



		/*ArrayList<Nodes> first_nodelist = new ArrayList<Nodes>();
		ArrayList<Nodes> last_nodelist = new ArrayList<Nodes>();

		for(int i=0; i<nodelist.size(); i++){
			if(nodelist.get(i).getChild_node() <= 5000 )
				first_nodelist.add(nodelist.get(i));
			else
				last_nodelist.add(nodelist.get(i));
		}

		NodeListPrintWriter nlp = new NodeListPrintWriter("first_community_node10000.csv");
		nlp.print(first_nodelist);
		NodeExist ne = new NodeExist(first_nodelist);
		ArrayList<Integer> routelist = ne.Exist();
		CsvCombartGml ccg = new CsvCombartGml("fist_community_node10000.gml");
		ccg.print(first_nodelist, routelist.size());

		NodeListPrintWriter nlp2 = new NodeListPrintWriter("last_community_node10000.csv");
		nlp2.print(last_nodelist);
		NodeExist ne2 = new NodeExist(last_nodelist);
		ArrayList<Integer> routelist2 = ne2.Exist();
		CsvCombartGml ccg2 = new CsvCombartGml("last_community_node10000.gml");
		ccg2.print(last_nodelist, routelist2.size());*/

		//MakeCPT mcpt = new MakeCPT(total_node_num, nodelist);
		//ArrayList<CPT> cptlist = mcpt.getCPTList();

		//MakeParentList mpl = new MakeParentList(total_node_num, nodelist);
		//ArrayList<ParentList> pl = mpl.getParentList();

		MakeChildList mcl = new MakeChildList(total_node_num, nodelist);
		ArrayList<ChildList> cl = mcl.getChildList();

		//ParentListAllDisplay plad = new ParentListAllDisplay(pl);
		//plad.display();

		ChildListAllDisplay clad = new ChildListAllDisplay(cl);
		clad.display();

		//CPTAllDisplay cptad = new CPTAllDisplay(cptlist);
		//cptad.display();
	}
}
