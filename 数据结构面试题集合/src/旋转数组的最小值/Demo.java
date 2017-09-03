package ��ת�������Сֵ;

import java.util.Arrays;

/**
 * ��ĿҪ��
 * ��ת������ָ�������Ԫ������ƶ�������β����
 * ������һ�����������飬��������ת�����������Сֵ��
 *
 */
public class Demo {
	
	//˼·һ��
//	����ȷ�������ǲ�������Ԫ�ض�һ���������ǲ��Ǹ���û����ת��
//	���ö��ַ���ȡ�м������m���±�Ϊ0������n�Ƚϡ�
//	���data[m]>=data[n]����˵��m���Ǳ���ת��ȥ�Ĳ��֡���ô���ǿ��Խ�0-mȫ��������
//	���data[m]>data[m-1]����˵��n�Ǳ���ת��ȥ�Ĳ��֡���ô���ǿ��Խ�m-data.length�ұ߽�ȫ��������
//	�ظ���������ɲ��ҡ�
	
	public static int getminiData(int[] data) throws Exception {
		
		if(data == null || data.length == 0) {
			throw new Exception("dataΪ�գ��������Ϸ�") ;
		}
		
		int miniData = data[0];
		int leftIndex = 0 ;
		int rightIndex = data.length - 1 ;
		int midIndex = ( leftIndex + rightIndex )/2 ;
		
		if(data[leftIndex] < data[rightIndex]) {
			return data[leftIndex] ;
		}
		
		//������ұߺ��е㶼��Ⱦ���˳����ҡ�
		if(data[leftIndex] == data[rightIndex] 
				&& data[leftIndex] == data[midIndex] 
				&& data[rightIndex] == data[midIndex]) {
			for(int i = 0 ; i < data.length ; i++) {
				miniData = (miniData < data[i]) ? miniData : data[i] ;
			}
			
			return miniData ;
		}
		
		//�Ƚ��м�ֵ�����ߵ�ֵ�Ƚϣ��õ���Сֵ
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
