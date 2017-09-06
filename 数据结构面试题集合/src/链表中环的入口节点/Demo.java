package 链表中环的入口节点;

import java.util.EmptyStackException;

import 删除链表的节点.ListNode;

/**
 * 题目要求：
 * 找到链表中的环的入口节点
 *
 */
public class Demo {

	//思路一：
	//要得到链表中的环的入口节点，那么我们首先需要确定链表中是否存在环。
	//这一步我们可以借用两个假指针来检验，我们使两个假指针同时从头结点出发，指针A一次走两步，指针B一次走一步
	//若两指针最后相遇那么我们可以确定存在环，若是在遍历过程中达到了链表尾节点，那么我们可以断定没有环。
	//如果存在环，那么相遇点一定在环内，我们可以让某一假指针从相遇点出发。等再次到达相遇点所走的步数就是换内节点数量。
	//得知上述信息后，我们可以寻找环的入口了
	//假设得到的环内节点是n,那么，定义两个节点，其中一个先走n步，然后两者一起出发，等两个节点相遇时，那么相遇点就是环入口。
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
		
		//判断是否有环存在
		while( b != null && b.getNext() !=null ) {
			b = b.getNext().getNext() ;
			a = a.getNext() ;
			
			if(b == a) {
				hasSycle = true ;
				break ;
			}
		}
		
		//不存在环抛出异常
		if(!hasSycle) {
			throw new Exception("链表中不存在环") ;
		}
		
		//计算环中节点数量
		nodeNumOfSycle = 1 ;
		b = b.getNext() ;
		while( a != b ) {
			b = b.getNext() ;
			nodeNumOfSycle ++ ;
		}
		
		//找到环入口
		a = head ;
		b = head ;
		//让a先走
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
