package community;

import java.util.ArrayList;
import java.util.Arrays;

public class CommunitySort {

	private ArrayList<Community> communitylist;
	private Integer total_community;
	public CommunitySort(ArrayList<Community> communitylist, Integer total_community){
		this.communitylist = communitylist;
		this.total_community = total_community;
	}

	public ArrayList<Community> NumberSort(){
		ArrayList<Community> sortlist = new ArrayList<Community>();

		//各コミュニティの最小番号のノード番号
		Integer[] community_head = new Integer[total_community];

		//2次元ArrayList
		//templistにはコミュニティ毎のノードを格納
		ArrayList<ArrayList<Integer>> templist = new ArrayList<ArrayList<Integer>>();

		//コミュニティ毎のノードを格納する
		for(int i=1; i<=total_community; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j=0; j<communitylist.size(); j++){
				if(communitylist.get(j).getCommnuity() == i)
					temp.add(communitylist.get(j).getNode());
			}
			templist.add(temp);
		}

		//各コミュニティの最小のノード番号を格納する
		for(int i=0; i<templist.size(); i++){
			ArrayList<Integer> tmp = templist.get(i);
			community_head[i] = tmp.get(0);
		}
		Arrays.sort(community_head);

		//各コミュニティのノード番号が小さいものが属するコミュニティから
		//コミュニティ番号が順になるように整頓
		for(int i=0; i<community_head.length; i++){
			for(int j=0; j<templist.size(); j++){
				if(community_head[i] == templist.get(j).get(0)){
					ArrayList<Integer> temp = templist.get(j);
					for(int k = 0; k<temp.size(); k++){
						Community cm = new Community(temp.get(k), i+1 );
						sortlist.add(cm);
					}
				}
			}
		}
		return sortlist;
	}
}
