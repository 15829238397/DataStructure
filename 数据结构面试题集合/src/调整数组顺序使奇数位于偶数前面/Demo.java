package ��������˳��ʹ����λ��ż��ǰ��;

/**
 * 
 * ����һ���������飬ʵ��һ�����������������е����ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֡�
 *
 */
public class Demo  {

	//˼·һ��
	//��ĿҪ�����ǰ�������������ż����ǰ����ô���ǿ��Խ������������±��������ҵ��
	public static int[] reorder(int[] nums) {
		
		int leftIndex = 0;
		int rightIndex = 0 ;
		int temp = 0 ;
		
		if(nums == null || nums.length == 0) {
			return null ;
		}
		
		rightIndex = nums.length - 1 ;
		
		while( leftIndex < rightIndex ) {
			
			//�ҵ���ߵ�һ��ż��
			while(leftIndex < rightIndex && (nums[leftIndex] & 0x1) == 1) {
				leftIndex ++ ;
			}
			
			//�ҵ��ұߵ�һ��ż��
			while(rightIndex > leftIndex && (nums[rightIndex] & 0x1) != 1) {
				rightIndex -- ;
			}
			
			//���������غϣ��������
			if(leftIndex == rightIndex) {
				return nums ;
			}
			
			//����ż��������
			temp = nums[leftIndex] ;
			nums[leftIndex] = nums[rightIndex] ;
			nums[rightIndex] = temp ;
		
			leftIndex ++ ;
			rightIndex -- ;
			
		}
		
		return nums ;
	}
	
	//˼·��:
	//���ǿ��Խ��������ж�����(nums[leftIndex] & 0x1) == 1��ȡ����������һ�����ǾͿ������һЩ���Ƶ����⣬
	//������������ڸ���ǰ�棬
	//�Ѵ�д��ĸ����Сд��ĸǰ��
	//�½�һ���ӿڣ����ӿ����жϵķ�������������ȥʵ�֡�
	public static int[] reorder1(int[] nums , IreOrder<int []> o) {
		
		int leftIndex = 0;
		int rightIndex = 0 ;
		int temp = 0 ;
		
		if(nums == null || nums.length == 0) {
			return null ;
		}
		
		rightIndex = nums.length - 1 ;
		
		while( leftIndex < rightIndex ) {
			
			//�ҵ���ߵ�һ��ż��
			while(leftIndex < rightIndex && o.judgeLeft(nums , leftIndex)) {
				leftIndex ++ ;
			}
			
			//�ҵ��ұߵ�һ��ż��
			while(rightIndex > leftIndex && !o.judgeLeft(nums , rightIndex)) {
				rightIndex -- ;
			}
			
			//���������غϣ��������
			if(leftIndex == rightIndex) {
				return nums ;
			}
			
			//����ż��������
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
		
		System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
		
		IreOrder<int[]> o = (int[] nums , int leftIndex)->{
			return (nums[leftIndex] & 0x1) == 1 ;
		} ;
		
		show(reorder1(nums1 , o));
		show(reorder1(nums2 , o));
		show(reorder1(nums3 , o));
		show(reorder1(nums4 , o));
		show(reorder1(nums5 , o));
		show(reorder1(nums6 , o));
		show(reorder1(nums7 , o));
		
	}

	
	
}
