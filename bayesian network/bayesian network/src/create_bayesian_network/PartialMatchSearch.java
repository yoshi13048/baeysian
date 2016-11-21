package create_bayesian_network;

import java.util.ArrayDeque;
import java.util.ArrayList;

import child_list.ChildList;
import child_list.SearchChildList;
import parent_list.ParentList;
import parent_list.SearchParentList;

public class PartialMatchSearch {

	private ArrayDeque<Integer> stack;
	private ArrayList<Integer> route;
	private SearchParentList sp;
	private SearchChildList sc;

	public PartialMatchSearch(ArrayList<ParentList> parentlist, ArrayList<ChildList> childlist){
		sp = new SearchParentList(parentlist);
		sc = new SearchChildList(childlist);
	}

	public ArrayList<Integer> toRootNode(int node_num){
		stack = new ArrayDeque<Integer>();
		route = new ArrayList<Integer>();

		//evidenceからノード1までの経路探索
		stack.push(node_num);
		route.add(node_num);
		int tmp=0;
		while((tmp = stack.pop()) != 1){

			System.out.println("tmp" + tmp);

			System.out.println("P node " + sc.ParentNode(tmp) + " node num " + node_num + " tmp " + tmp);
			//親ノードがない場合
			if(sc.ParentNode(tmp).isEmpty()){
				//初期ノードの場合
				if(node_num == tmp){
					int min = 0;
					ArrayList<Integer> temp = sp.ChildNode(tmp);
					System.out.println("temp" + temp);
					for(int i=0; i<temp.size(); i++){
						if(min == 0)
							min = temp.get(i);
						else if(min > temp.get(i))
							min = temp.get(i);
						System.out.println("min" + min);
					}
					stack.push(min);
					route.add(min);
				}

			}

			//親ノードがある場合
			else{
				for(int i=0; i<sc.ParentNode(tmp).size(); i++){
					int parent = sc.ParentNode(tmp).get(i);
					boolean flag = true;
					//親ノードの中でも現在の経路に存在しないノードを経路に追加
					for(int j=0; j<route.size(); j++){
						if(parent == route.get(j)){
								flag = false;
								break;
						}
					}
					if(flag){
							stack.push(parent);
							route.add(parent);
						}
					}
				}

				System.out.println("stack " + stack + "route " + route);
			}
		return route;
	}

	public ArrayList<Integer> RegionSearch(int evidence, int target){
		stack = new ArrayDeque<Integer>();
		route = new ArrayList<Integer>();
		int from_node;
		int to_node;
		boolean flag = false;

		if(evidence < target){
			from_node = target;
			to_node = evidence;
		}
		else{
			from_node = evidence;
			to_node = target;
		}

		//from_nodeからto_nodeまでの昇っていく経路探索
		stack.push(from_node);
		route.add(from_node);
		int tmp=0;
		while(flag != true && stack.isEmpty() != true){
			tmp = stack.pop();


			if(tmp == to_node)
				flag = true;

			System.out.println("tmp" + tmp);

			//親ノードがない場合
			if(sc.ParentNode(tmp).isEmpty()){
				//初期ノードの場合
				if(from_node == tmp){
					int min = 0;
					ArrayList<Integer> temp = sp.ChildNode(tmp);
					System.out.println("temp" + temp);
					for(int i=0; i<temp.size(); i++){
						if(min == 0)
							min = temp.get(i);
						else if(min > temp.get(i))
							min = temp.get(i);
						System.out.println("min" + min);
					}
					stack.push(min);
					route.add(min);
				}

			}

			//親ノードがある場合
			else{
				for(int i=0; i<sc.ParentNode(tmp).size(); i++){
					int parent = sc.ParentNode(tmp).get(i);
					boolean exist_flag = true;
					//親ノードの中でも現在の経路に存在しないノードを経路に追加
					for(int j=0; j<route.size(); j++){
						if(parent == route.get(j)){
								exist_flag = false;
								break;
						}
					}
					if(exist_flag){
							stack.push(parent);
							route.add(parent);
						}
					}
				}

				System.out.println("stack " + stack + "route " + route);
			}
		return route;

	}
}
