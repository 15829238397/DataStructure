package ��β��ͷ��ӡ����;

import java.util.Stack;

/**
 * 
 * ����һ�������ͷ��㣬��β��ͷ��ӡ��ÿһ���ڵ�
 * 
 */
public class Demo {
	
	
	//˼·һ��
	//����stack�Ƚ���������ʣ�����������Ԫ��ѹ��ջ����ȫѹ����ٽ�Ԫ��һһȡ������Ϊ����
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
	
//	���õݹ���ɵ������
//	��ֹ����Ϊ��ǰ�ڵ�û����һ���ڵ㡣��headNode.getNext() == null
//	���õݹ�ﵽ���һ���ڵ㴦��Ȼ���������
public static void printListReceverse1(ListNode headNode) {
		
		if(headNode != null) {
			if(headNode.getNext() != null) {
				printListReceverse1(headNode.getNext()) ;
			}
		}
		
		System.out.println(headNode.getData());
	}
	
	
	
	//���Դ���
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
