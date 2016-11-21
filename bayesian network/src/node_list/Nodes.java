package node_list;

/**
 * ノードの形を表すクラス
 * @author al13048
 *
 */
public class Nodes {

	//親ノード
		private int parent_node;

		//子ノード
		private int child_node;

		//コンストラクタ
		/**
		 * @param parent_node 親ノード番号
		 * @param child_node 子ノード番号
		 * parent_nodeとchild_nodeに代入
		 */

		public Nodes(int parent_node, int child_node){
			this.parent_node = parent_node;
			this.child_node = child_node;
		}

		public Nodes(){

		}

		public int getParent_node(){
			return parent_node;
		}

		public int getChild_node(){
			return child_node;

		}

		public void setNode(int parent_node, int child_node){
			this.parent_node = parent_node;
			this.child_node = child_node;
		}

		public void setParentNode(int parent_node){
			this.parent_node = parent_node;
		}

		public void setChildNode(int child_node){
			this.child_node = child_node;
		}

}
