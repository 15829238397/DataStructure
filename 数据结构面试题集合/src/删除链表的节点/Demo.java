package 删除链表的节点;

import java.awt.List;

/**
 * 
 * 题目要求：
 * 在O(1)的时间内删除链表节点
 * 给定单向链表的头和一个节点指针，定义的函数在O(1)内删除该节点。
 *
 */

public class Demo {

	//思路一
	//一般情况我们可以采用从头结点遍历的方式，得到要删除的节点i，之前的J节点，
	//将i的next属性值赋值给j的next属性。将i节点删除
	//那有没有另一种方法呢？答案是有的：
	//得到i的next值为K，将k的值复制到i的value属性，将k的next属性值复制到i的next属性。
	//但是如果，要删除的节点为尾节点没有下一个节点，那么只能采取从头结点遍历，的第一种方法。
	//还需注意，如果删除的链表里只有一个元素，那么删除完毕之后将链表清空。
	//编程过程忽略了检验删除元素是否存在在链表中，因为要达到O（1）,检验过程交给方法使用者来处理。
	public static ListNode deleteListNode(ListNode head , ListNode deleteNode) {
		
		//如果要删除的节点就是头结点
		if(head==deleteNode) {
			return head.getNext() ;
		}
		
		//如果删除节点不是尾节点那么可以用复制后面节点内容的方法。
		if( deleteNode.getNext() != null ) {
			
			ListNode after = deleteNode.getNext() ;
			deleteNode.setValue(after.getValue());
			deleteNode.setNext(after.getNext());
			return head;
		}
		
		//如果是尾节点那么需要从头结点遍历
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
	
	//测试代码
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
