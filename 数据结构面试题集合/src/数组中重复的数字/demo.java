package 数组中重复的数字;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * 题目要求：
 * 		在一个长度为n的数组里所有数都在0-n之间，数组中存在重复的数，
 * 但是不知道几个数字重复了，也不知道数字重复了几次，请找出数组中任意一个重复的数字。
 * 
 * 
 */

public class demo {

	//思路一：
	//利用hashMap，key值只能存在一个的特点。将数组中的数字以其值作为其key值，进行逐个存储
	//在存储之前查找之前有没有以此值为key的键值对，如果有，则可以得到重复的第一个数字。
	//优点，时间复杂度低O(1)，最多只需要进行n次存储。
	//缺点，空间复杂度较高O(n)
	//由于题目说明了数据大于0,所以我们可以使用-1作为错误标记
	
	public int demo1( int[] datas) {
		
		Map<Integer , Integer> dataMap = new HashMap<>();
		
		//判非空
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//查询数据是否规范
		for(int data : datas) {
			if(0 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//得到并返回第一个重复值
		for(int data : datas) {
			if(dataMap.get(data) != null) {
				return data ;
			}
			
			dataMap.put(data, data) ;
		}
		
		//数组中不存在重复值
		return -2;
	}
	
//	思路二：
//	题中提到，数组中的数都在0-n之间，既然他是数组，那么我们就可以利用数组下标进行文章。
//	从0开始遍历数组，设下标为i，下标为i的数字的值是m。
//	如果i==m遍历下一个。
//	如果i!=m，查找下标为m的值，并与m比较，若相同，则m为第一个重复的值，若不同，将下标为i的值与下标为m的值相互调换。
//	继续对比此时i与m，重复以上，直到找到第一个重复值。
//	由于题目说明了数据大于0,所以我们可以使用-1作为错误标记
//	时间复杂度为O(n),空间复杂度为O(1)
	
	public int demo2( int[] datas) {
		
		//判非空
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//查询数据是否规范
		for(int data : datas) {
			if(0 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//进行循环查找
		for(int temp , m , i = 0 ; i < datas.length ; ) {
			m = datas[i] ;
			
			if(m == i) {
				i++;
				continue ;
			}else if(m == datas[m]){
				return m ;
			}else if(m!= datas[m]) {
				temp = datas[i] ;
				datas[i] = datas[m];
				datas[m] = temp ;
			}
		}
		
		//数组中不存在重复值
		return -2 ;
	}
	
	public static void main(String[] args) {
		
		int[] datas1 = {3,2,1,4,5,2,1,7} ;
		int[] datas2 = null ;
		int[] datas3 = {1,2,3,4,5,0};
		int[] datas4 = {1,12,15,46} ;
		int result = 0 ;
		
		demo d1 = new demo() ;
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
