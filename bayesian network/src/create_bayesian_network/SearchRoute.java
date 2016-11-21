package create_bayesian_network;

import java.util.ArrayList;
import java.util.Collections;

import child_list.ChildList;
import parent_list.ParentList;

public class SearchRoute {

	private int evidence;
	private int target;
	private int pattern;
	private ArrayList<ParentList> parentlist;
	private ArrayList<ChildList> childlist;
	private ArrayList<Integer> route;
	private ArrayList<Integer> evidence_route;
	private ArrayList<Integer> target_route;

	public SearchRoute(ArrayList<ParentList> parentlist, ArrayList<ChildList> childlist, int total_node, int evidence, int target){
		this.parentlist = parentlist;
		this.childlist = childlist;
		this.evidence = evidence;
		this.target = target;

		//evidenceとtargetが左右の枝に分かれてる場合
		if( (evidence <= total_node/2 && target > total_node/2)|| (evidence > total_node/2 && target <= total_node/2) ){
			this.pattern = 1;
		}
		else{
			this.pattern = 2;
		}

	}

	//深さ優先探索
	public ArrayList<Integer> dfs(){

		PartialMatchSearch pms = new PartialMatchSearch(parentlist, childlist);
		route = new ArrayList<Integer>();

		if(pattern == 1){
			evidence_route = new ArrayList<Integer>();
			evidence_route.addAll(pms.toRootNode(evidence));

			target_route = new ArrayList<Integer>();
			target_route.addAll(pms.toRootNode(target));

			Collections.sort(evidence_route);
			Collections.sort(target_route);
			target_route.remove(0);

			route.addAll(evidence_route);
			route.addAll(target_route);
			System.out.println("evidence_route" + evidence_route);
			System.out.println("target_rotue " + target_route);
			System.out.println(" route " + route);
		}

		else if(pattern == 2){
			route.addAll(pms.RegionSearch(evidence, target));

			Collections.sort(route);
			System.out.println("route " + route);
		}

		return route;


	}


	public int getEvidence(){
		return evidence;
	}

	public int getTarget(){
		return target;
	}

	public ArrayList<Integer> getRoute(){
		return route;
	}

	public ArrayList<Integer> getEvidenceRoute(){
		return evidence_route;
	}

	public ArrayList<Integer> getTargetRoute(){
		return target_route;
	}
}
