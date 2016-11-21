package community;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CommunityPrintWriter {

	FileWriter fw;
	PrintWriter pw;
	String fileName;

	public CommunityPrintWriter(String fileName){
		this.fileName = fileName;
	}

	public void print(ArrayList<Community> communitylist){
		try{
			this.fw = new FileWriter(fileName, false);
			this.pw = new PrintWriter(new BufferedWriter(fw));

			for(int i=0; i<communitylist.size(); i++){
				pw.println(communitylist.get(i).getCommnuity());
			}

		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
