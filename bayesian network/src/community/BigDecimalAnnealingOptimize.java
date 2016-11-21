package community;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import node_list.Nodes;

public class BigDecimalAnnealingOptimize {
	BigDecimal T;
	BigDecimal cool;
	Integer community_total_num;
	ArrayList<Integer> existnodelist;
	ArrayList<Nodes> nodelist;
	ArrayList<Community> communitylist;

	public BigDecimalAnnealingOptimize(BigDecimal T, BigDecimal cool, Integer community_total_num, ArrayList<Integer> existnodelist, ArrayList<Nodes> nodelist, ArrayList<Community> communitylist){
		this.T = T;
		this.cool = cool;
		this.community_total_num = community_total_num;
		this.existnodelist = existnodelist;
		this.nodelist = nodelist;
		this.communitylist = communitylist;
	}

	public ArrayList<Community> action(){

		//Q値ランダム初期設定
		BigDecimal Q = new BigDecimal(new Random().nextDouble());

		while(T.doubleValue() > 0.00000001){

			//コミュニティを変更するノードの選択
			int node_num = (int) (Math.random()*community_total_num + 1);

			//コミュニティを何に変更するか決定
			int new_community_num = (int) (new Random().nextDouble() * existnodelist.size() + 1);
			CommunitySearch cs = new CommunitySearch(communitylist);
			int old_community_num = cs.CommunityNumberSearch(node_num);

			//変更前と変更後のQ値を計算
			communitylist.get(cs.NodeIndexSearch(node_num)).setCommnuity(new_community_num);
			CalculateQ cq = new CalculateQ(nodelist, communitylist);
			BigDecimal newQ = new BigDecimal(cq.Calculate());

			//System.out.println("oldQ " + Q + " newQ " + newQ);

			//温度から確率を定義
			BigDecimal x = newQ.subtract(Q);
			BigDecimal minus = new BigDecimal("-1.0");
			if(x.doubleValue() < 0)
				x = x.multiply(minus);
			x = x.divide(T, 5, BigDecimal.ROUND_HALF_UP);

			//System.out.println(x.doubleValue());
			double p = Math.pow(Math.E, -1*x.doubleValue());

			//変数後のコストが小さければ採用
			//コストが大きい場合は確率的に採用
			double q=0.0;
			if(newQ.doubleValue() > Q.doubleValue() || ( q =new Random().nextDouble() )< p){
				//System.out.println("newQ " + newQ + " Q " + Q + " q " + q + " p " + p );
				Q = newQ;
				if(node_num == 15)
				System.out.print("ノード番号 " + node_num + " 変更前コミュニティ " + old_community_num
										+" 変更後コミュニティ " + new_community_num);
			}else{
				communitylist.get(cs.NodeIndexSearch(node_num)).setCommnuity(old_community_num);
			}

			//温度を下げる
			T = T.multiply(cool);
		}

		return communitylist;
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
}
