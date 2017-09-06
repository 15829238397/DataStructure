package ɾ���ظ��Ľڵ�;

import ɾ������Ľڵ�.ListNode;

/**
 * ��ĿҪ��
 * ɾ���������ظ��Ľڵ㡣
 * �ظ��Ľڵ㣺
 * ��ǰ�ڵ��ֵ����һ���ڵ��ֵ��ȣ���ô���������ڵ�Ϊ�ظ��Ľڵ�
 * 
 */
public class Demo {
	
	//˼·һ
	//	���������Ϊ2��3��3��4��4��5
	//	ɾ�����֮���Ϊ2��5
	//	��ô�����2��2��5��6
	//	ɾ�����֮���Ϊ5��6�����ʱ����Ҫ�ı�ͷ��㣬�������Ǳ��뷵���µ�ͷ���
	//	���⻹��Ҫ���ǵ��������2��2��2
	//	��ôɾ�����֮������Ϊ�ա�
	//	���������ϣ���������������ζ��ظ��Ľڵ����ɾ����
	//	���ȴ�ͷ��㿪ʼ��������鵱ǰ�ڵ��ֵcurValue�Ƿ�����һ���ڵ��ֵ��ȡ������ȼ����������һ���ڵ��Ƿ���ȡ�
	//	ֱ�����ֲ���ȵģ������һ����ȵĽڵ��nextֵ������һ����ȵĽڵ����һ���ڵ��next��
	//	���head�ڵ������ȵĽڵ㣬��ô������ɾ���Ժ�Ҫע��ı������ͷ��㡣
	
	public static ListNode deleteRepeatNode(ListNode head) {
		
		//����һ�������ڵ��¼ɾ�������ǰһ���ڵ�
		ListNode preNode = null ;
		//����һ�������ڵ��¼ͷ���
		ListNode headNode = head ;
		//����һ����������Ƿ����ظ��Ľڵ�
		boolean hasRepeat = false ;
		
		//�п�
		if(head == null) {
			return headNode ;
		}
		
		
		//��head��ʼ��β�ڵ����
		while( head != null && head.getNext() != null) {
			
			//�����ж��ٸ��ظ��Ľڵ�
			while( head.getNext() != null && head.getValue() == head.getNext().getValue()) {
				head = head.getNext() ;
				hasRepeat = true ;
			}
			
			if (hasRepeat) {
				//����������ظ��Ľڵ�,��ô����ɾ������
				if(preNode == null) {
					headNode = head.getNext() ;
				}else {
					preNode.setNext(head.getNext());
				}
			}else {
				//��������ڣ���¼��ǰ�����ڵĽڵ㣬��ΪpreNode ;
				preNode = head ;
			}
			
			head = head.getNext() ;
			
		}
		
		return headNode ;
	}
	
	public static void showListNode(ListNode head) {
		
		while(head != null) {
			System.out.print("  "+ head.getValue());
			head = head.getNext() ;
		}
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode() ;
		ListNode node2 = new ListNode() ;
		ListNode node3 = new ListNode() ;
		ListNode node4 = new ListNode() ;
		ListNode node5 = new ListNode() ;
		ListNode head = null ;
		
		node1.setValue(1);
		node2.setValue(1);
		node3.setValue(3);
		node4.setValue(3);
		node5.setValue(5);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		head = deleteRepeatNode(node1) ;
		showListNode(head);
		
		node1.setValue(1);
		node2.setValue(2);
		node3.setValue(3);
		node4.setValue(4);
		node5.setValue(5);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		head = deleteRepeatNode(node1) ;
		showListNode(head);
		
		node1.setValue(1);
		node2.setValue(1);
		node3.setValue(1);
		node4.setValue(1);
		node5.setValue(1);
		
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		
		head = deleteRepeatNode(node1) ;
		showListNode(head);
		
		ListNode nullNode = null ;
		head = deleteRepeatNode(nullNode) ;
		showListNode(head);
		
	}
	

}
