package 不修改数组找出重复的数字;

import 数组中重复的数字.demo;

/**
 * 
 * 在一个长度为n+1的数组里所有的数字都在1-n的范围之中，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但不能修改修改输入的数组。 
 * 
 */

public class Demo {

//	思路一：
//	由于得知了所有的数字都在1-n的范围中，我们可以创建一个辅助数组。且都赋值为0。
//	遍历数组，将元素复制到辅助数组内。
//	若元素值为m：则往辅助元素下标为m的位置上赋1；
//	题中只要求得到一个重复的数字，我们可以用char[]来担任辅助数组
//	时间复杂度O(1),空间复杂度O(n)
	public int demo1(int[] datas) {
		
		char[] temp ;
		
		//判非空
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//判断数组元素是否在1-n之间
		for(int data : datas) {
			if(1 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//实例化一个char[]辅助数组
		temp = new char[datas.length];
		
		//遍历数组
		for(int data : datas) {
			
			if( temp[data] == 1 ) {
				return data ;
			}
			temp[data] = 1 ;	
		}
		
		return -1;
	}
	
	//思路二：
	//已知数据都是在1-n之间且有n+1个数，我们可以取中间值m,将其分为1 - m,m+1 - n;
	//如果1-m 中的数量大于m那么说明在1-m区间内肯定有重复的值。
	//反之说明，在m+1 - n之间肯定有重复的值。
	//然后再以确定有重复值的区间，作为大区间，并对其进行二分区重复，直到找到重复值。
	//空间复杂度O(1)时间复杂度O(logn)
	public int demo2(int[] datas) {
		
		int star = 0 ;
		int end = 0 ;
		int mid = 0 ;
		int starId = 0 ;
		int endId = 0 ;
		
		//判非空
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//判断数组元素是否在1-n之间
		for(int data : datas) {
			if(1 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//定义第一次查找时的大区间
		star = 1 ;
		end = datas.length-1 ;
		
		//直到star == end为止，一直循环
		while(true) {
			mid = (star+end)/2 ;
			
			for(int data : datas) {
				if(data < mid) {
					starId ++ ;
				}else {
					endId ++ ;
				}
			}
			
			//比较判断哪个区间有重复值，确定新的区间
			if(starId > mid) {
				//当mid==end时往前移动一个
				if(mid == end) {
					mid-- ;
				}
				end = mid ;
			}else {
				if(mid == star) {
					mid++ ;
				}
				star = mid ;
			}
		
			starId = 0 ;
			endId = 0 ;
		
			if(star == end) {
				return star ;
			}
		}
		
	}
	
public static void main(String[] args) {
		
		int[] datas1 = {3,2,1,4,5,2,1,7} ;
		int[] datas2 = null ;
		int[] datas3 = {1,2,3,4,5,6,6};
		int[] datas4 = {1,12,15,46} ;
		int result = 0 ;
		
		Demo d1 = new Demo() ;
		result = d1.demo1(datas1) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		result = d1.demo1(datas2) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		result = d1.demo1(datas3) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		result = d1.demo1(datas4) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		
		result = d1.demo2(datas1) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		result = d1.demo2(datas2) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		result = d1.demo2(datas3) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		result = d1.demo1(datas4) ;
		System.out.println((result == -1)? "数组为空或者不符合规范" : ((result == -2) ? "数组中不存在重复值":"重复的第一个数字是："+ result) );
		
	}
	
}
