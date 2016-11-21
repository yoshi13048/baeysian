package community;

import java.util.ArrayList;

public class SearchCommunityList {

	private ArrayList<Community> communitylist;

	public SearchCommunityList(ArrayList<Community> communitylist){
		this.communitylist = communitylist;
	}

	public int SearchIndex(int node_num){
		int index = 0;
		for(int i=0; i<communitylist.size(); i++){
			if(communitylist.get(i).getNode() == node_num){
				index = i;
				break;
			}
		}

		return index;
	}
}
