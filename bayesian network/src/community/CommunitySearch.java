package community;

import java.util.ArrayList;

public class CommunitySearch {

	private ArrayList<Community> communitylist;

	public CommunitySearch(ArrayList<Community> communitylist){
		this.communitylist = communitylist;
	}

	//ノードが所属しているコミュニティ番号を出力
	public int CommunityNumberSearch(int node_num){
		int index = 0;
		for(int i=0; i<communitylist.size(); i++){
			if(node_num == communitylist.get(i).getNode()){
				index = i;
				break;
			}
		}

		return communitylist.get(index).getCommnuity();
	}

	//コミュニティに所属しているノード番号を出力
	public ArrayList<Integer> NodeNumberSearch(int community_num){
		ArrayList<Integer> nodelist = new ArrayList<Integer>();
		for(int i=0; i<communitylist.size(); i++){
			if(community_num == communitylist.get(i).getCommnuity())
				nodelist.add(communitylist.get(i).getNode());
		}

		return nodelist;
	}

	//該当ノードのindexを返す
	public Integer NodeIndexSearch(int node_num){
		int index = 0;
		for(int i=0; i<communitylist.size(); i++){
			if(node_num == communitylist.get(i).getNode()){
				index = i;
				break;
			}
		}

		return index;
	}
}
