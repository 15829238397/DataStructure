package 쳲���������;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * ��ĿҪ��
 * ��쳲��������еĵ�n�
 *
 */

public class Demo {

	private static Map<Integer , Integer> result = new HashMap<>() ;
	
	//˼·һ��
	//쳲��������еĵ�n��ļ��������һ����׼�ĵݹ�
	public static int getValue(int n) throws Exception {
		
		if(n < 0) {
			throw new Exception("�������С��0 �����Ϸ�������") ;
		}
		
		if(n <= 1) {
			return (n==1) ? 1: 0 ;
		}
		
		return getValue( n-1 ) + getValue( n-2 ) ;
		
	}
	
	//˼·����
	//쳲��������еĵ�n��ļ��������һ����׼�ĵݹ�
	//�½�һ������Լ��������д洢���´μ���ʽ�����������н��в�ѯ�����������ٽ��м��㡣
	
	
	public static int getValue1(int n) throws Exception {
		
		if(n < 0) {
			throw new Exception("�������С��0 �����Ϸ�������") ;
		}
		
		if(n <= 1) {
			return (n==1) ? 1: 0 ;
		}
		
		if(result.get(n)!=null) {
			return result.get(n) ;
		}else {
			result.put(n, getValue( n-1 ) + getValue( n-2 )) ;
		}
		
		
		return result.get(n) ;
		
	}
		
	
	//����
	public static void main(String[] args) {
		
		try {
			
			System.out.println("δ�Ż�");
			long curTime = System.nanoTime() ;
			System.out.println(getValue(5));
			System.out.println(System.nanoTime() - curTime);
			
			System.out.println("-----------------------------------");
			
			System.out.println("�Ż�");
			curTime = System.nanoTime() ;
			System.out.println(getValue1(5));
			System.out.println(System.nanoTime() - curTime);
			
			System.out.println("-----------------------------------");
			System.out.println("δ�Ż�");
			curTime = System.nanoTime() ;
			System.out.println(getValue(30));
			System.out.println(System.nanoTime() - curTime);
			
			System.out.println("-----------------------------------");
			System.out.println("�Ż�");
			curTime = System.nanoTime() ;
			System.out.println(getValue1(30));
			System.out.println(System.nanoTime() - curTime);
			
			
			
			System.out.println(getValue1(-1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
