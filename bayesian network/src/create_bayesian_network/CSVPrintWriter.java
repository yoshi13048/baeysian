package create_bayesian_network;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import CPT.CPT;

public class CSVPrintWriter {

	FileWriter fw;
	PrintWriter pw;
	String fileName;

	//Constructor
	public CSVPrintWriter(String fileName){
		this.fileName = fileName;
	}

	public void print(ArrayList<CPT> cptlist) throws IOException{
		try{
			this.fw = new FileWriter(fileName,false);
			this.pw = new PrintWriter(new BufferedWriter(fw));
			System.out.println("file open success");
			for(int i=0; i<cptlist.size(); i++){
				for(int a=0; a<cptlist.get(i).getParentNodeLength(); a++){
					pw.print(cptlist.get(i).getParentNode()[a]);
					pw.print(",");
				}
				pw.println();

				pw.print(cptlist.get(i).getChildNode());
				pw.println(",");

				for(int b=0; b<cptlist.get(i).getProbabilityLength(); b++){
					pw.print(cptlist.get(i).getProbability()[b]);
					pw.print(",");
				}
				pw.println();
			}
		}catch(FileNotFoundException fnex){
			fnex.printStackTrace();
		}
	}
}
