package node_list;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author al13048
 * csvファイルからノードリストを読み込むクラス
 */
public class NodeListReader {

	FileReader fr;
	BufferedReader br;
	String fileName;

	/**
	 * @param fileName csvファイル名を指定
	 */
	public NodeListReader(String fileName){
		this.fileName = fileName;
	}

	/**
	 * csvファイルからノードリストを読み込む
	 * @return 読み込んだノードリストを返す
	 */
	public ArrayList<Nodes> read(){
		ArrayList<Nodes> nodelist = new ArrayList<Nodes>();

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String line;
			StringTokenizer token;
			while((line = br.readLine()) != null){
				token = new StringTokenizer(line, ",");
				Nodes node = new Nodes();
				node.setParentNode(Integer.parseInt(token.nextToken()));
				node.setChildNode(Integer.parseInt(token.nextToken()));
				nodelist.add(node);
			}

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return nodelist;
	}
}
