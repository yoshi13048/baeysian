package parent_list;

import java.util.ArrayList;

/**
 * @author al13048
 *親リストを表示させるクラス
 */
public class ParentListAllDisplay {

	private ArrayList<ParentList> parentlist;

	public ParentListAllDisplay(ArrayList<ParentList> parentlist){
		this.parentlist = parentlist;
	}

	public void display(){

		System.out.println("----parentlist----");
		for(int i=0; i<parentlist.size(); i++){
			System.out.println("Pnode" + parentlist.get(i).getParentNode());
			for(int j=0; j<parentlist.get(i).getChildNodeLength(); j++)
				System.out.print("Cnode" + j + " " + parentlist.get(i).getChildNode()[j]);
			System.out.println("");
		}
		System.out.println("----parentlist----");
	}
}
