package ��������1�ĸ���;

/**
 * 
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������磺��9��ʾ�ɶ�������1001����ô�������2
 *
 */
public class Demo {

	//˼·һ��
	//����n==0;��ô�����Ʊ�ʾ�б�Ȼ����1��
	//���ǿ��Է��ֵ����Ǹ�һ������-1ʱ��������������Ʊ�ʾ���������1����Ϊ0�������ұ������0��ȫ��Ϊ1��
	//��ʱ���ǽ�(n-1) & n ������ֱ���������������1��
	//�ظ���n==0��ѭ��������Ϊ1�ĸ�����
	public static int getNumOfOne(int n) {
		
		int num = 0 ;
		
		while(n!=0) {
			num ++ ;
			n = (n-1) & n ;
		}
		
		return num ;
	}
	
	//���Դ���
	public static void main(String[] args) {
		System.out.println(getNumOfOne(9));
		System.out.println(getNumOfOne(1));
		System.out.println(getNumOfOne(0x7fffffff));
		System.out.println(getNumOfOne(0xffffffff));
		System.out.println(getNumOfOne(0x80000000));
		System.out.println(getNumOfOne(0));
		System.out.println(getNumOfOne(-5));
	}
	
}
