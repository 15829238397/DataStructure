package 二维数组中的查找;

/**
 * 
 * 题目：
 * 在一个二维数组中，每一行都会按照从左至右递增的规律排列，每一列都会按照从上到下递增的规律排列。
 * 请完成一个函数，输入一个二维数组与一个整数，判断数组中是否有该整数
 * 
 */

public class Demo {

	//思路一：
//	已知二位数组的元素分布规律，可以知道对于右上角的元素m来说，同行左边所有的元素都小于该元素，同列下面的元素都大于该元素。
//	于是，我们选择取右上角的元素m与查找元素n比较，若是m>n,则可以排除m所属的那一列,若m<n,则可以排除m所属的那一行,若是m=n则直接返回ture
//	循环上一步，直至找到，或者查找完整个二维数组。
	public boolean demo1(int[][] datas , int data) {
		
		//判非空
		if(datas == null || datas.length == 0) {
			return false ;
		}
		
		int row = 0 ;
		int col = datas[0].length-1 ;
		
		//开始查找
		while( row >= 0 && col >= 0 ) {
			
			if( datas[row][col] == data ) {
				return true ;
			}else if( datas[row][col] > data ) {
				col -- ;
			}else if( datas[row][col] < data ) {
				row ++ ;
			}
		}
		
		return false ;
		
	}
	
	public static void main(String[] args) {
		
		int[][] datas = {{1,2,8,9},
						 {2,4,9,12},
						 {4,7,10,13},
						 {6,8,11,15}} ;
		
		Demo d1 = new Demo() ;
		System.out.println(d1.demo1(datas, 7));
		
		System.out.println(d1.demo1(datas, 0)) ;
		
	}
	
}
