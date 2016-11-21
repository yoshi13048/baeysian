package child_list;

import java.util.ArrayList;

public class ChildListAllDisplay {

	private ArrayList<ChildList> childlist;

	public ChildListAllDisplay(ArrayList<ChildList> childlist){
		this.childlist = childlist;
	}

	public void display(){

		System.out.println("----childlist----");
		for(int i=0; i<childlist.size(); i++){
			for(int j=0; j<childlist.get(i).getParentNodeLength(); j++)
				System.out.print("Pnode" + j + " " + childlist.get(i).getParentNode()[j] + " ");
			System.out.println();
			System.out.println("Conde " + childlist.get(i).getChildNode());
		}
		System.out.println("----childlist----");
	}
}
