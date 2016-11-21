package sampling;

import java.util.ArrayList;

import CPT.CPT;

/**
 * @author al13048
 *サンプリングの一連の操作を行うクラス
 */
public class SamplingMethod {

	private ArrayList<CPT> cptlist;
	private ArrayList<Integer> routelist;
	private long start;
	private long end;
	private long time;

	public SamplingMethod(ArrayList<CPT> cptlist, ArrayList<Integer> routelist){
		this.cptlist = cptlist;
		this.routelist = routelist;
	}

	/**
	 * @param sample_time サンプルを生成する個数
	 * @return サンプルを行うのにかかった時間
	 */
	public ArrayList<Sample> Measure(int sample_time){
		Sampling s = new Sampling(cptlist, routelist);
		start = System.nanoTime();
		s.createSample(sample_time);
		ArrayList<Sample> samplinglist = s.getSamplingList();
		end = System.nanoTime();
		time = (end -start) / 1000000;
		System.out.println("Time:" + (end - start) / 1000000f + "ms");
		return samplinglist;
	}

	public long getTime(){
		return time;
	}
}
