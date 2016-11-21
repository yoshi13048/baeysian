package sampling;

import java.util.ArrayList;

import CPT.CPT;
import CPT.SearchCPT;
import CPT.SearchProbability;

public class Sampling {

	private ArrayList<CPT> cptlist;
	private ArrayList<AppearanceList> appearancelist;
	private ArrayList<Integer> routelist;
	private ArrayList<Sample> samplinglist;


	public Sampling(ArrayList<CPT> cptlist, ArrayList<Integer> routelist){
		this.cptlist = cptlist;
		this.routelist = routelist;
		appearancelist = new ArrayList<AppearanceList>();
	}

	public void createSample(int time){
		AppearanceList al = new AppearanceList();
		SearchCPT scpt = new SearchCPT(cptlist);
		samplinglist = new ArrayList<Sample>();

		for(int i=0; i<time; i++){
			for(int j=0; j<routelist.size(); j++){
				int tmp = routelist.get(j);
				int appearance = 0;

				//出現したかどうかの判定
				//親ノードがない場合
				if(scpt.ParentNode(tmp) == null){
					//出現しない場合
					if(Math.random() < scpt.Probability(tmp)[0]){
						al.setAppearance(tmp, appearance);
						appearancelist.add(al);
					}
					//出現する場合
					else{
						appearance = 1;
						al.setAppearance(tmp, appearance);
						appearancelist.add(al);
					}
				}

				//親ノードがある場合
				else{
					int[] temp = new int[scpt.ParentNode(tmp).size()];
					for(int k=0; k<scpt.ParentNode(tmp).size(); k++){
						temp[k] = appearancelist.get(i).getAppearance();
					}
					SearchProbability sp = new SearchProbability(scpt.Probability(tmp));
					double probability = sp.TargetProbability(temp);

					if(Math.random() < probability){
						al.setAppearance(tmp, appearance);
						appearancelist.add(al);
					}
					else{
						appearance = 1;
						al.setAppearance(tmp, appearance);
						appearancelist.add(al);
					}

				}

			//結果をsamplinglistに反映
			Sample s = new Sample(tmp);
			s.setAppearance(appearance, i);
			samplinglist.add(s);
			}
		}
	}

	public ArrayList<Sample> getSamplingList(){
		return samplinglist;
	}
}
