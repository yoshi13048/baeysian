package parent_list;

import java.util.ArrayList;

import node_list.Nodes;


/**
 * @author al13048
 *親リストの生成を行うクラス
 */
public class MakeParentList {

	private ArrayList<ParentList> parentlist;

	/**
	 * @param total_node ネットワーク全体の総ノード数
	 * @param nodelist ノードの辺リスト
	 * 辺リストを元に親リストを作成する
	 */
	public MakeParentList(int total_node, ArrayList<Nodes> nodelist){
		parentlist = new ArrayList<ParentList>();
		for(int m=1; m<=total_node; m++){
			ArrayList<Integer> list = new ArrayList<Integer>();

			for(int n=0; n<nodelist.size(); n++){
				if(m == nodelist.get(n).getParent_node()){
					list.add(nodelist.get(n).getChild_node());
				}
			}
			ParentList tmp = new ParentList(m);
			tmp.setParentList(list);
			parentlist.add(tmp);
		}
	}

	public ArrayList<ParentList> getParentList(){
		return parentlist;
	}
}
