/**
 * Title: test.java
 * Description: 
 * @author preston
 * @date 2015-10-27
 */
package NB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import BOW.cntdiffclass;

/**
 * @Title test.java
 * @author Preston
 * @date 2015-10-27
 */
public class test {
	
	public static ArrayList<String> calclass(String testfilename , HashMap<String , cntdiffclass> bow) throws IOException{
		ArrayList<String[]> content = readfile.read(testfilename);
		ArrayList<String> classid = new ArrayList<String>();
		for(String[] line : content){
			double prubbish = 0;
			double pnormal = 0;
			HashSet<String> wordset = new HashSet<String>();
			for(int i = 1 ;i<line.length;i++){
				if(wordset.add(line[i])){
					if(bow.containsKey(line[i])){
						prubbish += Math.log(bow.get(line[i]).p_rubbish);
						pnormal += Math.log(bow.get(line[i]).p_normal);
					}
					else{
						prubbish += Math.log(1/(bow.get("num_all").p_rubbish+1));
						pnormal += Math.log(1/(bow.get("num_all").p_normal+1));
					}
//					System.out.print(prubbish+" "+pnormal);
				}
			}
//			System.out.println();
//			System.out.println(prubbish+" "+pnormal);
			if(prubbish>pnormal) classid.add("0");
			else classid.add("1");
		}
		
		return classid;
	}
	
	public static double accrate(String testfilename ,ArrayList<String> classid) throws IOException{
		int cntacc = 0;
		ArrayList<String[]> content = readfile.read(testfilename);
		
		for(int i = 0;i<content.size();i++){
			if(content.get(i)[0].equals(classid.get(i)))
				cntacc++;
		}
		
		return Double.valueOf(cntacc)/content.size();
	}

}
