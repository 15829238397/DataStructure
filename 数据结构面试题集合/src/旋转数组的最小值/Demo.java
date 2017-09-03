package 旋转数组的最小值;

import java.util.Arrays;

/**
 * 题目要求：
 * 旋转数组是指将数组的元素逐个移动至数组尾部。
 * 现在有一个递增的数组，将数组旋转后，求数组的最小值。
 *
 */
public class Demo {
	
	//思路一：
//	首先确定数组是不是所有元素都一样。或者是不是根本没有旋转。
//	利用二分法，取中间的数字m与下标为0的数字n比较。
//	如果data[m]>=data[n]，则说明m不是被旋转过去的部分。那么我们可以将0-m全部舍弃。
//	如果data[m]>data[m-1]，则说明n是被旋转过去的部分。那么我们可以将m-data.length右边界全部舍弃。
//	重复上述：完成查找。
	
	public static int getminiData(int[] data) throws Exception {
		
		if(data == null || data.length == 0) {
			throw new Exception("data为空，参数不合法") ;
		}
		
		int miniData = data[0];
		int leftIndex = 0 ;
		int rightIndex = data.length - 1 ;
		int midIndex = ( leftIndex + rightIndex )/2 ;
		
		if(data[leftIndex] < data[rightIndex]) {
			return data[leftIndex] ;
		}
		
		//如果左右边和中点都相等就用顺序查找。
		if(data[leftIndex] == data[rightIndex] 
				&& data[leftIndex] == data[midIndex] 
				&& data[rightIndex] == data[midIndex]) {
			for(int i = 0 ; i < data.length ; i++) {
				miniData = (miniData < data[i]) ? miniData : data[i] ;
			}
			
			return miniData ;
		}
		
		//比较中间值与两边的值比较，得到最小值
		while(data[midIndex] > data[leftIndex] || (midIndex != 0 && data[midIndex] > data[midIndex-1])) {
			
			if(data[midIndex] > data[leftIndex]) {
				leftIndex = midIndex+1 ;
				midIndex = ( leftIndex + rightIndex )/2 ;
			}
			
			if(data[midIndex] > data[midIndex-1]){
				rightIndex = midIndex-1 ;
				midIndex = ( leftIndex + rightIndex )/2 ;
			}
			
		}
		
		return data[midIndex] ;
		
	}
	
	public static void main(String[] args) {
	
		int[] data = {3,4,5,1,2} ;
		int[] data1 = {0,1,1,1,1} ;
		int[] data2 = {1,0,1,1,1} ;
		int[] data3 = {7} ;
		
		try {
			System.out.println(getminiData(data));
			System.out.println(getminiData(data1));
			System.out.println(getminiData(data2));
			System.out.println(getminiData(data3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
