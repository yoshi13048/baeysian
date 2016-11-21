package node_list;

import java.util.ArrayList;

/**
 * @author al13048
 * ノードリストからノードを検索するクラス
 */
public class NodeListSearch {

	private ArrayList<Nodes> nodelist;

	public NodeListSearch(ArrayList<Nodes> nodelist){
		this.nodelist = nodelist;
	}

	//対象となる親ノードが持っている子ノードを見つける
	/**
	 * @param parent_node 親ノードを指定
	 * 指定された親ノード番号のNodesクラスを検索するメソッド
	 * @return 指定された親ノード番号のNodesクラスを返す
	 */
	public ArrayList<Nodes> ParentSearch(int parent_node){
		ArrayList<Nodes> result = new ArrayList<Nodes>();

		for(int i=0; i<nodelist.size(); i++){
			if(nodelist.get(i).getParent_node() == parent_node)
				result.add(nodelist.get(i));
		}

		return result;
	}

	//対象となる子ノードが持っている親ノードを見つける
	/**
	 * @param child_node 子ノードを指定
	 * 指定された子ノード番号のNodesクラスを検索するメソッド
	 * @return 指定された子ノード番号のNodesクラスを返す
	 */
	public ArrayList<Nodes> ChildSearch(int child_node){
		ArrayList<Nodes> result = new ArrayList<Nodes>();

		for(int i=0; i<nodelist.size(); i++){
			if(nodelist.get(i).getChild_node() == child_node)
				result.add(nodelist.get(i));
		}

		return result;
	}

	/**
	 * @param parent_node
	 * @param child_node
	 * 指定された親ノードと子ノードのペアを持つNodesクラスのインデックスを検索するメソッド
	 * @return 条件に合うNodesクラスのインデックスを返す
	 */
	public int IndexSearch(int parent_node, int child_node){
		int result=0;
		for(int i=0; i<nodelist.size(); i++){
			if(nodelist.get(i).getParent_node() == parent_node && nodelist.get(i).getChild_node() == child_node){
				result = i;
				break;
			}
		}

		return result;
	}

	public ArrayList<Integer> ParentIndexSearch(int parent_node){
		ArrayList<Integer> index = new ArrayList<Integer>();
		for(int i=0; i<nodelist.size(); i++){
			if(nodelist.get(i).getParent_node() == parent_node)
				index.add(i);
		}
		return index;
	}

	//対象の2つのノードが繋がっているかどうか判定
	/**
	 * @param node1
	 * @param node2
	 * node1とnode2との間に辺があるかどうかを判定する<br>
	 * @return 辺があれば1 なければ0を返す
	 */
	public int Adjacent(int node1, int node2){
		int adjacent = 0;

		for(int i=0; i<nodelist.size(); i++)
			if( (nodelist.get(i).getParent_node() == node1 && nodelist.get(i).getChild_node() == node2)
				|| (nodelist.get(i).getParent_node() == node2 && nodelist.get(i).getChild_node() == node1) )
				adjacent = 1;

		return adjacent;
	}

	//対象のノードの次数を返す
	/**
	 * @param node_num ノードを指定
	 * 指定されたノードの次数を求めるメソッド
	 * @return 次数を返す
	 */
	public int degree(int node_num){
		int degree = 0;

		for(int i=0; i<nodelist.size(); i++){
			if(nodelist.get(i).getParent_node() == node_num)
				degree++;
			if(nodelist.get(i).getChild_node() == node_num)
				degree++;
		}

		return degree;
	}

	public void SetNodelist(ArrayList<Nodes> nodelist){
		this.nodelist = nodelist;
	}
}
