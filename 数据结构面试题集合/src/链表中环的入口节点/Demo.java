package �����л�����ڽڵ�;

import java.util.EmptyStackException;

import ɾ������Ľڵ�.ListNode;

/**
 * ��ĿҪ��
 * �ҵ������еĻ�����ڽڵ�
 *
 */
public class Demo {

	//˼·һ��
	//Ҫ�õ������еĻ�����ڽڵ㣬��ô����������Ҫȷ���������Ƿ���ڻ���
	//��һ�����ǿ��Խ���������ָ�������飬����ʹ������ָ��ͬʱ��ͷ��������ָ��Aһ����������ָ��Bһ����һ��
	//����ָ�����������ô���ǿ���ȷ�����ڻ��������ڱ��������дﵽ������β�ڵ㣬��ô���ǿ��Զ϶�û�л���
	//������ڻ�����ô������һ���ڻ��ڣ����ǿ�����ĳһ��ָ�����������������ٴε������������ߵĲ������ǻ��ڽڵ�������
	//��֪������Ϣ�����ǿ���Ѱ�һ��������
	//����õ��Ļ��ڽڵ���n,��ô�����������ڵ㣬����һ������n����Ȼ������һ��������������ڵ�����ʱ����ô��������ǻ���ڡ�
	public static ListNode getBeginOfSycle(ListNode head) throws Exception {
		
		ListNode a ;
		ListNode b ;
		int count = 0 ;
		int nodeNumOfSycle = 0 ;
		
		boolean hasSycle = false ;
		
		if(head == null) {
			return null ;
		}
		
		a = head ;
		b = head ;
		
		//�ж��Ƿ��л�����
		while( b != null && b.getNext() !=null ) {
			b = b.getNext().getNext() ;
			a = a.getNext() ;
			
			if(b == a) {
				hasSycle = true ;
				break ;
			}
		}
		
		//�����ڻ��׳��쳣
		if(!hasSycle) {
			throw new Exception("�����в����ڻ�") ;
		}
		
		//���㻷�нڵ�����
		nodeNumOfSycle = 1 ;
		b = b.getNext() ;
		while( a != b ) {
			b = b.getNext() ;
			nodeNumOfSycle ++ ;
		}
		
		//�ҵ������
		a = head ;
		b = head ;
		//��a����
		for(int i = 0 ; i < nodeNumOfSycle ; i++) {
			a = a.getNext() ;
		}
		
		while(a!=b) {
			a = a.getNext() ;
			b = b.getNext() ;
		}
		
		return a;
	}
	
	
	public static void main(String[] args) throws Exception {
		ListNode node1 = new ListNode() ;
		ListNode node2 = new ListNode() ;
		ListNode node3 = new ListNode() ;
		ListNode node4 = new ListNode() ;
		ListNode node5 = new ListNode() ;
		
		node1.setValue(1);
		node2.setValue(2);
		node3.setValue(3);
		node4.setValue(4);
		node5.setValue(5);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node3);
		
		System.out.println(getBeginOfSycle(node1).getValue());
		
		node5.setNext(null);
		
		System.out.println(getBeginOfSycle(node1).getValue());
	}
	
}
