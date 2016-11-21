package CPT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author al13048
 *CPTをcsvファイルから読み込むクラス
 */
public class CPTReader {

	FileReader fr;
	BufferedReader br;
	String fileName;

	public CPTReader(String fileName){
		this.fileName = fileName;
	}

	public ArrayList<CPT> read(){
		ArrayList<CPT> cptlist = new ArrayList<CPT>();

		try{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String line;
			StringTokenizer token, token2, token3;
			while((line = br.readLine()) != null){
				CPT cpt = new CPT();

				//親ノードの読み込み
				ArrayList<Integer> parent = new ArrayList<Integer>();
				token = new StringTokenizer(line, ",");
				while(token.hasMoreTokens()){
					parent.add(Integer.parseInt(token.nextToken()));
				}
				cpt.setParentNode(parent);

				//子ノードの読み込み
				line = br.readLine();
				int child = 0;
				token2 = new StringTokenizer(line, ",");
				while(token2.hasMoreTokens()){
					child = Integer.parseInt(token2.nextToken());
				}
				cpt.setChildNode(child);

				//確率の読み込み
				line = br.readLine();
				ArrayList<Double> probability = new ArrayList<Double>();
				token3  = new StringTokenizer(line, ",");
				while(token3.hasMoreTokens()){
					probability.add(Double.parseDouble(token3.nextToken()));
				}
				cpt.setProbability(probability);

				cptlist.add(cpt);
			}

			br.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}

		return cptlist;
	}
}
