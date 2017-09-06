package 删除重复的节点;

import 删除链表的节点.ListNode;

/**
 * 题目要求：
 * 删除链表中重复的节点。
 * 重复的节点：
 * 当前节点的值与下一个节点的值相等，那么称这两个节点为重复的节点
 * 
 */
public class Demo {
	
	//思路一
	//	假设该链表为2、3、3、4、4、5
	//	删除完毕之后变为2、5
	//	那么如果是2、2、5、6
	//	删除完毕之后成为5、6。这个时候需要改变头结点，所以我们必须返回新的头结点
	//	另外还需要考虑的是如果是2、2、2
	//	那么删除完毕之后，链表为空。
	//	情况分析完毕，现在我们来看如何对重复的节点进行删除。
	//	首先从头结点开始遍历，检查当前节点的值curValue是否与下一个节点的值相等。如果相等继续检查再下一个节点是否相等。
	//	直到发现不相等的，将最后一个相等的节点的next值赋给第一个相等的节点的上一个节点的next。
	//	如果head节点就是相等的节点，那么我们在删除以后要注意改变链表的头结点。
	
	public static ListNode deleteRepeatNode(ListNode head) {
		
		//定义一个辅助节点记录删除区间的前一个节点
		ListNode preNode = null ;
		//定义一个辅助节点记录头结点
		ListNode headNode = head ;
		//定义一个辅助标记是否有重复的节点
		boolean hasRepeat = false ;
		
		//判空
		if(head == null) {
			return headNode ;
		}
		
		
		//从head开始往尾节点遍历
		while( head != null && head.getNext() != null) {
			
			//遍历有多少个重复的节点
			while( head.getNext() != null && head.getValue() == head.getNext().getValue()) {
				head = head.getNext() ;
				hasRepeat = true ;
			}
			
			if (hasRepeat) {
				//如果存在了重复的节点,那么进行删除处理
				if(preNode == null) {
					headNode = head.getNext() ;
				}else {
					preNode.setNext(head.getNext());
				}
			}else {
				//如果不存在，记录当前不存在的节点，作为preNode ;
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
