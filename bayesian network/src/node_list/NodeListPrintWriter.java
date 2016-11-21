package node_list;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author al13048
 * ノードリストをcsvファイルに出力するクラス
 */
public class NodeListPrintWriter {

	FileWriter fw;
	PrintWriter pw;
	/**
	 * ファイルの名前を指定する
	 */
	String fileName;

	public NodeListPrintWriter(String fileName){
		this.fileName = fileName;
	}

	/**
	 * ノードリストをcsvファイルに出力するメソッド<br>
	 * 出力は親ノード 子ノードの順である
	 * @param nodelist
	 */
	public void print(ArrayList<Nodes> nodelist){
		try{
			this.fw = new FileWriter(fileName, false);
			this.pw = new PrintWriter(new BufferedWriter(fw));

			for(int i=0; i<nodelist.size(); i++){
				pw.print(nodelist.get(i).getParent_node());
				pw.print(",");
				pw.print(nodelist.get(i).getChild_node());
				//pw.print(",");
				pw.println("");
			}
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
