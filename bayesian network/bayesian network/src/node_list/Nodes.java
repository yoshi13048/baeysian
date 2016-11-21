package node_list;

public class Nodes {

	//親ノード
		private int parent_node;

		//子ノード
		private int child_node;

		//コンストラクタ
		public Nodes(int parent_node, int child_node){
			this.parent_node = parent_node;
			this.child_node = child_node;
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

}
