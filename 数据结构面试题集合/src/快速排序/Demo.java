package 快速排序;

import java.util.Arrays;

public class Demo {

	
	//快速排序
//	首先选择一个枢轴值，和两个下标值分别为low和high。
//	首先比较是否枢纽值与low下标所代表的值的大小，如果大于，那么检查low+1的值。
//	如果小于的话将low的值移动至数组右侧。
//	然后比较是否枢纽值与high下标所代表的值的大小，如果小于，那么检查high-1的值。
//	如果小于的话将low的值移动至数组左侧。
//	再分别在分开的两个区间进行快速排序
	public static int[] order(int[] data) {
		
		if(data == null || data.length == 0) {
			return null ;
		}
		
		//确定中间值为枢轴值
		int tempId = (data.length - 1 + 0 ) / 2 ;
		int temp = data[(data.length - 1 + 0 ) / 2] ;
		
		int low = 0 ;
		int high = data.length-1 ;
		
		//移动元素完成一波快速排序
		while(low < high) {
			while(low < tempId && data[low] <= temp) {
				low ++ ;}
			data[tempId] = data[low] ;
			tempId = low ;
			low++ ;
			while(tempId < high && data[high] >= temp) {
				high -- ;}
			data[tempId] = data[high] ;
			tempId = high ;
			high-- ;
		}
		
		data[tempId] = temp ;
		
		//处理枢轴左边的数组区间
		if(tempId > 0) {
			int[] leftData = order(Arrays.copyOfRange(data, 0 , tempId)) ;
			
			for(int i = 0 ; i < tempId ; i++ ) {
				data[i] = leftData[i] ;
			}
		}
		//处理枢轴右边的数组区间
		if(tempId+1 < data.length ) {
			int[] rightData = order(Arrays.copyOfRange(data, tempId+1 , data.length)) ;
			
			for(int i = tempId+1 ; i < data.length ; i++) {
				data[i] = rightData[i - (tempId+1)] ;
			}
		}
		
		return data ;
		
	}
	
	//测试代码
	public static void main(String[] args) {
		
		int[] data = {46,68,12,25,33,80,19,33} ;
		
		System.out.println("排序前");
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print( data[i] + ((i==data.length-1) ? "":",") );
		}
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("排序后");
		data = order(data) ;
		if(data != null)
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print( data[i] + ((i==data.length-1) ? "":",") );
		}
		
	}
	
}
