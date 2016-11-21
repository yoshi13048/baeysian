package community;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CommunityReader {

	FileReader fr;
	BufferedReader br;
	String fileName;

	public CommunityReader(String fileName){
		this.fileName = fileName;
	}

	public ArrayList<Community> read(ArrayList<Integer> routelist){
		ArrayList<Community> communitylist = new ArrayList<Community>();
		int index = 0;
		try{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String line;
			StringTokenizer token;
			while( (line = br.readLine()) != null){
				token = new StringTokenizer(line, ",");
				while(token.hasMoreTokens()){
					Community community = new Community(routelist.get(index), Integer.parseInt(token.nextToken()));
					index++;
					communitylist.add(community);
				}
			}

			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		return communitylist;
	}

	public ArrayList<Community> ReadCommunity(ArrayList<Integer> routelist){
		ArrayList<Community> communitylist = new ArrayList<Community>();
		int index = 0;
		try{
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			String line;
			while( (line = br.readLine()) != null){
				Community community = new Community(routelist.get(index), Integer.parseInt(line));
				index++;
				communitylist.add(community);
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}

		return communitylist;
	}
}
