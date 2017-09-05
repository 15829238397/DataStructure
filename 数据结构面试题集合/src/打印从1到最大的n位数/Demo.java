package ��ӡ��1������nλ��;

import java.util.Arrays;

/**
 * 
 * ��������n����˳���ӡ����1������nλʮ����������������3�����ӡ��1,2,3һֱ������3λ��999 ��
 *
 */
public class Demo {

	//˼·һ��
	//	�����Ŀ�������ܼ򵥣�֮�����С��1���������ֵ���������������Ǻ����׺��ӵ������ǲ�����֪��n���������ơ�
	//	�������ǲ���ʹ��int��long�������ͽ��б�����
	//	���ǿ��Ի�һ��˼·����char�������ʢ�ţ��Զ���ģ��ӷ���
	
    static boolean isFirst = true ;
	
	public static void printAllNum(int n) throws Exception {
		
		if(n<1) {
			return ;
		}
		
		isFirst = true ;
		char[] nums = new char[n] ;
		Arrays.fill(nums, '0');
		
		while(!isOver(nums)){
			addOne(nums, n-1) ;
			
			printNum(nums);
		} 
		
	}
	
	//�ж��ǲ����Ѿ��ﵽ���ֵ
	public static boolean isOver(char[] nums) {
		
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i] != '9') {
				return false ;
			} ;
		}
		
		return true ;
	}
	
	//char[]����ģ��ӷ�
	public static char[] addOne(char[] nums , int index) {
		
		if(nums[index] != '9') {
			nums[index] = (char) (nums[index] + 1) ;
		}else {
			nums[index] = '0' ;
			nums = addOne(nums , index-1) ;
		}	
		return nums ;	
	}
	
	//���������Ҫע�⣬����������߿հ׶��ǡ�0���ַ�����n==3 ; ����������9λ009���ⲻ�������ǵ�ϰ�ߡ�
	//��������Ҫ�Դ���һЩ����
	public static void printNum(char[] nums) {
			
		boolean isBegin = false ;
		int beginIndex = 0 ;
		
		for(int i = 0 ; i < nums.length ; i++) {
			
			if(nums[i] != '0' ) {
				isBegin = true ;
				beginIndex = i ;
				break ;
			}
		}
		
		if(isBegin) {
			if(!isFirst ) {
				System.out.print("��");
			}else {
				isFirst = false ;
			}
		}
		
		for(int i = beginIndex ; i < nums.length ; i++) {
			if(isBegin) {
				System.out.print(nums[i]);
			}
		}
	
	}
	
	
	//˼·����
	//������ת��Ϊȫ�������⣬nλ����������Ȼ��Ϊnλ����ȫ���С�ǰ��Ϊ0�Ĳ����0
	public static void printAllNum1(int n) {
		
		if(n <= 0) {
			return ;
		}
		
		char[] nums = new char[n] ;
		Arrays.fill(nums, '0');
		isFirst = true ;
		
		for(int i = 0 ; i < 10 ; i++) {
			nums[0] = (char) ('0' + i) ;
			print1ToMaxNum(nums , n , 0) ;
		}
		
		
	}
	
	//��ÿһλ���и�ֵ���еݹ�
	public static void print1ToMaxNum(char[] nums , int length , int index ) {
		
		if(length-1 == index) {
			printNum(nums);
			return ;
		}
		
		for(int i = 0 ; i < 10 ; i++ ) {
			nums[1+index] = (char) (i + '0') ; 
			print1ToMaxNum(nums , length , index+1) ;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		try {
			printAllNum(1) ;
			System.out.println();
			printAllNum(3) ;
			System.out.println();
			printAllNum(0) ;
			printAllNum1(1) ;
			System.out.println();
			printAllNum1(3) ;
			System.out.println();
			printAllNum1(0) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
