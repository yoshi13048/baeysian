package CPT;

import java.util.ArrayList;

/**
 * @author al13048
 *CPTの内容を表示するクラス
 */
public class CPTAllDisplay {

	private ArrayList<CPT> cptlist;

	public CPTAllDisplay(ArrayList<CPT> cptlist){
		this.cptlist = cptlist;
	}

	public void display(){

		System.out.println("----cptlist----");
		for(int i=0; i<cptlist.size(); i++){
			for(int j=0; j<cptlist.get(i).getParentNodeLength(); j++)
				System.out.print("Pnode" + j + " "+ cptlist.get(i).getParentNode()[j] + " ");
			System.out.println();
			System.out.println("Cnode" + cptlist.get(i).getChildNode());
			for(int k=0; k<cptlist.get(i).getProbabilityLength(); k++){
				System.out.print("Probability" + k + " " + cptlist.get(i).getProbability()[k] + " ");
				if(k%2 != 0)
					System.out.println("");
			}
			System.out.println("----cptlist----");
		}
	}
}
