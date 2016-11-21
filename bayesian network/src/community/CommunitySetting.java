package community;

import java.util.ArrayList;

public class CommunitySetting {
	private ArrayList<Integer> existnodelist;

	public CommunitySetting(ArrayList<Integer> existnodelist){
		this.existnodelist = existnodelist;
	}

	//初期設定
	public ArrayList<Community> InitialSetting(){
		ArrayList<Community> communitylist = new ArrayList<Community>();
		for(int i=0; i<existnodelist.size(); i++){
			Community c = new Community(existnodelist.get(i), existnodelist.get(i));
			communitylist.add(c);
		}

		return communitylist;
	}

	//コミュニティの設定を変更
	public ArrayList<Community> Change(ArrayList<Community> communitylist, int node_num, int community_num){
		for(int i=0; i<communitylist.size(); i++){
			if(node_num == communitylist.get(i).getNode())
				communitylist.get(i).setCommnuity(community_num);
		}

		return communitylist;
	}

	public ArrayList<Community> Setting(int community_num){
		ArrayList<Community> communitylist = new ArrayList<Community>();
		int split = existnodelist.size() / community_num;
		System.out.println("split" + split);
		for(int i=0; i<existnodelist.size(); i++){
			int count = 1;
			while(split * count <= existnodelist.get(i) ){
				count++;
			}
			System.out.println("ノード " + existnodelist.get(i) + " コミュニティ" + count);
			Community c = new Community(existnodelist.get(i), count);
			communitylist.add(c);
		}

		return communitylist;
	}

}
