package community;

public class Community {

	private int node_num;
	private int community_num;

	public Community(int node_num, int community_num){
		this.node_num = node_num;
		this.community_num = community_num;
	}

	public int getNode(){
		return this.node_num;
	}

	public int getCommnuity(){
		return this.community_num;
	}

	public void setNode(int node_num){
		this.node_num = node_num;
	}

	public void setCommnuity(int community_num){
		this.community_num = community_num;
	}
}
