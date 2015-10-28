package BOW;

import java.util.ArrayList;

/**
 * Title: cntdiffclass.java
 * Description: 
 * @author preston
 * @date 2015-10-27
 */

/**
 * @Title cntdiffclass.java
 * @author Preston
 * @date 2015-10-27
 */
public class cntdiffclass {

	public ArrayList<Integer> rubbish;
	public ArrayList<Integer> normal;
	public double p_rubbish;
	public double p_normal;
	
	public cntdiffclass(){
		this.rubbish = new ArrayList<Integer>();
		this.normal = new ArrayList<Integer>();
		this.p_rubbish = 0;
		this.p_normal = 0;
	}
	public cntdiffclass(double num_rubbish , double num_normal){
		this.rubbish = new ArrayList<Integer>();
		this.normal = new ArrayList<Integer>();
		this.p_rubbish = num_rubbish;
		this.p_normal = num_normal;
	}
	
	public void increase_rubbish(int i){
		this.rubbish.add(i);
	}
	
	public void increase_normal(int i){
		this.normal.add(i);
	}
}
