package CPT;

import java.util.ArrayList;

/**
 * @author al13048
 *CPT内を検索するクラス
 */
public class SearchCPT {

	private ArrayList<CPT> cptlist;
	public SearchCPT(ArrayList<CPT> cptlist){
		this.cptlist = cptlist;
	}

	//親ノードを返す
	/**
	 * @param child_node 子ノードを指定
	 * @return 指定された子ノードが持つ親ノードを返す
	 */
	public ArrayList<Integer> ParentNode(int child_node){
		ArrayList<Integer> parent_node = new ArrayList<Integer>();

		for(int i=0; i<cptlist.size(); i++){
			if(child_node == cptlist.get(i).getChildNode()){
				for(int n=0; n<cptlist.get(i).getParentNodeLength(); n++)
				parent_node.add(cptlist.get(i).getParentNode()[n]);
			}
		}

		//System.out.println("child_node " + child_node);
		//System.out.println("parent_node " + parent_node);

		return parent_node;
	}

	/**
	 * @param child_node 子ノードを指定
	 * @return CPTのインデックス
	 * 指定された子ノードのCPTにおけるインデックスを返す
	 */
	public int IndexSearch(int child_node){
		int result = 0;
		for(int i=0; i<cptlist.size(); i++){
			if(cptlist.get(i).getChildNode() == child_node){
				result = i;
				break;
			}
		}
		return result;
	}

	/**
	 * @param child_node 子ノードを指定
	 * @return 条件付き確率
	 * 指定された子ノードがCPTで持つ条件付き確率を返す<br>
	 * 指定された子ノードがCPT内に無い場合nullを返す
	 */
	public double[] Probability(int child_node){
		for(int i=0; i<cptlist.size(); i++){
			if(child_node == cptlist.get(i).getChildNode())
				return cptlist.get(i).getProbability();
		}

		return null;
	}
}
