package CPT;

import java.util.ArrayList;

/**
 * @author al13048
 *CPTの構造を定めるクラス
 */
public class CPT {

	private double[] probability;

	private int[] parent_node;

	private int child_node;

	public CPT(int child_node){
		this.child_node = child_node;
	}

	public CPT(){

	}

	/**
	 * @param child_node 子ノードを設定
	 */
	public void setChildNode(int child_node){
		this.child_node = child_node;
	}

	/**
	 * @param parent_node 親ノードを設定
	 */
	public void setParentNode(ArrayList<Integer> parent_node){
		this.parent_node = new int[parent_node.size()];
		for(int i=0; i<parent_node.size(); i++){
			this.parent_node[i] = parent_node.get(i);
		}
	}

	/**
	 * @param probability 条件付き確率を設定
	 */
	public void setProbability(ArrayList<Double> probability){
		this.probability = new double[probability.size()];
		for(int i=0; i<probability.size(); i++){
			this.probability[i] = probability.get(i);
		}
	}
	//親ノードの数に対応した確率を与える
	/**
	 * @param parent_node 親ノード
	 * 親ノードの個数に応じた条件付き確率をランダムに設定する
	 */
	public void setCPT(ArrayList<Integer> parent_node){
		this.parent_node = new int[parent_node.size()];
		if(parent_node.size() == 0){
			this.probability = new double[2];
		}
		else{
			this.probability = new double[(int)(Math.pow(2, parent_node.size()) * 2)];
		}
		for(int x=0; x<parent_node.size(); x++){
			this.parent_node[x] = parent_node.get(x);
		}
		for(int i=0; i<probability.length-1; i++){
			this.probability[i] = Math.random();
			this.probability[i+1] = 1 - probability[i];
			i++;
		}
	}

	public double[] getProbability(){
		return this.probability;
	}

	public int[] getParentNode(){
		return  parent_node;
	}

	public int getChildNode(){
		return child_node;
	}

	public int getParentNodeLength(){
		return parent_node.length;
	}

	public int getProbabilityLength(){
		return probability.length;
	}

}
