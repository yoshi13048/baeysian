package combartGML;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import node_list.Nodes;

public class CsvCombartGml {

	FileWriter fw;
	PrintWriter pw;

	String fileName;

	public CsvCombartGml(String fileName){
		this.fileName = fileName;
	}

	public void print(ArrayList<Nodes> nodelist, int num){
		try{
			System.out.println("書き込み開始");
			this.fw = new FileWriter(fileName, false);
			this.pw = new PrintWriter(new BufferedWriter(fw));

			pw.println("graph [");
			for(int i=0; i<num; i++){
				pw.println("node [");
				pw.println("id "+ (i+1));
				pw.println("]");
			}
			for(int i=0; i<nodelist.size(); i++){
				pw.println("edge [");
				pw.println("source " + nodelist.get(i).getParent_node());
				pw.println("target " + nodelist.get(i).getChild_node());
				pw.println("]");
			}

			pw.println("]");
			pw.close();
			System.out.println("書き込み完了");
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
