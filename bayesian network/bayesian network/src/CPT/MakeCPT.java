package CPT;

import java.util.ArrayList;

import node_list.Nodes;

public class MakeCPT {

	private ArrayList<CPT> cptlist;

	public MakeCPT(int total_node, ArrayList<Nodes> nodelist){
		cptlist = new ArrayList<CPT>();

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
	}

	public ArrayList<CPT> getCPTList(){
		return cptlist;
	}
}
