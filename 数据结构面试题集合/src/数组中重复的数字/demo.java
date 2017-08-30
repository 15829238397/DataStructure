package �������ظ�������;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * ��ĿҪ��
 * 		��һ������Ϊn������������������0-n֮�䣬�����д����ظ�������
 * ���ǲ�֪�����������ظ��ˣ�Ҳ��֪�������ظ��˼��Σ����ҳ�����������һ���ظ������֡�
 * 
 * 
 */

public class demo {

	//˼·һ��
	//����hashMap��keyֵֻ�ܴ���һ�����ص㡣�������е���������ֵ��Ϊ��keyֵ����������洢
	//�ڴ洢֮ǰ����֮ǰ��û���Դ�ֵΪkey�ļ�ֵ�ԣ�����У�����Եõ��ظ��ĵ�һ�����֡�
	//�ŵ㣬ʱ�临�Ӷȵ�O(1)�����ֻ��Ҫ����n�δ洢��
	//ȱ�㣬�ռ临�ӶȽϸ�O(n)
	//������Ŀ˵�������ݴ���0,�������ǿ���ʹ��-1��Ϊ������
	
	public int demo1( int[] datas) {
		
		Map<Integer , Integer> dataMap = new HashMap<>();
		
		//�зǿ�
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//��ѯ�����Ƿ�淶
		for(int data : datas) {
			if(0 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//�õ������ص�һ���ظ�ֵ
		for(int data : datas) {
			if(dataMap.get(data) != null) {
				return data ;
			}
			
			dataMap.put(data, data) ;
		}
		
		//�����в������ظ�ֵ
		return -2;
	}
	
//	˼·����
//	�����ᵽ�������е�������0-n֮�䣬��Ȼ�������飬��ô���ǾͿ������������±�������¡�
//	��0��ʼ�������飬���±�Ϊi���±�Ϊi�����ֵ�ֵ��m��
//	���i==m������һ����
//	���i!=m�������±�Ϊm��ֵ������m�Ƚϣ�����ͬ����mΪ��һ���ظ���ֵ������ͬ�����±�Ϊi��ֵ���±�Ϊm��ֵ�໥������
//	�����Աȴ�ʱi��m���ظ����ϣ�ֱ���ҵ���һ���ظ�ֵ��
//	������Ŀ˵�������ݴ���0,�������ǿ���ʹ��-1��Ϊ������
//	ʱ�临�Ӷ�ΪO(n),�ռ临�Ӷ�ΪO(1)
	
	public int demo2( int[] datas) {
		
		//�зǿ�
		if(datas == null || datas.length == 0) {
			return -1 ;
		}
		
		//��ѯ�����Ƿ�淶
		for(int data : datas) {
			if(0 > data || data > datas.length-1) {
				return -1 ;
			}
		}
		
		//����ѭ������
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
		
		//�����в������ظ�ֵ
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
