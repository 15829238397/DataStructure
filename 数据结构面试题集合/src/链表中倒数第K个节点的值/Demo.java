package 链表中倒数第K个节点的值;

import 删除链表的节点.ListNode;

/**
 * 题目要求：
 * 现在有一个链表，要求得到倒数第K节点的值。
 *
 */
public class Demo {

	//思路分析：
	//题目要求得到倒数第k个值，那么我们可以选用一个辅助缓存，辅助计数器
	//当遍历的位置到达第k个的时候，将头结点存入辅助缓存，从此与遍历一同前进，
	//当遍历到尾节点的时候，辅助缓存就是倒数第k个。
	public static int getReverseOrderOfK(ListNode listNode , int k) throws Exception {
		
		ListNode temp = listNode ;
		int count = 0 ;
		
		if(k<0) {
			throw new Exception("检索值不能为负数") ;
		}
		
		if(listNode == null ) {
			throw new Exception("链表为空") ;
		}
		
		while(listNode != null && listNode.getNext() != null ) {
			
			listNode = listNode.getNext() ;
			count ++ ;
			if( count > k -1 ) {
				temp = temp.getNext() ;
			}
			System.out.println(temp.getValue() + "与" + listNode.getValue());
		}
		
		if(count < k-1 ) {
			throw new Exception("链表长度小于" + k) ;
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
