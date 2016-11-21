package create_bayesian_network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import CPT.CPT;
import node_list.NodeCheck;
import node_list.NodeComparator;
import node_list.Nodes;

public class test {

	public static void main(String[] args){

		int total_node = 30;
		ArrayList<Nodes> nodelist = new ArrayList<Nodes>();
		NodeCheck check = new NodeCheck(30, 2, 3);

		//firstは総ノード数の半分より小さい数
		//latterは総ノード数の半分より大きい数
		Nodes first = new Nodes(1, (int)(Math.random() * (total_node - 1) /2 ) + 2);
		Nodes latter = new Nodes(1, (int)(Math.random() * (total_node - 1) /2 + total_node /2 ));
		if(check.countNodeBranchCheck(1)){
			if(check.countNodeJunctionCheck(first.getChild_node()))
				nodelist.add(first);
		}
		if(check.countNodeBranchCheck(1)){
			if(check.countNodeJunctionCheck(latter.getChild_node()))
			nodelist.add(latter);
		}
		for(int x=0; x<1000; x++){
			int m = (int)(Math.random() * (total_node - 1) ) + 1;
			int n = (int)(Math.random() * (total_node - 1) ) + 1;

			if(m ==n)
				continue;

			if(m > n){
				int t = m;
				m = n;
				n = t;
			}

			if(m <= total_node /2 && n <= total_node /2){
				Nodes node = new Nodes(m, n);
				if(check.countNodeBranchCheck(m) && check.countNodeJunctionCheck(n) && (nodelist.contains(node) == false ) )
					nodelist.add(node);
			}else if( m > total_node /2 && n > total_node /2){
				Nodes node = new Nodes(m, n);
				if(check.countNodeBranchCheck(m) && check.countNodeJunctionCheck(n) && (nodelist.contains(node) == false ))
					nodelist.add(node);
			}
		}
		//親ノード昇順ソート
		Collections.sort(nodelist, new NodeComparator());
		for(int i=0; i<nodelist.size(); i++)
		System.out.println(nodelist.get(i).getParent_node() + " -> " + nodelist.get(i).getChild_node());

		ArrayList<CPT> cptlist = new ArrayList<CPT>();

		//子ノードが同じ親ノードを探索
		//mは子ノード番号
		for(int m=1; m<total_node; m++){
			ArrayList<Integer> list = new ArrayList<Integer>();

			//ノードリストから対象の子ノードに一致するものを探索
			for(int n=0; n<nodelist.size(); n++){
				//親ノード番号をlistに追加
				if(m == nodelist.get(n).getChild_node()){
					list.add(nodelist.get(n).getParent_node());
				}
			}

			//子ノードがmのCPTクラスを生成
			CPT tmp = new CPT(m);
			//子ノードmの親ノードの情報を追加
			tmp.setCPT(list);
			//cptリストに子ノードmのものを追加
			cptlist.add(tmp);
			for(int a=0; a<tmp.getParentNodeLength(); a++){
				System.out.print(" Pnode" + a+1 + " " + tmp.getParentNode()[a]);
			}
			System.out.println(" Cnode " + tmp.getChildNode());
			for(int b=0; b<tmp.getProbabilityLength(); b++){
				System.out.print(" Probability" + b + " " + tmp.getProbability()[b]);
				if(b%2 != 0)
					System.out.println();
			}
			System.out.println("");
		}

	CPT hogeCPT = new CPT(29);
	boolean existFlg = false;
	for(CPT cpt : cptlist){
		if("29".equals(cpt.getChildNode())){
			existFlg = true;
		}
	}

	System.out.println("child node 29があるかどうか" + existFlg);
	System.out.println("child node 29があるかどうか " + cptlist.contains(hogeCPT));

	//ノードリストをcsvに出力
	try{
		FileWriter fw = new FileWriter("nodelist.csv", false);
		PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

		for(int i=0; i<nodelist.size(); i++){
			pw.print(nodelist.get(i).getParent_node());
			pw.print(",");
			pw.print(nodelist.get(i).getChild_node());
			pw.print(",");
			pw.println();
		}

		pw.close();
	} catch(IOException ex){
		ex.printStackTrace();
	}


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
	/*
	for(int i=0; i<nodelist.getListSize(); i++){
		for(int x=0; x<2; x++){
			System.out.println( (nodelist.getNodeList(i)).getParent_node() + " -> "
					+ (nodelist.getNodeList(i)).getChild_node(x) );
		}
	}
	 */
	}
}
