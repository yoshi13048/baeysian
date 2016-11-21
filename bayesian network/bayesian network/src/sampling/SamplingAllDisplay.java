package sampling;

import java.util.ArrayList;

public class SamplingAllDisplay {

	private ArrayList<Sample> samplinglist;

	public SamplingAllDisplay(ArrayList<Sample> samplinglist){
		this.samplinglist = samplinglist;
	}

	public void display(){
		for(int i=0; i<samplinglist.size(); i++){
			System.out.print("node num " + samplinglist.get(i).getNodenum());
			System.out.print(" sampling回数 " +samplinglist.get(i).getCount());
			System.out.print(" 出現したかどうか  " + samplinglist.get(i).getAppearance());
			System.out.println("");
		}
	}
}
