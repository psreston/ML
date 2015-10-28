/**
 * Title: main.java
 * Description: 
 * @author preston
 * @date 2015-10-27
 */
package NB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import BOW.cntdiffclass;

/**
 * @Title main.java
 * @author Preston
 * @date 2015-10-27
 */
public class main {
	public static void main(String args[]) throws IOException{
		long startTime=System.currentTimeMillis();   //获取开始时间
		HashMap<String , cntdiffclass> bow = train.createBOW("spam_train.txt");
		System.out.println("Finish train！");
		long endTime=System.currentTimeMillis(); //获取结束时间
		System.out.println((endTime-startTime)+"ms");
		startTime=System.currentTimeMillis();
		ArrayList<String> classid = test.calclass("spam_test.txt", bow);
		System.out.println("create id");
		System.out.println(test.accrate("spam_test.txt", classid));
		endTime=System.currentTimeMillis();
		System.out.println((endTime-startTime)+"ms");
	}

}
