package sampling;

import java.util.ArrayList;

public class SearchSample {

	private ArrayList<Sample> samplelist;

	public SearchSample(ArrayList<Sample> samplelist){
		this.samplelist = samplelist;
	}

	public ArrayList<Sample> TargetSample(int node_num){
		ArrayList<Sample> samplinglist = new ArrayList<Sample>();

		for(int i=0; i<samplelist.size(); i++){
			if(node_num == samplelist.get(i).getNodenum()){
				samplinglist.add(samplinglist.get(i));
			}
		}

		return samplinglist;
	}


}
