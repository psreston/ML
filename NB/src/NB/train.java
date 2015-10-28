/**
 * Title: train.java
 * Description: 
 * @author preston
 * @date 2015-10-27
 */
package NB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import BOW.cntdiffclass;
/**
 * @Title train.java
 * @author Preston
 * @date 2015-10-27
 */
public class train {
	public static HashMap<String , cntdiffclass> createBOW(String trainfilepath) throws IOException{
		HashMap<String , cntdiffclass> bow = new HashMap<String , cntdiffclass>();
		ArrayList<String[]> content = readfile.read(trainfilepath);
		System.out.println("Finish Load train file£¡");
		int num_mail = content.size();
		int num_rubbish = 0;//0
		int num_normal = 0;//1
		for(int i =0 ;i<content.size();i++){
			String line[] = content.get(i);
			if(line[0].equals("0"))
				num_rubbish++;
			else
				num_normal++;
			for(int j = 1 ;j<line.length;j++){ 
				if(bow.containsKey(line[j])){
					cntdiffclass thisword = bow.get(line[j]);
					bow.put(line[j], addtobow(line[0],thisword,i));
				}
				else{
					cntdiffclass newword = new cntdiffclass();
					bow.put(line[j], addtobow(line[0],newword,i));
				}
			}
		}
		
		Iterator iter = bow.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			cntdiffclass word = (cntdiffclass) entry.getValue();
			word.p_normal = Double.valueOf(word.normal.size()+1)/(num_normal+1);
			word.p_rubbish = Double.valueOf(word.rubbish.size()+1)/(num_rubbish+1);
		}
		bow.put("num_all", new cntdiffclass(Double.valueOf(num_rubbish) , Double.valueOf(num_normal)));
		return bow;
	}
	
	public static cntdiffclass addtobow(String classinfo ,cntdiffclass thisword , int mail_id){
		if(classinfo.equals("0")){
			if(!thisword.rubbish.contains(mail_id))
				thisword.rubbish.add(mail_id);
		}
		else{
			if(!thisword.normal.contains(mail_id))
				thisword.normal.add(mail_id);
		}
		
		return thisword;
	}
}