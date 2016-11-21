package test;

import java.util.ArrayList;

import CPT.CPT;
import CPT.CPTAllDisplay;
import CPT.CPTPrintWriter;
import CPT.MakeCPT;
import child_list.ChildList;
import child_list.ChildListAllDisplay;
import child_list.MakeChildList;
import create_bayesian_network.MakeBayesianNetwork;
import node_list.NodeListPrintWriter;
import node_list.Nodes;
import parent_list.MakeParentList;
import parent_list.ParentList;
import parent_list.ParentListAllDisplay;
import sampling.CountSampling;
import sampling.Sample;
import sampling.Sampling;
import sampling.SamplingMethod;

public class Test {

	public static void main(String[] args){

		//ベイジアンネットワーク本体の生成

		//ノード総数 枝分かれ数 入力数
		int total_node_num = 1000;
		int branch_num = 2;
		int input_num = 3;


		//ランダムに生成
		MakeBayesianNetwork mbn = new MakeBayesianNetwork(total_node_num, branch_num, input_num);
		mbn.InitialSetting();
		mbn.SetNode();
		ArrayList<Nodes> nodelist = mbn.getNodelist();



		//CPTの作成
		MakeCPT mcpt = new MakeCPT(total_node_num, nodelist);
		ArrayList<CPT> cptlist = mcpt.getCPTList();

		/*
		//csvから読み込み
		NodeListReader nlr = new NodeListReader("test_nodelist.csv");
		ArrayList<Nodes> nodelist = nlr.read();



		//csvから読み込み
		CPTReader cptr = new CPTReader("test_CPTlist.csv");
		ArrayList<CPT> cptlist = cptr.read();
		*/



		//親子リスト作成
		MakeParentList mpl = new MakeParentList(total_node_num, nodelist);
		ArrayList<ParentList> pl = mpl.getParentList();

		MakeChildList mcl = new MakeChildList(total_node_num, nodelist);
		ArrayList<ChildList> cl = mcl.getChildList();

		//親子リスト表示
		ParentListAllDisplay plad = new ParentListAllDisplay(pl);
		plad.display();

		ChildListAllDisplay clad = new ChildListAllDisplay(cl);
		clad.display();

		//CPT表示
		CPTAllDisplay cptad = new CPTAllDisplay(cptlist);
		cptad.display();


		//経路探索
		/*
		//Evidence target
		int evidence_node = 400;
		int target_node = 800;

		SearchRoute sr = new SearchRoute(pl, cl, total_node_num, evidence_node, target_node);
		ArrayList<Integer> routelist = sr.dfs();
		*/

		ArrayList<Integer> routelist = new ArrayList<Integer>();
		for(int i=1; i<total_node_num; i++){
			routelist.add(i);
		}

		//Sampling
		Sampling s = new Sampling(cptlist, routelist);
		long start = System.nanoTime();
		int sampling_time = 10;
		s.createSample(sampling_time);
		ArrayList<Sample> samplinglist = s.getSamplingList();
		long end = System.nanoTime();
		System.out.println("条件:" + " 計算ノード総数 " + routelist.size() + " sample回数 " + sampling_time);
		System.out.println("Time:" + (end - start) / 1000000f + "ms");

		long time = 0;
		int count = 100;
		for(int i=0; i<count; i++){
			SamplingMethod sm = new SamplingMethod(cptlist, routelist);
			samplinglist = sm.Measure(sampling_time);
			time += sm.getTime();
		}

		time = (long) (time / count);
		System.out.println("平均時間:" + time + "ms");

		//確率を計算
		CountSampling cs = new CountSampling(samplinglist);
		int evidence = 40;
		int evidence_truth = 1;
		int target = 80;
		int target_truth = 1;
		double p = cs.DoubleProbability(evidence, evidence_truth, target, target_truth);
		System.out.println("P(" + evidence +"= " + evidence_truth + " | " + target + "= " + target_truth + " = " + p);


		//ノードリスト出力
		NodeListPrintWriter nlp = new NodeListPrintWriter("community_node1000.csv");
		nlp.print(nodelist);

		//CPT出力
		CPTPrintWriter cptp = new CPTPrintWriter("community_CPT1000.csv");
		cptp.print(cptlist);

	}
}
