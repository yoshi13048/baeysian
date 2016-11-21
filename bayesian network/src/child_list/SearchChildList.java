package child_list;

import java.util.ArrayList;

/**
 * @author al13048
 *子リスト内を検索するクラス
 */
public class SearchChildList {
	private ArrayList<ChildList> childlist;

	public SearchChildList(ArrayList<ChildList> childlist){
		this.childlist = childlist;
	}

	/**
	 * @param child_node 子ノード番号
	 * @return 親ノード番号
	 * 指定した子ノード番号が持つ親ノードを検索する
	 */
	public ArrayList<Integer> ParentNode(int child_node){
		ArrayList<Integer> parent_node = new ArrayList<Integer>();
		for(int i=0; i<childlist.size(); i++){
			if(child_node == childlist.get(i).getChildNode()){
				for(int n=0; n<childlist.get(i).getParentNodeLength(); n++)
				parent_node.add(childlist.get(i).getParentNode()[n]);
			}
		}

		return parent_node;
	}
}
