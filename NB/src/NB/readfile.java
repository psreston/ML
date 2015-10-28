/**
 * Title: readfile.java
 * Description: 
 * @author preston
 * @date 2015-10-27
 */
package NB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @Title readfile.java
 * @author Preston
 * @date 2015-10-27
 */
public class readfile {
	
	public static ArrayList<String[]> read(String filepath) throws IOException{
		ArrayList<String[]> content = new ArrayList<String[]>();
		File f = new File(filepath);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String temp = br.readLine();
		
		while(temp!=null){
			String line[] = temp.split(" ");
			content.add(line);
			temp = br.readLine();
		}
		
		return content;
	}

}
