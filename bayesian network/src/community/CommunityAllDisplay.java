package community;

import java.util.ArrayList;
import java.util.Collections;

public class CommunityAllDisplay {

	private ArrayList<Community> communitylist;

	public CommunityAllDisplay(ArrayList<Community> communitylist){
		this.communitylist = communitylist;
	}

	public void print(){
		for(int i=0; i<communitylist.size(); i++){
			System.out.println("node_num " + communitylist.get(i).getNode() + " community_num " + communitylist.get(i).getCommnuity());
		}
	}

	public void SortPrint(){
		Collections.sort(communitylist, new CommunityComparator());
		for(int i=0; i<communitylist.size(); i++){
			System.out.println("node_num " + communitylist.get(i).getNode() + " community_num " + communitylist.get(i).getCommnuity());
		}
	}

	public void CommuunityPrint(){
		Collections.sort(communitylist, new CommunityComparator());
		for(int i=0; i<communitylist.size(); i++){
			if(i == 0){
				System.out.print("コミュニティ番号 " + communitylist.get(i).getCommnuity() + " ");
			}
			else{
				if(communitylist.get(i).getCommnuity() != communitylist.get(i-1).getCommnuity()){
					System.out.println();
					System.out.print("コミュニティ番号 " + communitylist.get(i).getCommnuity() + " ");
				}
			}

			System.out.print(" " + communitylist.get(i).getNode() + " ");
		}

		System.out.println();
	}
}
