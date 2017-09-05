package 打印从1到最大的n位数;

import java.util.Arrays;

/**
 * 
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，则打印出1,2,3一直到最大的3位数999 。
 *
 */
public class Demo {

	//思路一：
	//	这个题目看起来很简单，之间从最小的1遍历到最大值逐个输出。不过我们很容易忽视的是我们并不能知道n的输入限制。
	//	所以我们不能使用int，long，等类型进行遍历。
	//	我们可以换一个思路，用char数组进行盛放，自定义模拟加法。
	
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
	
	//判断是不是已经达到最大值
	public static boolean isOver(char[] nums) {
		
		for(int i = 0 ; i < nums.length ; i++) {
			if(nums[i] != '9') {
				return false ;
			} ;
		}
		
		return true ;
	}
	
	//char[]数组模拟加法
	public static char[] addOne(char[] nums , int index) {
		
		if(nums[index] != '9') {
			nums[index] = (char) (nums[index] + 1) ;
		}else {
			nums[index] = '0' ;
			nums = addOne(nums , index-1) ;
		}	
		return nums ;	
	}
	
	//在输出是需要注意，在数组中左边空白都是‘0’字符，当n==3 ; 则在数组中9位009。这不符合我们的习惯。
	//所以我们要对次做一些处理。
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
				System.out.print("、");
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
	
	
	//思路二：
	//将问题转换为全排列问题，n位数的所有自然数为n位数的全排列。前面为0的不输出0
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
	
	//对每一位进行赋值进行递归
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
