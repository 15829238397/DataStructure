package ���޸������ҳ��ظ�������;

import �������ظ�������.demo;

/**
 * 
 * ��һ������Ϊn+1�����������е����ֶ���1-n�ķ�Χ֮�У�����������������һ���������ظ��ġ�
 * ���ҳ�����������һ���ظ������֣��������޸��޸���������顣 
 * 
 */

public class Demo {

//	˼·һ��
//	���ڵ�֪�����е����ֶ���1-n�ķ�Χ�У����ǿ��Դ���һ���������顣�Ҷ���ֵΪ0��
//	�������飬��Ԫ�ظ��Ƶ����������ڡ�
//	��Ԫ��ֵΪm����������Ԫ���±�Ϊm��λ���ϸ�1��
//	����ֻҪ��õ�һ���ظ������֣����ǿ�����char[]�����θ�������
//	ʱ�临�Ӷ�O(1),�ռ临�Ӷ�O(n)
	public int demo1(int[] datas) {
		
		char[] temp ;
		
		//�зǿ�
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//�ж�����Ԫ���Ƿ���1-n֮��
		for(int data : datas) {
			if(1 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//ʵ����һ��char[]��������
		temp = new char[datas.length];
		
		//��������
		for(int data : datas) {
			
			if( temp[data] == 1 ) {
				return data ;
			}
			temp[data] = 1 ;	
		}
		
		return -1;
	}
	
	//˼·����
	//��֪���ݶ�����1-n֮������n+1���������ǿ���ȡ�м�ֵm,�����Ϊ1 - m,m+1 - n;
	//���1-m �е���������m��ô˵����1-m�����ڿ϶����ظ���ֵ��
	//��֮˵������m+1 - n֮��϶����ظ���ֵ��
	//Ȼ������ȷ�����ظ�ֵ�����䣬��Ϊ�����䣬��������ж������ظ���ֱ���ҵ��ظ�ֵ��
	//�ռ临�Ӷ�O(1)ʱ�临�Ӷ�O(logn)
	public int demo2(int[] datas) {
		
		int star = 0 ;
		int end = 0 ;
		int mid = 0 ;
		int starId = 0 ;
		int endId = 0 ;
		
		//�зǿ�
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//�ж�����Ԫ���Ƿ���1-n֮��
		for(int data : datas) {
			if(1 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//�����һ�β���ʱ�Ĵ�����
		star = 1 ;
		end = datas.length-1 ;
		
		//ֱ��star == endΪֹ��һֱѭ��
		while(true) {
			mid = (star+end)/2 ;
			
			for(int data : datas) {
				if(data < mid) {
					starId ++ ;
				}else {
					endId ++ ;
				}
			}
			
			//�Ƚ��ж��ĸ��������ظ�ֵ��ȷ���µ�����
			if(starId > mid) {
				//��mid==endʱ��ǰ�ƶ�һ��
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
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		result = d1.demo1(datas2) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		result = d1.demo1(datas3) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		result = d1.demo1(datas4) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		
		result = d1.demo2(datas1) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		result = d1.demo2(datas2) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		result = d1.demo2(datas3) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		result = d1.demo1(datas4) ;
		System.out.println((result == -1)? "����Ϊ�ջ��߲����Ϲ淶" : ((result == -2) ? "�����в������ظ�ֵ":"�ظ��ĵ�һ�������ǣ�"+ result) );
		
	}
	
}
