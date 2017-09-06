package �����е�����K���ڵ��ֵ;

import ɾ������Ľڵ�.ListNode;

/**
 * ��ĿҪ��
 * ������һ������Ҫ��õ�������K�ڵ��ֵ��
 *
 */
public class Demo {

	//˼·������
	//��ĿҪ��õ�������k��ֵ����ô���ǿ���ѡ��һ���������棬����������
	//��������λ�õ����k����ʱ�򣬽�ͷ�����븨�����棬�Ӵ������һͬǰ����
	//��������β�ڵ��ʱ�򣬸���������ǵ�����k����
	public static int getReverseOrderOfK(ListNode listNode , int k) throws Exception {
		
		ListNode temp = listNode ;
		int count = 0 ;
		
		if(k<0) {
			throw new Exception("����ֵ����Ϊ����") ;
		}
		
		if(listNode == null ) {
			throw new Exception("����Ϊ��") ;
		}
		
		while(listNode != null && listNode.getNext() != null ) {
			
			listNode = listNode.getNext() ;
			count ++ ;
			if( count > k -1 ) {
				temp = temp.getNext() ;
			}
			System.out.println(temp.getValue() + "��" + listNode.getValue());
		}
		
		if(count < k-1 ) {
			throw new Exception("������С��" + k) ;
		}
		
		return temp.getValue()  ;
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
		
		System.out.println(getReverseOrderOfK(node1 , 3));
		System.out.println(getReverseOrderOfK(node1 , 5));
		System.out.println(getReverseOrderOfK(node1 , 0));
		System.out.println(getReverseOrderOfK(node1 , 6));
		
	}
	
	
}
