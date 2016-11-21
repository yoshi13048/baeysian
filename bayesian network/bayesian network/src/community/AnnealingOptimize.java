package community;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import node_list.Nodes;

public class AnnealingOptimize {

	private double T;
	private double cool;
	private Integer community_from_num;
	private Integer community_to_num;
	private ArrayList<Integer> existnodelist;
	private ArrayList<Nodes> nodelist;
	private ArrayList<Community> communitylist;
	private ArrayList<Community> sortlist;

	public AnnealingOptimize(double T, double cool, Integer community_from_num, Integer community_to_num, ArrayList<Integer> existnodelist, ArrayList<Nodes> nodelist, ArrayList<Community> communitylist){
		this.T = T;
		this.cool = cool;
		this.community_from_num = community_from_num;
		this.community_to_num = community_to_num;
		this.existnodelist = existnodelist;
		this.nodelist = nodelist;
		this.communitylist = communitylist;
	}

	public void action(){

		int count = 0;
		//Q値ランダム初期設定
		double Q = new Random().nextDouble();
		double exit_condition = Math.pow(10, -6);
		boolean flag = false;
		while( count < 1000){

			//コミュニティを変更するノードの選択
			int index = new Random().nextInt(existnodelist.size());
			int node_num = existnodelist.get(index);

			//コミュニティを何に変更するか決定
			int new_community_num = (int) (Math.random()*community_to_num + community_from_num);
			//int new_community_num = (int) (new Random().nextDouble() * existnodelist.size() + 1);
			CommunitySearch cs = new CommunitySearch(communitylist);
			int old_community_num = cs.CommunityNumberSearch(node_num);
			if(new_community_num == old_community_num)
				continue;

			//変更前と変更後のQ値を計算
			communitylist.get(cs.NodeIndexSearch(node_num)).setCommnuity(new_community_num);
			CalculateQ cq = new CalculateQ(nodelist, communitylist);
			double newQ = cq.Calculate();
			double Q_difference = newQ - Q;
			System.out.println("Q_difference " + Q_difference);

			if(Q_difference == 0.0)
				continue;
			else if(Q_difference < 0.0001 && Q_difference > 0){
				T = 0.0;
				flag = true;
			}

			//温度から確率を定義
			double p = 0.0;
			if(T  != 0.0)
				p = Math.pow(Math.E, -1*(Math.abs(newQ - Q) / T));
			//System.out.println("差 " + (newQ-Q) + "肩" + -1*(Math.abs(newQ-Q)/T) + " p " + Math.pow(Math.E, -1*(Math.abs(newQ-Q)/T)));
			//System.out.println(" newQ " + newQ + " Q " + Q + " 差 " + (newQ-Q) + " 数値 " + -1*(Math.abs(newQ-Q)/T) + " p " + p);
			//変数後のコストが小さければ採用
			//コストが大きい場合は確率的に採用
			double q=0.0;
			if(newQ > Q || ( q =new Random().nextDouble() )< p){
				//System.out.println("newQ " + newQ + " Q " + Q + " q " + q + " p " + p );
				Q = newQ;

				/*
				if(node_num == 50 || node_num == 99)
				System.out.println(" q " + q + " p " + p + " ノード番号 " + node_num + " 変更前コミュニティ " + old_community_num
									+" 変更後コミュニティ " + new_community_num);
				*/
			}else{
				communitylist.get(cs.NodeIndexSearch(node_num)).setCommnuity(old_community_num);
			}

			//温度を下げる
			if(flag)
			T = T * cool;
		}

	}

	//コミュニティ番号でソートし数字を整える
	public ArrayList<Community> CommunitySort(){
		Collections.sort(communitylist, new CommunityComparator());
		int community_num = 1;

		for(int i=0; i<communitylist.size()-1; i++){
			if( communitylist.get(i).getCommnuity() == communitylist.get(i+1).getCommnuity() ){
				communitylist.get(i).setCommnuity(community_num);
			}
			else{
				communitylist.get(i).setCommnuity(community_num);
				community_num++;
			}
		}

		communitylist.get(communitylist.size()-1).setCommnuity(community_num);

		return communitylist;
	}

	public void Sort(int community_num){
		this.sortlist = new ArrayList<Community>();
		int community = 1;

		for(int i=0; i<communitylist.size()-1; i++){
			boolean flag = false;
			if(i != 0){
				if(communitylist.get(i).getCommnuity() != communitylist.get(i+1).getCommnuity()){
				flag = true;
				}
			}
			Community c = communitylist.get(i);
			c.setCommnuity(community);

			if(flag == true)
				community++;

			sortlist.add(c);

		}
		Community c = communitylist.get(communitylist.size()-1);
		c.setCommnuity(community);
		sortlist.add(c);

	}

	public void setCommunity(ArrayList<Community> communitylist){
		this.communitylist = communitylist;
	}

	public ArrayList<Community> getCommunity(){
		return this.communitylist;
	}

	public ArrayList<Community> getSort(){
		return this.sortlist;
	}
}
