package CPT;

import java.util.ArrayList;

public class CPT {

	private double[] probability;

	private int[] parent_node;

	private int child_node;

	public CPT(int child_node){
		this.child_node = child_node;
	}

	public CPT(){

	}

	//親ノードの数に対応した確率を与える
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

	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(!(obj instanceof CPT))
			return false;

		return false;
	}
}
