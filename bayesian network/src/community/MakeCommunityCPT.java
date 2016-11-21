package community;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import CPT.CPT;
import CPT.CPTRebuilding;

public class MakeCommunityCPT {

	private Map<Integer, ArrayList<CPT>> communitycptlist;
	private Integer community_number;

	public MakeCommunityCPT(ArrayList<CPT> cptlist, Map<Integer, ArrayList<Integer>> communitynodelist, ArrayList<Community> communitylist){
		communitycptlist = new HashMap<Integer, ArrayList<CPT>>();
		Optional<Integer> s = communitylist.stream().map(m -> m.getCommnuity()).max(Comparator.naturalOrder());
		community_number = s.get();

		for(int i=1; i<=community_number; i++){
			CPTRebuilding cptrb = new CPTRebuilding(cptlist, communitynodelist.get(i));
			communitycptlist.put(i, cptrb.Create());
		}
	}

	public Map<Integer, ArrayList<CPT>> getCommunityCPTList(){
		return this.communitycptlist;
	}
}
