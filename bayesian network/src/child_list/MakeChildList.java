package child_list;

import java.util.ArrayList;

import node_list.Nodes;

/**
 * @author al13048
 *子リストの生成を行うクラス
 */
public class MakeChildList {
	private ArrayList<ChildList> childlist;

	/**
	 * @param total_node ネットワーク全体の総ノード数
	 * @param nodelist ノードの辺リスト
	 * 辺リストを元に子リストを作成する
	 */
	public MakeChildList(int total_node, ArrayList<Nodes> nodelist){
		childlist = new ArrayList<ChildList>();
		for(int m=1; m<=total_node; m++){
			ArrayList<Integer> list = new ArrayList<Integer>();

			for(int n=0; n<nodelist.size(); n++){
				if(m == nodelist.get(n).getChild_node()){
					list.add(nodelist.get(n).getParent_node());
				}
			}
			ChildList tmp = new ChildList(m);
			tmp.setChildList(list);
			childlist.add(tmp);
		}
	}

	public ArrayList<ChildList> getChildList(){
		return childlist;
	}
}
