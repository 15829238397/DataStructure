package ��ά�����еĲ���;

/**
 * 
 * ��Ŀ��
 * ��һ����ά�����У�ÿһ�ж��ᰴ�մ������ҵ����Ĺ������У�ÿһ�ж��ᰴ�մ��ϵ��µ����Ĺ������С�
 * �����һ������������һ����ά������һ���������ж��������Ƿ��и�����
 * 
 */

public class Demo {

	//˼·һ��
//	��֪��λ�����Ԫ�طֲ����ɣ�����֪���������Ͻǵ�Ԫ��m��˵��ͬ��������е�Ԫ�ض�С�ڸ�Ԫ�أ�ͬ�������Ԫ�ض����ڸ�Ԫ�ء�
//	���ǣ�����ѡ��ȡ���Ͻǵ�Ԫ��m�����Ԫ��n�Ƚϣ�����m>n,������ų�m��������һ��,��m<n,������ų�m��������һ��,����m=n��ֱ�ӷ���ture
//	ѭ����һ����ֱ���ҵ������߲�����������ά���顣
	public boolean demo1(int[][] datas , int data) {
		
		//�зǿ�
		if(datas == null || datas.length == 0) {
			return false ;
		}
		
		int row = 0 ;
		int col = datas[0].length-1 ;
		
		//��ʼ����
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
