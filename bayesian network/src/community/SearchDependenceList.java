package community;

import java.util.ArrayList;

public class SearchDependenceList {

	private ArrayList<Dependence> dependencelist;

	public SearchDependenceList(ArrayList<Dependence> dependencelist){
		this.dependencelist = dependencelist;
	}

	public int CommunityIndexSearch(int community_num){
			Integer result = 0;
			for(int i=0; i<dependencelist.size(); i++){
				if(dependencelist.get(i).getCommunityNum() == community_num){
					result = i;
					break;
				}
			}

			return result;
	}
}
