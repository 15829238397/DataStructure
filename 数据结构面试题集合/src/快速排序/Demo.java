package ��������;

import java.util.Arrays;

public class Demo {

	
	//��������
//	����ѡ��һ������ֵ���������±�ֵ�ֱ�Ϊlow��high��
//	���ȱȽ��Ƿ���Ŧֵ��low�±��������ֵ�Ĵ�С��������ڣ���ô���low+1��ֵ��
//	���С�ڵĻ���low��ֵ�ƶ��������Ҳࡣ
//	Ȼ��Ƚ��Ƿ���Ŧֵ��high�±��������ֵ�Ĵ�С�����С�ڣ���ô���high-1��ֵ��
//	���С�ڵĻ���low��ֵ�ƶ���������ࡣ
//	�ٷֱ��ڷֿ�������������п�������
	public static int[] order(int[] data) {
		
		if(data == null || data.length == 0) {
			return null ;
		}
		
		//ȷ���м�ֵΪ����ֵ
		int tempId = (data.length - 1 + 0 ) / 2 ;
		int temp = data[(data.length - 1 + 0 ) / 2] ;
		
		int low = 0 ;
		int high = data.length-1 ;
		
		//�ƶ�Ԫ�����һ����������
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
		
		//����������ߵ���������
		if(tempId > 0) {
			int[] leftData = order(Arrays.copyOfRange(data, 0 , tempId)) ;
			
			for(int i = 0 ; i < tempId ; i++ ) {
				data[i] = leftData[i] ;
			}
		}
		//���������ұߵ���������
		if(tempId+1 < data.length ) {
			int[] rightData = order(Arrays.copyOfRange(data, tempId+1 , data.length)) ;
			
			for(int i = tempId+1 ; i < data.length ; i++) {
				data[i] = rightData[i - (tempId+1)] ;
			}
		}
		
		return data ;
		
	}
	
	//���Դ���
	public static void main(String[] args) {
		
		int[] data = {46,68,12,25,33,80,19,33} ;
		
		System.out.println("����ǰ");
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print( data[i] + ((i==data.length-1) ? "":",") );
		}
		
		System.out.println();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("�����");
		data = order(data) ;
		if(data != null)
		for(int i = 0 ; i < data.length ; i++) {
			System.out.print( data[i] + ((i==data.length-1) ? "":",") );
		}
		
	}
	
}
