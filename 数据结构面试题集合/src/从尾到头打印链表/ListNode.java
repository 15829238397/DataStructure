package 从尾到头打印链表;

public class ListNode {

	private Object data = null ;
	private ListNode next = null ;
	private ListNode pre = null ;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
		next.setPre(this);
	}
	public ListNode getPre() {
		return pre;
	}
	public void setPre(ListNode pre) {
		this.pre = pre;
	}
	
	
	
}
