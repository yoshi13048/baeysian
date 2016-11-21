package create_bayesian_network;

import java.util.ArrayList;

import CPT.CPT;

public class SpeedTest {

	public static void main(String[] args){
		ArrayList<CPT> cptlist = new ArrayList<CPT>();
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		for(int i=1; i<100; i++){
			CPT tmp = new CPT(i);
			tmp.setCPT(list);
			cptlist.add(tmp);
			for(int a=0; a<tmp.getParentNodeLength(); a++){
				System.out.print(" Pnode" + a + " " + tmp.getParentNode()[a]);
			}
			System.out.println(" Cnode " + tmp.getChildNode());
			for(int b=0; b<tmp.getProbabilityLength(); b++){
				System.out.print(" Probability" + b+1 + " " + tmp.getProbability()[b]);
			}
			System.out.println("");
		}

		for(int i=1; i<100; i++){
			int x = cptlist.get(i).getProbabilityLength() /2;
			int y = (int)(Math.random() * x);

		}
	}
}
