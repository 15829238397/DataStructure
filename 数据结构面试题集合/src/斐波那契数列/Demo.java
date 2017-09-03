package 斐波那契数列;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 题目要求：
 * 求斐波那契数列的第n项。
 *
 */

public class Demo {

	private static Map<Integer , Integer> result = new HashMap<>() ;
	
	//思路一：
	//斐波那契数列的第n项的计算过程是一个标准的递归
	public static int getValue(int n) throws Exception {
		
		if(n < 0) {
			throw new Exception("输入参数小于0 ，不合法的输入") ;
		}
		
		if(n <= 1) {
			return (n==1) ? 1: 0 ;
		}
		
		return getValue( n-1 ) + getValue( n-2 ) ;
		
	}
	
	//思路二：
	//斐波那契数列的第n项的计算过程是一个标准的递归
	//新建一个数组对计算结果进行存储，下次计算式，先在数组中进行查询，若不存在再进行计算。
	
	
	public static int getValue1(int n) throws Exception {
		
		if(n < 0) {
			throw new Exception("输入参数小于0 ，不合法的输入") ;
		}
		
		if(n <= 1) {
			return (n==1) ? 1: 0 ;
		}
		
		if(result.get(n)!=null) {
			return result.get(n) ;
		}else {
			result.put(n, getValue( n-1 ) + getValue( n-2 )) ;
		}
		
		
		return result.get(n) ;
		
	}
		
	
	//测试
	public static void main(String[] args) {
		
		try {
			
			System.out.println("未优化");
			long curTime = System.nanoTime() ;
			System.out.println(getValue(5));
			System.out.println(System.nanoTime() - curTime);
			
			System.out.println("-----------------------------------");
			
			System.out.println("优化");
			curTime = System.nanoTime() ;
			System.out.println(getValue1(5));
			System.out.println(System.nanoTime() - curTime);
			
			System.out.println("-----------------------------------");
			System.out.println("未优化");
			curTime = System.nanoTime() ;
			System.out.println(getValue(30));
			System.out.println(System.nanoTime() - curTime);
			
			System.out.println("-----------------------------------");
			System.out.println("优化");
			curTime = System.nanoTime() ;
			System.out.println(getValue1(30));
			System.out.println(System.nanoTime() - curTime);
			
			
			
			System.out.println(getValue1(-1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
