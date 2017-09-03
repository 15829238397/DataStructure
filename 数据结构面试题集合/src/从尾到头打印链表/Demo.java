package 从尾到头打印链表;

import java.util.Stack;

/**
 * 
 * 输入一个链表的头结点，从尾到头打印出每一个节点
 * 
 */
public class Demo {
	
	
	//思路一：
	//利用stack先进后出的性质，将链表所有元素压入栈，完全压入后，再将元素一一取出，即为倒序。
	public static void printListReceverse(ListNode headNode) {
		
		Stack<ListNode> stack = new Stack<ListNode>() ;
		
		while(headNode != null) {
			stack.push(headNode);
			headNode = headNode.getNext() ;
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().getData());
		}
		
	}
	
//	利用递归完成倒序输出
//	终止条件为当前节点没有下一个节点。即headNode.getNext() == null
//	利用递归达到最后一个节点处，然后倒序输出。
public static void printListReceverse1(ListNode headNode) {
		
		if(headNode != null) {
			if(headNode.getNext() != null) {
				printListReceverse1(headNode.getNext()) ;
			}
		}
		
		System.out.println(headNode.getData());
	}
	
	
	
	//测试代码
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode() ;
		ListNode node2 = new ListNode() ;
		ListNode node3 = new ListNode() ;
		
		node1.setData(1);
		node2.setData(2);
		node3.setData(3);
		
		node1.setNext(node2);
		node2.setNext(node3);
		
		printListReceverse(node1) ;
		
		System.out.println("----------------------------------------------------");
		
		printListReceverse1(node1) ;
		
	}
	

}
