package ����ջʵ��һ������;

import java.util.Stack;

/**
 * ��ĿҪ��
 * 
 * ������ջʵ��һ�����С����е��������£���ʵ��������������
 * appenfTail ��deleteHead���ֱ������Ϊ�ڵ���Ӻ��ڶ���ͷ��ɾ������
 */


public class Demo<T> {

	//��Ŀ������
//	��������stack���ݶ�ΪAջ , Bջ
//	��ѹ��Ԫ��ʱ�����ǽ�Ԫ�ض�ѹ��Aջ��
//	����Ҫɾ������ͷԪ��ʱ�����ǿ��Խ�Aջ��Ԫ��ȫ��ȡ����ѹ��Bջ��
//	��ʱBջ�е�ջ��Ԫ�ؾ������ѹ���Ԫ�ء�Ҫɾ���Ļ����׳�ջ��Ԫ�ؼ���
//	����������ɾ����β����Ҫ�ж�BջΪ�գ������Ϊ����ôֱ���׳�ջ��Ԫ�ء�
//	���Ϊ�գ���AջԪ��һһ�׳���ѹ��Bջ
	
	private Stack<T> appendStack = new Stack<T>() ;
	private Stack<T> deleteStack = new Stack<T>() ;
	
	public void appendfTail(T t) {
		
		appendStack.push(t) ;
		
	}
	
	public T deleteHead() throws Exception {
		
		if(deleteStack.isEmpty()) {
			while(!appendStack.isEmpty()) {
				deleteStack.push(appendStack.pop()) ;
			}
		}
		
		if(deleteStack.isEmpty()) {
			throw new Exception("����Ϊ�� �� ����ɾ��") ;
		}
		
		return deleteStack.pop() ;
		
	}
	
	public static void main(String[] args) {
		
		Demo<String> demo = new Demo<>() ;
		
		demo.appendfTail("��");
		demo.appendfTail("��");
		demo.appendfTail("ѧ");
		demo.appendfTail("ϰ");
		
		for(int i = 0 ; i < 4 ; i++) {
			
			try {
				System.out.println(demo.deleteHead());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		System.out.println("------------------------------------");
		
		try {
			System.out.println(demo.deleteHead());
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
			
	}
	
}
