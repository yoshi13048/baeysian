package community;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import node_list.Nodes;

public class MakeCommunityNodeList {

	private Map<Integer, ArrayList<Integer>> communitynodelist;
	private Integer community_number;

	public MakeCommunityNodeList(ArrayList<Nodes> nodelist, ArrayList<Community> communitylist){
		communitynodelist = new HashMap<Integer, ArrayList<Integer>>();
		Optional<Integer> s = communitylist.stream().map(m -> m.getCommnuity()).max(Comparator.naturalOrder());
		community_number = s.get();

		for(int community=1; community<=community_number; community++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i=0; i<communitylist.size(); i++){
				if(communitylist.get(i).getCommnuity() == community)
					temp.add(communitylist.get(i).getNode());
			}
			communitynodelist.put(community, temp);
		}
	}

	public Map<Integer, ArrayList<Integer>> getCommunityNodeList(){
		return this.communitynodelist;
	}
}
