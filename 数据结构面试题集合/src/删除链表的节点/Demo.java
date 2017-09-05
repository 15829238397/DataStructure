package ɾ������Ľڵ�;

import java.awt.List;

/**
 * 
 * ��ĿҪ��
 * ��O(1)��ʱ����ɾ������ڵ�
 * �������������ͷ��һ���ڵ�ָ�룬����ĺ�����O(1)��ɾ���ýڵ㡣
 *
 */

public class Demo {

	//˼·һ
	//һ��������ǿ��Բ��ô�ͷ�������ķ�ʽ���õ�Ҫɾ���Ľڵ�i��֮ǰ��J�ڵ㣬
	//��i��next����ֵ��ֵ��j��next���ԡ���i�ڵ�ɾ��
	//����û����һ�ַ����أ������еģ�
	//�õ�i��nextֵΪK����k��ֵ���Ƶ�i��value���ԣ���k��next����ֵ���Ƶ�i��next���ԡ�
	//���������Ҫɾ���Ľڵ�Ϊβ�ڵ�û����һ���ڵ㣬��ôֻ�ܲ�ȡ��ͷ���������ĵ�һ�ַ�����
	//����ע�⣬���ɾ����������ֻ��һ��Ԫ�أ���ôɾ�����֮��������ա�
	//��̹��̺����˼���ɾ��Ԫ���Ƿ�����������У���ΪҪ�ﵽO��1��,������̽�������ʹ����������
	public static ListNode deleteListNode(ListNode head , ListNode deleteNode) {
		
		//���Ҫɾ���Ľڵ����ͷ���
		if(head==deleteNode) {
			return head.getNext() ;
		}
		
		//���ɾ���ڵ㲻��β�ڵ���ô�����ø��ƺ���ڵ����ݵķ�����
		if( deleteNode.getNext() != null ) {
			
			ListNode after = deleteNode.getNext() ;
			deleteNode.setValue(after.getValue());
			deleteNode.setNext(after.getNext());
			return head;
		}
		
		//�����β�ڵ���ô��Ҫ��ͷ������
		while( head != null ) {
			if(head.getNext() == deleteNode) {
				break ;
			}
			head = head.getNext() ;
		}
		head.setNext(deleteNode.getNext());
		
		return head ;
	}
	
	public static void showListNode(ListNode head) {
		
		while(head != null) {
			System.out.print("  "+ head.getValue());
			head = head.getNext() ;
		}
		System.out.println();
		
	}
	
	//���Դ���
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode() ;
		ListNode node2 = new ListNode() ;
		ListNode node3 = new ListNode() ;
		ListNode head = null ;
		
		node1.setValue(1);
		node2.setValue(2);
		node3.setValue(3);
		
		node1.setNext(node2);
		node2.setNext(node3);
		showListNode(node1) ;
		head = deleteListNode(node1, node2) ;
		showListNode(head) ;
		head = deleteListNode(head, node2) ;
		showListNode(head) ;
		head = deleteListNode(head, node1) ;
		showListNode(head) ;
	}
	
}
