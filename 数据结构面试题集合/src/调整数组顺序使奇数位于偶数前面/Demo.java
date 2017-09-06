package 调整数组顺序使奇数位于偶数前面;

/**
 * 
 * 输入一个整数数组，实现一个函数来调整数组中的数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
 *
 */
public class Demo {

	//思路一：
	//题目要求我们把所有奇数放在偶数面前，那么我们可以借助两个辅助下标进行性作业。
	public static int[] reorder(int[] nums) {
		
		int leftIndex = 0;
		int rightIndex = 0 ;
		int temp = 0 ;
		
		if(nums == null || nums.length == 0) {
			return null ;
		}
		
		rightIndex = nums.length - 1 ;
		
		while( leftIndex < rightIndex ) {
			
			//找到左边第一个偶数
			while(leftIndex < rightIndex && (nums[leftIndex] & 0x1) == 1) {
				leftIndex ++ ;
			}
			
			//找到右边第一个偶数
			while(rightIndex > leftIndex && (nums[rightIndex] & 0x1) != 1) {
				rightIndex -- ;
			}
			
			//两个坐标重合，排序完毕
			if(leftIndex == rightIndex) {
				return nums ;
			}
			
			//交换偶数和奇数
			temp = nums[leftIndex] ;
			nums[leftIndex] = nums[rightIndex] ;
			nums[rightIndex] = temp ;
		
			leftIndex ++ ;
			rightIndex -- ;
			
		}
		
		return nums ;
	}
	
	public static void show(int[] nums) {
		
		if(nums == null) {
			System.out.println();
			return ;
		}
		
		for(int i = 0 ; i < nums.length ; i++) {
			System.out.print(" " + nums[i]);
		}
		
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		int [] nums1 = {1,2,3,4,5,6,7} ;
		int [] nums2 = {1,22,2,5,4,3};
		int [] nums3 = null ;
		int [] nums4 = {} ;
		int [] nums5 = {1,3,5,7,9} ;
		int [] nums6 = {2,4,6,8,10} ;
		int [] nums7 = {1} ;
		
		
		show(reorder(nums1));
		show(reorder(nums2));
		show(reorder(nums3));
		show(reorder(nums4));
		show(reorder(nums5));
		show(reorder(nums6));
		show(reorder(nums7));
		
	}
	
}
