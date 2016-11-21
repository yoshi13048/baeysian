package sampling;

import java.util.ArrayList;

public class CountSampling {
		private ArrayList<Sample> samplinglist;

		public CountSampling(ArrayList<Sample> samplinglist){
			this.samplinglist = samplinglist;
		}

		//P(node_num)の確率を求める
		public double SingleProbability(int node_num, int appearance){
			double appearance_count = 0;
			double condition_count = 0;
			for(int i=0; i<samplinglist.size(); i++){
				if(node_num == samplinglist.get(i).getNodenum()){
						appearance_count++;
						if(appearance == samplinglist.get(i).getAppearance()){
							condition_count++;
						}
				}
			}

			double probability = condition_count / appearance_count;

			return probability;

		}

		//P(node_num2 | node_num1)の確率を求める
		public double DoubleProbability(int node_num1, int appearance1, int node_num2, int appearance2){
			ArrayList<Sample> samplelist1 = new ArrayList<Sample>();
			ArrayList<Sample> samplelist2 = new ArrayList<Sample>();
			double appearance_count = 0;
			double condition_count = 0;

			//samplinglistから該当ノード番号のサンプルを抽出
			for(int i=0; i<samplinglist.size(); i++){
				if(node_num1 == samplinglist.get(i).getNodenum()){
					samplelist1.add(samplinglist.get(i));
				}
				if(node_num2 == samplinglist.get(i).getNodenum())
					samplelist2.add(samplinglist.get(i));
			}

			for(int j=0; j<samplelist1.size(); j++){
				if(appearance1 == samplelist1.get(j).getAppearance()){
					appearance_count++;
					for(int k=0; k<samplelist2.size(); k++){
						if(appearance2 == samplelist2.get(k).getAppearance() && samplelist1.get(j).getCount() == samplelist2.get(k).getCount())
							condition_count++;
					}
				}
			}

			double probability = condition_count / appearance_count;

			return probability;

		}
}
