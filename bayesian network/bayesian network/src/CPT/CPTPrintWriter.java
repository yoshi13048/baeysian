package CPT;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author al13048
 *CPTをcsvファイルに出力するクラス
 */
public class CPTPrintWriter {

	FileWriter fw;
	PrintWriter pw;
	String fileName;

	public CPTPrintWriter(String fileName){
		this.fileName = fileName;
	}

	public void print(ArrayList<CPT> cptlist){
		try{
			this.fw = new FileWriter(fileName, false);
			this.pw = new PrintWriter(new BufferedWriter(fw));

			for(int i=0; i<cptlist.size(); i++){
				for(int x=0; x<cptlist.get(i).getParentNodeLength(); x++){
					pw.print(cptlist.get(i).getParentNode()[x]);
					pw.print(",");
				}
				pw.println();

				pw.print(cptlist.get(i).getChildNode());
				pw.println(",");

				for(int y=0; y<cptlist.get(i).getProbabilityLength(); y++){
					pw.print(cptlist.get(i).getProbability()[y]);
					pw.print(",");
				}
				pw.println();
			}
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
