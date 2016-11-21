package community;

import java.util.ArrayList;

public class MakeDependenceList {

	private int total_community_num;

	public MakeDependenceList(int total_community_num){
		this.total_community_num = total_community_num;
	}

	public ArrayList<Dependence> Set(){
		ArrayList<Dependence> result = new ArrayList<Dependence>();
		for(int i=1; i<=total_community_num; i++){
			Dependence temp = new Dependence(i);
			result.add(temp);
		}

		return result;
	}
}
