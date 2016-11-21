package CPT;

import java.util.ArrayList;

/**
 * @author al13048
 *既に存在しているCPTから指定したノードのみを抽出して再編するクラス
 */
public class CPTRebuilding {

	private ArrayList<Integer> existnodelist;
	private ArrayList<CPT> cptlist;

	public CPTRebuilding(ArrayList<CPT> cptlist, ArrayList<Integer> existnodelist){
		this.cptlist = cptlist;
		this.existnodelist = existnodelist;
	}

	public ArrayList<CPT> Create(){
		ArrayList<CPT> result = new ArrayList<CPT>();
		SearchCPT scpt = new SearchCPT(cptlist);

		for(int i=0; i<existnodelist.size(); i++){
			result.add(cptlist.get(scpt.IndexSearch(existnodelist.get(i))));
		}

		return result;
	}
}
