package community;

import java.util.ArrayList;

public class SameCommunityDecision {

	private ArrayList<Community> communitylist;

	public SameCommunityDecision(ArrayList<Community> communitylist){
		this.communitylist = communitylist;
	}

	public int judge(int node_num1, int node_num2){
		int judgement = 0;
		int community1 = 0;
		int community2 = 0;

		SearchCommunityList scl = new SearchCommunityList(communitylist);
		community1 = communitylist.get(scl.SearchIndex(node_num1)).getCommnuity();
		community2 = communitylist.get(scl.SearchIndex(node_num2)).getCommnuity();

		if(community1 == community2)
			judgement = 1;

		return judgement;
	}
}
