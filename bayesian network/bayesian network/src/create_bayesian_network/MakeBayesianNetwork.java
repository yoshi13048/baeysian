package create_bayesian_network;

import java.util.ArrayList;
import java.util.Collections;

import node_list.NodeCheck;
import node_list.NodeComparator;
import node_list.Nodes;

public class MakeBayesianNetwork {

	private int total_node;
	private int branch;
	private int children;
	private ArrayList<Nodes> nodelist;
	private NodeCheck check;

	//コンストラクタ
	MakeBayesianNetwork(int total_node, int branch, int children){
		this.total_node = total_node;
		this.branch = branch;
		this.children = children;
		check = new NodeCheck(total_node, branch, children);
		nodelist = new ArrayList<Nodes>();
	}

	//根ノードから生えるノードを設定
	public void InitialSetting(){
		//firstは総ノード数の半分より小さい数
		//latterは総ノード数の半分より大きい数
		Nodes first = new Nodes(1, (int)(Math.random()*2) + 2);
		Nodes latter = new Nodes(1, (int)(Math.random()*2) + total_node /2 + 1);

		//根ノードからのノードを追加
		if(check.countNodeBranchCheck(1)){
			if(check.countNodeJunctionCheck(first.getChild_node()))
				nodelist.add(first);
		}
		if(check.countNodeBranchCheck(1)){
			if(check.countNodeJunctionCheck(latter.getChild_node()))
				nodelist.add(latter);
		}
	}

	//ノードを追加
	public void SetNode(){
		for(int x=0; x<400; x++){
			int m = (int)(Math.random() * (total_node - 1) ) + 1;
			int n = (int)(Math.random() * (total_node - 1) ) + 1;

			if(m ==n)
				continue;

			if(m > n){
				int t = m;
				m = n;
				n = t;
			}
			//同じ番号の子ノードがあるか
			int y = check.getNodeBranchCheck(m);
			if(y != branch && check.overlapChildCheck(nodelist, m, n))
				continue;

			if(m <= total_node /2 && n <= total_node /2 && m+5 > n){
				Nodes node = new Nodes(m, n);
				if(check.countNodeBranchCheck(m) && check.countNodeJunctionCheck(n) && (nodelist.contains(node) == false ) )
					nodelist.add(node);
			}else if( m > total_node /2 && n > total_node /2 && m+5 > n){
				Nodes node = new Nodes(m, n);
				if(check.countNodeBranchCheck(m) && check.countNodeJunctionCheck(n) && (nodelist.contains(node) == false ))
					nodelist.add(node);
			}
		}

		//親ノード昇順ソート
		Collections.sort(nodelist, new NodeComparator());
		for(int i=0; i<nodelist.size(); i++)
			System.out.println(nodelist.get(i).getParent_node() + " -> " + nodelist.get(i).getChild_node());
	}

	public int getTotal_node(){
		return this.total_node;
	}

	public int getBranch(){
		return this.branch;
	}

	public int getChildren(){
		return this.children;
	}

	public ArrayList<Nodes> getNodelist(){
		return this.nodelist;
	}

	public NodeCheck getNodeCheck(){
		return this.check;
	}
}
