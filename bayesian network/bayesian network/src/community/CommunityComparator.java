package community;

import java.util.Comparator;

public class CommunityComparator implements Comparator<Community>{

	public int compare(Community c1, Community c2){
		if(c1.getCommnuity() == c2.getCommnuity()){
			return c1.getNode() < c2.getNode() ? -1 : 1;
		}
		else{
			return c1.getCommnuity() < c2.getCommnuity() ? -1 : 1;
		}
	}
}
